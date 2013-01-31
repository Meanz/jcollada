package org.fractalstudio.jcollada.dataflow;

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
public class Param {

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
    private String type;
    /**
     *
     */
    private String semantic;

    /**
     *
     * @param name
     * @param sid
     * @param type
     * @param semantic
     */
    public Param(String name, String sid, String type, String semantic) {
        this.name = name;
        this.sid = sid;
        this.type = type;
        this.semantic = semantic;
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
    public String getType() {
        return type;
    }

    /**
     *
     * @return
     */
    public String getSemantic() {
        return semantic;
    }
}
