package org.fractalstudio.jcollada.geometry.primitives;

import java.util.LinkedList;
import org.fractalstudio.jcollada.dataflow.InputPipe;
import org.fractalstudio.jcollada.dataflow.InputPipeContainer;

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
public abstract class PrimitiveElement extends InputPipeContainer {

    /**
     *
     */
    private String name;
    /**
     *
     */
    private int count;
    /**
     *
     */
    private String material;
    /**
     *
     */
    private PrimitiveType type;

    /**
     *
     * @param type
     */
    public PrimitiveElement(String name, int count, String material, PrimitiveType type) {
        this.name = name;
        this.count = count;
        this.material = material;
        this.type = type;
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
    public int getCount() {
        return count;
    }

    /**
     *
     * @return
     */
    public String getMaterial() {
        return material;
    }

    /**
     *
     * @return
     */
    public PrimitiveType getType() {
        return type;
    }

    /**
     *
     * @todo revise this is ugly
     *
     * @return
     */
    public TrianglesPrimitive toTriangles() {
        return (TrianglesPrimitive) this;
    }
}
