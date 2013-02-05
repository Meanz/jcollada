/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.dataflow;

import org.fractalstudio.jcollada.dataflow.uri.ColladaURI;

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
public class InputPipe {

    /**
     *
     */
    private String semantic;
    /**
     *
     */
    private String source;
    /**
     *
     */
    private int offset;
    /**
     *
     */
    private int set;
    /**
     *
     */
    private ColladaURI uri;

    /**
     *
     * @param semantic
     * @param source
     */
    public InputPipe(String semantic, String source, int offset, int set) {
        this.semantic = semantic;
        this.source = source;
        this.offset = offset;
        this.set = set;
    }

    /**
     *
     */
    public String getSemantic() {
        return semantic;
    }

    /**
     *
     */
    public String getSource() {
        return source;
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
    public int getSet() {
        return set;
    }

    /**
     *
     */
    public ColladaURI getSourceUri() {
        return uri;
    }
}
