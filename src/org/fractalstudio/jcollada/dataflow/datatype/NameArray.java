/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.dataflow.datatype;

/**
 *
 * @author Meanz
 */
public class NameArray extends DataArray {

    /**
     *
     */
    private String[] names;

    /**
     *
     * @param id
     * @param name
     * @param count
     * @param minInclusive
     * @param maxInclusive
     */
    public NameArray(String id, String name, int count) {
        super(id, name, count);
    }

    /**
     *
     */
    public void setNames(String[] ints) {
        this.names = ints;
    }

    /**
     *
     */
    public String[] getNames() {
        return names;
    }
}