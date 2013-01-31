/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.data;

/**
 *
 * @author Meanz
 */
public class FloatArray extends ArrayElement {

    /**
     *
     */
    private float[] floats;
    /**
     *
     */
    private short digits;
    /**
     *
     */
    private short magnitude;

    /**
     *
     * @param id
     * @param name
     * @param count
     * @param digits
     * @param magnitude
     */
    public FloatArray(String id, String name, int count, short digits, short magnitude) {
        super(id, name, count);
        this.digits = digits;
        this.magnitude = magnitude;
    }

    /**
     *
     */
    public float[] getFloats() {
        return floats;
    }

    /**
     *
     */
    public short getDigits() {
        return digits;
    }

    /**
     *
     */
    public short getMagnitude() {
        return magnitude;
    }
}
