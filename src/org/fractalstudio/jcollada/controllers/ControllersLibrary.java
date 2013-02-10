package org.fractalstudio.jcollada.controllers;

import java.util.LinkedList;
import org.fractalstudio.jcollada.ColladaLibrary;
import org.fractalstudio.jcollada.dataflow.DataSource;
import org.fractalstudio.jcollada.dataflow.InputPipe;
import org.fractalstudio.jcollada.dataflow.datatype.DataArray;
import org.fractalstudio.jcollada.dataflow.datatype.FloatArray;
import org.fractalstudio.jcollada.dataflow.datatype.NameArray;

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
public class ControllersLibrary extends ColladaLibrary {

    /**
     *
     */
    private LinkedList<Controller> controllers = new LinkedList<>();

    /**
     *
     * @return
     */
    public LinkedList<Controller> getControllers() {
        return controllers;
    }
    /**
     *
     */
    private Controller currentController;
    /**
     *
     */
    private Skin currentSkin;
    /**
     *
     */
    private DataSource currentSource;
    /**
     *
     */
    private DataArray currentDataArray;

    /**
     *
     */
    @Override
    public void parseElementStart() {

        if (getElementName().equals("controller")) {
            currentController = new Controller(getAttribute("id"), getAttribute("name"));
            controllers.add(currentController);
        } else if (getElementName().equals("skin")) {
            currentSkin = new Skin(getAttribute("source"));
            currentController.addSkin(currentSkin);
        } else if (getElementName().equals("source")) {
            currentSource = new DataSource(getAttribute("id"), getAttribute("name"));
        } else if (getElementName().equals("Name_array") || getElementName().equals("float_array")) {
            String _id = getAttribute("id");
            String _name = getAttribute("name");
            String _count = getAttribute("count");
            int count = -1;
            if (_count != null) {
                count = Integer.parseInt(_count);
            }

            if (getElementName().equals("Name_array")) {
                currentDataArray = new NameArray(_id, _name, count);
            }
            if (getElementName().equals("float_array")) {
                String _digits = getAttribute("digits");
                String _magnitude = getAttribute("magnitude");

                short digits = -1;
                short magnitude = -1;

                if (_digits != null) {
                    digits = Short.parseShort(_digits);
                }
                if (_magnitude != null) {
                    magnitude = Short.parseShort(_magnitude);
                }

                currentDataArray = new FloatArray(_id, _name, count, digits, magnitude);
            }
        } else if (getElementName().equals("input")) {
            String _semantic = getAttribute("semantic");
            String _source = getAttribute("source");
            String _offset = getAttribute("offset");
            String _set = getAttribute("set");

            int offset = -1;
            int set = -1;

            if (_offset != null) {
                offset = Integer.parseInt(_offset);
            }
            if (_set != null) {
                set = Integer.parseInt(_set);
            }
            InputPipe inputPipe = new InputPipe(_semantic, _source, offset, set);

            if (getParentName().equals("joints")) {
                currentSkin.getJoints().addInputPipe(inputPipe);
            } else if (getParentName().equals("vertex_weights")) {
                currentSkin.getVertexWeights().addInputPipe(inputPipe);
            }
        } else if (getElementName().equals("vertex_weights")) {
            String _count = getAttribute("count");
            int count = -1;
            if (_count != null) {
                count = Integer.parseInt(_count);
            }
            currentSkin.getVertexWeights().setCount(count);
        }

    }

    /**
     *
     */
    @Override
    public void parseElementEnd() {
        if (getElementName().equals("controller")) {
            currentController = null;
        } else if (getElementName().equals("skin")) {
            currentSkin = null;
        } else if (getElementName().equals("bind_shape_matrix")) {
            currentSkin.setBindShapeMatrix(parseMatrix4x4(getElementText()));
        } else if (getElementName().equals("Name_array")) {
            ((NameArray) currentDataArray).setNames(parseNames(getElementText(), currentDataArray.getCount()));
        } else if (getElementName().equals("float_array")) {
            ((FloatArray) currentDataArray).setFloats(parseFloats(getElementText(), currentDataArray.getCount()));
        } else if (getElementName().equals("source")) {
            currentSource.setDataArray(currentDataArray);
        } else if (getElementName().equals("vcount") && getParentName().equals("vertex_weights")) {
            /**
             * Parse vcounts's *
             */
            currentSkin.getVertexWeights().setVcount(parseInts(getElementText(), currentSkin.getVertexWeights().getCount()));
        } else if (getElementName().equals("v") && getParentName().equals("vertex_weights")) {
            /**
             * Count them vcounts
             */
            int tot = 0;
            for (int i = 0; i < currentSkin.getVertexWeights().getCount(); i++) {
                tot += currentSkin.getVertexWeights().getVcount()[i] * 2;
            }
            currentSkin.getVertexWeights().setV(parseInts(getElementText(), tot));
        }
    }
}
