/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.dataflow;

import java.util.LinkedList;

/**
 *
 * @author Meanz
 */
public class DataSource {

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
    public DataSource(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     */
    public String getId() {
        return id;
    }

    /**
     *
     */
    public String getName() {
        return name;
    }
}
