package org.fractalstudio.jcollada.controllers;

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
public class Controller {

    /**
     *
     */
    private String id;
    /**
     *
     */
    private String name;
    /**
     * A list of skins
     */
    private LinkedList<Skin> skins = new LinkedList<>();

    /**
     *
     * @param id
     * @param name
     */
    public Controller(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     */
    public void addSkin(Skin skin) {
        skins.add(skin);
    }

    /**
     *
     */
    public LinkedList<Skin> getSkins() {
        return skins;
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
