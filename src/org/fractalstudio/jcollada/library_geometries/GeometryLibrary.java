/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.library_geometries;

import java.util.HashMap;
import org.fractalstudio.jcollada.ColladaLibrary;
import org.fractalstudio.jcollada.dataflow.DataSource;
import org.fractalstudio.jcollada.dataflow.datatype.DataArray;
import org.fractalstudio.jcollada.dataflow.datatype.FloatArray;

/**
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
            ((FloatArray)currentDataArray).setFloats(parseFloats(getElementText(), currentDataArray.getCount()));
            currentDataSource.setDataArray(currentDataArray);
            currentDataArray = null;
        } else if (getElementName().equals("Name_array") && getParentName().equals("source")) {
            throw new UnsupportedOperationException("Name Array is not supported for this source.");
        } else if (getElementName().equals("Int_array") && getParentName().equals("source")) {
            throw new UnsupportedOperationException("Int Array is not supported for this source.");
        }
    }
}
