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
public class VisualScene {

    /**
     *
     */
    private LinkedList<Node> nodes = new LinkedList<>();
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
     * @param id
     * @param name
     */
    public VisualScene(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @param node
     */
    public void addNode(Node node) {
        this.nodes.add(node);
    }

    /**
     *
     * @return
     */
    public LinkedList<Node> getNodes() {
        return nodes;
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
}
