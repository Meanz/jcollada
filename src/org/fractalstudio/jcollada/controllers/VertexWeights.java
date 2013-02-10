package org.fractalstudio.jcollada.controllers;

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
public class VertexWeights extends InputPipeContainer {

    /**
     *
     */
    private int[] v;
    /**
     *
     */
    private int[] vcount;
    /**
     *
     */
    private int count;

    /**
     * There is room for adding stuff heres :D
     */
    public VertexWeights() {
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
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     */
    public int[] getV() {
        return v;
    }

    /**
     *
     * @param v
     */
    public void setV(int[] v) {
        this.v = v;
    }

    /**
     *
     * @return
     */
    public int[] getVcount() {
        return vcount;
    }

    /**
     *
     * @param vcount
     */
    public void setVcount(int[] vcount) {
        this.vcount = vcount;
    }
}
