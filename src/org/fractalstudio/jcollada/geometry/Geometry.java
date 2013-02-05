/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.geometry;

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
 * -> Geometry
 *
 * The <geometry> element categorizes the declaration of geometric information.
 * Geometry is a branch of mathematics that deals with the measurement,
 * properties, and relationships of points, lines, angles, surfaces, and solids.
 * The <geometry> element contains a declaration of a mesh, convex mesh, or
 * spline. There are many forms of geometric description. Computer graphics
 * hardware has been normalized, primarily, to accept vertex position
 * information with varying degrees of attribution (color, normals, etc.).
 * Geometric descriptions provide this vertex data with relative directness or
 * efficiency. Some of the more common forms of geometry are: • B-Spline •
 * Bézier • Mesh • NURBS • Patch This is by no means an exhaustive list.
 * Currently, COLLADA supports only polygonal meshes and splines.
 *
 * -> Mesh
 *
 * Meshes embody a general form of geometric description that primarily includes
 * vertex and primitive information. Vertex information is the set of attributes
 * associated with a point on the surface of the mesh. Each vertex includes data
 * for attributes such as: • Vertex position • Vertex color • Vertex normal •
 * Vertex texture coordinate The mesh also includes a description of how the
 * vertices are organized to form the geometric shape of the mesh. The mesh
 * vertices are collated into geometric primitives such as polygons, triangles,
 * or lines.
 *
 * @author Meanz
 */
public class Geometry {

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
    private Mesh mesh;

    /**
     *
     * @param id
     */
    public Geometry(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @param mesh
     */
    public void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    /**
     *
     * @return
     */
    public Mesh getMesh() {
        return mesh;
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
