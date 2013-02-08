package org.fractalstudio.jcollada.visualscene;

import java.util.LinkedList;
import org.fractalstudio.jcollada.ColladaLibrary;

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
public class VisualSceneLibrary extends ColladaLibrary {

    /**
     *
     */
    private LinkedList<VisualScene> visualScenes = new LinkedList<>();
    /**
     *
     */
    private VisualScene currentVisualScene;
    /**
     *
     */
    private Node currentNode;
    /**
     *
     */
    private ControllerInstance currentControllerInstance;
    /**
     *
     */
    private GeometryInstance currentGeometryInstance;

    /**
     *
     * @return
     */
    public LinkedList<VisualScene> getVisualScenes() {
        return visualScenes;
    }

    /**
     *
     */
    @Override
    public void parseElementStart() {

        if (getElementName().equals("visual_scene")) {
            //Add a new visual scene object
            currentVisualScene = new VisualScene(getAttribute("id"), getAttribute("name"));
            visualScenes.add(currentVisualScene);
        } else if (getElementName().equals("node")) {
            String _id = getAttribute("id");
            String _name = getAttribute("name");
            String _sid = getAttribute("sid");
            String _type = getAttribute("type");
            String _layer = getAttribute("layer");

            currentNode = new Node(_id, _name, _sid, _type.equals("JOINT") ? NodeType.JOINT : NodeType.NODE, _layer);
            currentVisualScene.addNode(currentNode);
        } else if (getElementName().equals("instance_geometry")) {
        } else if (getElementName().equals("instance_controller")) {
            //Wtf is this shit bro
            String _sid = getAttribute("sid");
            String _name = getAttribute("name");
            String _url = getAttribute("url");

            currentControllerInstance = new ControllerInstance(_sid, _name, _url);
        }

    }

    /**
     *
     */
    @Override
    public void parseElementEnd() {

        if (getElementName().equals("visual_scene")) {
            currentVisualScene = null;
        } else if (getElementName().equals("matrix")) {
            //* Node Matrix *//
            currentNode.getTransform().setMatrix(parseMatrix4x4(getElementText()));
        } else if (getElementName().equals("translate")) {
            float[] floats = parseFloats(getElementText(), 3);
            currentNode.getTransform().translate(floats[0], floats[1], floats[2]);
        } else if (getElementName().equals("rotate")) {
            float[] floats = parseFloats(getElementText(), 4);
            currentNode.getTransform().rotate(floats[0], floats[1], floats[2], floats[3]);
        } else if (getElementName().equals("skeleton") && getParentName().equals("instance_controller")) {
            /**
             * We know what to do there. lol *
             */
            currentControllerInstance.addSkeleton(getElementText());
        }
    }
}
