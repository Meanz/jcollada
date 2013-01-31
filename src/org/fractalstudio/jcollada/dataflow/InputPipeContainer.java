package org.fractalstudio.jcollada.dataflow;

import java.util.Collection;
import java.util.HashMap;
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
public abstract class InputPipeContainer {

    /**
     *
     */
    private HashMap<String, InputPipe> inputPipes = new HashMap<>();

    /**
     *
     * @param inputPipe
     */
    public void addInputPipe(InputPipe inputPipe) {
        inputPipes.put(inputPipe.getSemantic(), inputPipe);
    }

    /**
     *
     * @param semantic
     * @return
     */
    public InputPipe getInputPipe(String semantic) {
        return inputPipes.get(semantic);
    }

    /**
     *
     * @return
     */
    public Collection<InputPipe> getInputPipes() {
        return inputPipes.values();
    }
}
