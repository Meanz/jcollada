/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.library_geometries;

import java.util.HashMap;
import org.fractalstudio.jcollada.ColladaLibrary;
import org.fractalstudio.jcollada.dataflow.Accessor;
import org.fractalstudio.jcollada.dataflow.DataSource;
import org.fractalstudio.jcollada.dataflow.InputPipe;
import org.fractalstudio.jcollada.dataflow.Param;
import org.fractalstudio.jcollada.dataflow.datatype.DataArray;
import org.fractalstudio.jcollada.dataflow.datatype.FloatArray;
import org.fractalstudio.jcollada.library_geometries.primitives.PrimitiveElement;
import org.fractalstudio.jcollada.library_geometries.primitives.TrianglesPrimitive;

/**
 * Copyright (C) 2013 Steffen Evensen
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Meanz
 */
public class GeometryLibrary extends ColladaLibrary {

    /**
     * The list geometries in this library
     */
    private HashMap<String, Geometry> geometries = new HashMap<>();
    /**
     *
     */
    private Geometry currentGeometry = null;
    /**
     *
     */
    private DataSource currentDataSource = null;
    /**
     *
     */
    private DataArray currentDataArray = null;
    /**
     *
     */
    private Accessor currentAccessor = null;
    /**
     *
     */
    private Vertices currentVertices = null;
    /**
     *
     */
    private PrimitiveElement currentPrimitive = null;

    /**
     *
     */
    @Override
    public void parseElementStart() {
        if (getElementName().equals("geometry")) {
            currentGeometry = new Geometry(getAttribute("id"), getAttribute("name"));
        } else if (getElementName().equals("mesh")) {
            /* we don't do anything here */
            return;
        } else if (getElementName().equals("convex_mesh")) {
            throw new UnsupportedOperationException("Convex Mesh is not supported by this parser.");
        } else if (getElementName().equals("spline")) {
            throw new UnsupportedOperationException("Spline Mesh is not supported by this parser.");
        } else if (getElementName().equals("source")) {
            currentDataSource = new DataSource(getAttribute("id"), getAttribute("name"));
        } else if (getElementName().equals("float_array")) {
            String _count = getAttribute("count");
            String _digits = getAttribute("digits");
            String _magnitude = getAttribute("magnitude");
            //-1 values for undefined
            int count = -1;
            short digits = -1;
            short magnitude = -1;
            //Parse values
            if (_count != null) {
                count = Integer.parseInt(_count);
            }
            if (_digits != null) {
                digits = Short.parseShort(_digits);
            }
            if (_magnitude != null) {
                magnitude = Short.parseShort(_magnitude);
            }
            //Create data array
            currentDataArray = new FloatArray(getAttribute("id"), getAttribute("name"), count, digits, magnitude);
        } else if (getElementName().equals("Name_array") && getParentName().equals("source")) {
            throw new UnsupportedOperationException("Name Array is not supported for this source.");
        } else if (getElementName().equals("Int_array") && getParentName().equals("source")) {
            throw new UnsupportedOperationException("Int Array is not supported for this source.");
        } else if (getElementName().equals("technique_common")) {
            //What to do here :D?
        } else if (getElementName().equals("accessor")) {
            /* @todo add error handling */
            String _count = getAttribute("count");
            String _offset = getAttribute("offset");
            String _stride = getAttribute("stride");
            String _source = getAttribute("source");

            int count = Integer.parseInt(_count);
            int offset = -1;
            int stride = -1;

            if (_offset != null) {
                offset = Integer.parseInt(_offset);
            }
            if (_stride != null) {
                stride = Integer.parseInt(_stride);
            }

            currentAccessor = new Accessor(count, offset, _source, stride);
        } else if (getElementName().equals("param") && getParentName().equals("accessor")) {
            currentAccessor.addParam(new Param(getAttribute("id"), getAttribute("sid"), getAttribute("type"), getAttribute("semantic")));
        } else if (getElementName().equals("vertices")) {
            currentVertices = new Vertices(getAttribute("id"), getAttribute("name"));
        } else if (getElementName().equals("input")) {
            InputPipe input = new InputPipe(getAttribute("semantic"), getAttribute("source"));

            if (getParentName().equals("vertices")) {
                currentVertices.addInputPipe(input);
            } else if (getParentName().equals("triangles")) {
                currentPrimitive.addInputPipe(input);
            }
        } else if (getElementName().equals("triangles")) {
            int count = Integer.parseInt(getAttribute("count"));
            currentPrimitive = new TrianglesPrimitive(getAttribute("id"), count, getAttribute("material"));
        }

    }

    /**
     *
     */
    @Override
    public void parseElementEnd() {
        if (getElementName().equals("geometry")) {
            geometries.put(currentGeometry.getId(), currentGeometry);
            currentGeometry = null;
        } else if (getElementName().equals("source")) {
            currentGeometry.addDataSource(currentDataSource);
            currentDataSource = null;
        } else if (getElementName().equals("float_array")) {
            //Create data array
            ((FloatArray) currentDataArray).setFloats(parseFloats(getElementText(), currentDataArray.getCount()));
            currentDataSource.setDataArray(currentDataArray);
            currentDataArray = null;
        } else if (getElementName().equals("Name_array") && getParentName().equals("source")) {
            throw new UnsupportedOperationException("Name Array is not supported for this source.");
        } else if (getElementName().equals("Int_array") && getParentName().equals("source")) {
            throw new UnsupportedOperationException("Int Array is not supported for this source.");
        } else if (getElementName().equals("p")) {
            int[] p = null;
            if (getParentName().equals("triangles")) {

                //@todo revise
                //I don't think this is fully correct
                int numPipes = currentPrimitive.getInputPipes().size();

                //@todo revise
                //*3 for triangles 
                p = parseInts(getElementText(), currentPrimitive.getCount() * numPipes * 3);
                ((TrianglesPrimitive) currentPrimitive).setP(p);
            }
        }
    }
}
