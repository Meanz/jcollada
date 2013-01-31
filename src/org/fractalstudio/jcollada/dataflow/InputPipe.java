/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.dataflow;

/**
 *
 * @author Meanz
 */
public class InputPipe {

    /**
     *
     */
    private String semantic;
    /**
     *
     */
    private DataSource source;

    /**
     *
     * @param semantic
     * @param source
     */
    public InputPipe(String semantic, DataSource source) {
        this.semantic = semantic;
        this.source = source;
    }

    /**
     *
     */
    public String getSemantic() {
        return semantic;
    }

    /**
     *
     */
    public DataSource getSource() {
        return source;
    }
}
