package org.fractalstudio.jcollada.geometry;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.fractalstudio.jcollada.dataflow.DataSource;
import org.fractalstudio.jcollada.dataflow.InputPipeContainer;
import org.fractalstudio.jcollada.geometry.primitives.PolylistArray;
import org.fractalstudio.jcollada.geometry.primitives.PrimitiveElement;
import org.fractalstudio.jcollada.geometry.primitives.TrianglesArray;

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
public class Mesh extends InputPipeContainer {

    /**
     * Provides the bulk of the mesh’s vertex data.
     */
    private HashMap<String, DataSource> sources = new HashMap<>();
    /**
     *
     */
    private LinkedList<PolylistArray> polylists = new LinkedList<>();
    /**
     *
     */
    private LinkedList<TrianglesArray> triangles = new LinkedList<>();
    /**
     * Describes the mesh-vertex attributes and establishes their topological
     * identity.
     */
    private Vertices vertices;

    /**
     *
     * @return
     */
    public LinkedList<PolylistArray> getPolylists() {
        return polylists;
    }

    /**
     *
     * @param polylist
     */
    public void addPolylist(PolylistArray polylist) {
        polylists.add(polylist);;
    }

    /**
     *
     * @return
     */
    public LinkedList<TrianglesArray> getTriangles() {
        return triangles;
    }

    /**
     *
     * @param triangle
     */
    public void addTriangles(TrianglesArray triangle) {
        triangles.add(triangle);
    }

    /**
     *
     */
    public void setVertices(Vertices vertices) {
        this.vertices = vertices;
    }

    /**
     *
     */
    public Vertices getVertices() {
        return vertices;
    }

    /**
     *
     */
    public void addDataSource(DataSource source) {
        sources.put(source.getId(), source);
    }

    /**
     *
     */
    public DataSource getDataSource(String id) {
        return sources.get(id);
    }

    /**
     *
     */
    public Collection<DataSource> getDataSources() {
        return sources.values();
    }
}
