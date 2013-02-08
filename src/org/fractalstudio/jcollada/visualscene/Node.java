package org.fractalstudio.jcollada.visualscene;

import java.util.LinkedList;

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
public class Node {

    /**
     *
     */
    private String id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String sid;
    /**
     *
     */
    private NodeType nodeType;
    /**
     *
     */
    private String layer;
    /**
     *
     */
    private Transform transform;
    /**
     *
     */
    private LinkedList<GeometryInstance> geometryInstances = new LinkedList<>();
    /**
     * 
     */
    private LinkedList<ControllerInstance> controllerInstances = new LinkedList<>();

    /**
     *
     * @param id
     * @param name
     * @param sid
     * @param nodeType
     * @param layer
     */
    public Node(String id, String name, String sid, NodeType nodeType, String layer) {
        this.id = id;
        this.name = name;
        this.sid = sid;
        this.nodeType = nodeType;
        this.layer = layer;
        transform = new Transform();
    }
    
    /**
     * 
     */
    public void addControllerInstance(ControllerInstance instance) {
        controllerInstances.add(instance);
    }
    
    /**
     * 
     * @return
     */
    public LinkedList<ControllerInstance> getControllerInstances() {
        return controllerInstances;
    }

    /**
     *
     * @param instance
     */
    public void addGeometryInstance(GeometryInstance instance) {
        geometryInstances.add(instance);
    }

    /**
     *
     * @return
     */
    public LinkedList<GeometryInstance> getGeometryInstances() {
        return geometryInstances;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getSid() {
        return sid;
    }

    /**
     *
     * @return
     */
    public NodeType getNodeType() {
        return nodeType;
    }

    /**
     *
     * @return
     */
    public String getLayer() {
        return layer;
    }

    /**
     *
     * @return
     */
    public Transform getTransform() {
        return transform;
    }
}
