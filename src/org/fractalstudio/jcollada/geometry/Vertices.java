package org.fractalstudio.jcollada.geometry;

import org.fractalstudio.jcollada.dataflow.InputPipeContainer;
import java.util.LinkedList;
import org.fractalstudio.jcollada.dataflow.InputPipe;

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
public class Vertices extends InputPipeContainer {

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
    public Vertices(String id, String name) {
        this.id = id;
        this.name = name;
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
