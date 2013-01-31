/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.dataflow;

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
public class Accessor {

    /**
     *
     */
    private int count;
    /**
     *
     */
    private int offset = 0;
    /**
     *
     */
    private String source;
    /**
     *
     */
    private int stride = 1;
    /**
     *
     */
    private LinkedList<Param> params = new LinkedList<>();

    /**
     *
     * @param count
     * @param offset
     * @param source
     * @param stride
     */
    public Accessor(int count, int offset, String source, int stride) {
        this.count = count;
        this.offset = offset == -1 ? 0 : offset; //Set default to 0
        this.source = source;
        this.stride = stride == -1 ? 1 : stride; //Set default to 1
    }

    /**
     *
     */
    public void addParam(Param param) {
        params.add(param);
    }

    /**
     *
     */
    public LinkedList<Param> getParams() {
        return params;
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
    public int getOffset() {
        return offset;
    }

    /**
     *
     * @return
     */
    public String getSource() {
        return source;
    }

    /**
     *
     * @return
     */
    public int getStride() {
        return stride;
    }
}
