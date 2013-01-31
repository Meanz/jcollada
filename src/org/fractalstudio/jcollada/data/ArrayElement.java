/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.data;

/**
 *
 * @author Meanz
 */
public abstract class ArrayElement {

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
    private int count;

    /**
     *
     * @param id
     * @param name
     * @param count
     */
    public ArrayElement(String id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
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

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }
}
