/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.dataflow.datatype;

/**
 *
 * @author Meanz
 */
public class IntArray extends DataArray {

    /**
     *
     */
    private int[] ints;
    /**
     *
     */
    private int minInclusive;
    /**
     *
     */
    private int maxInclusive;

    /**
     *
     * @param id
     * @param name
     * @param count
     * @param minInclusive
     * @param maxInclusive
     */
    public IntArray(String id, String name, int count, short minInclusive, short maxInclusive) {
        super(id, name, count);
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
    }

    /**
     *
     */
    public void setInts(int[] ints) {
        this.ints = ints;
    }

    /**
     *
     */
    public int[] getInts() {
        return ints;
    }

    /**
     *
     */
    public int getMinInclusive() {
        return minInclusive;
    }

    /**
     *
     */
    public int getMaxInclusive() {
        return maxInclusive;
    }
}