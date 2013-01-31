package org.fractalstudio.jcollada.library_geometries;

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
public class Vertices {

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
    private LinkedList<InputPipe> inputPipes = new LinkedList<>();

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
     */
    public void addInputPipe(InputPipe inputPipe) {
        inputPipes.add(inputPipe);
    }

    /**
     *
     */
    public LinkedList<InputPipe> getInputPipes() {
        return inputPipes;
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