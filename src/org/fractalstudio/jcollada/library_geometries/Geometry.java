/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.library_geometries;

import java.util.LinkedList;
import org.fractalstudio.jcollada.ColladaElement;
import org.fractalstudio.jcollada.dataflow.DataSource;
import org.fractalstudio.jcollada.dataflow.InputPipe;

/**
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
public class Geometry extends ColladaElement {

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
    private LinkedList<DataSource> sources = new LinkedList<>();
    /**
     *
     */
    private LinkedList<InputPipe> inputPipes = new LinkedList<>();

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
     */
    public void addDataSource(DataSource source) {
        sources.add(source);
    }

    /**
     *
     * @return
     */
    @Override
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
