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
public class ControllerInstance {

    /**
     *
     */
    private String sid;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String url;
    /**
     *
     */
    private LinkedList<String> skeletons = new LinkedList<>();

    /**
     *
     * @param sid
     * @param name
     * @param url
     */
    public ControllerInstance(String sid, String name, String url) {
        this.sid = sid;
        this.name = name;
        this.url = url;
    }

    /**
     *
     * @param string
     */
    public void addSkeleton(String string) {
        skeletons.add(string);
    }

    /**
     *
     * @return
     */
    public LinkedList<String> getSkeletons() {
        return skeletons;
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
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }
}
