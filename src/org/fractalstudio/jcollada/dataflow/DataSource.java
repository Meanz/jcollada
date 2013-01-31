/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.dataflow;

import org.fractalstudio.jcollada.dataflow.datatype.DataArray;

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
    private DataArray dataArray;

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
    public void setDataArray(DataArray dataArray) {
        this.dataArray = dataArray;
    }

    /**
     *
     */
    public DataArray getDataArray() {
        return dataArray;
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
