/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada;

import java.util.LinkedList;
import org.fractalstudio.jcollada.dataflow.DataSource;

/**
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
    private LinkedList<DataSource> sources = new LinkedList<>();

    /**
     *
     * @param id
     */
    public Geometry(String id) {
        this.id = id;
    }
    
    /**
     * 
     */
    

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }
}
