/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada;

import org.fractalstudio.jcollada.library_geometries.GeometryLibrary;

/**
 *
 * @author Meanz
 */
public class ColladaDocument {

    /**
     * The geometry library
     */
    private GeometryLibrary geometryLibrary;

    /**
     *
     */
    public ColladaDocument() {
        geometryLibrary = new GeometryLibrary();
    }

    /**
     *
     */
    public GeometryLibrary getGeometryLibrary() {
        return geometryLibrary;
    }
}
