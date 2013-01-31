/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada;

import java.nio.FloatBuffer;
import org.xml.sax.Attributes;

/**
 *
 * @author Meanz
 */
public abstract class ColladaLibrary {

    /**
     *
     */
    private String elementName;
    /**
     *
     */
    private String parentElementName;
    /**
     *
     */
    private String elementText;
    /**
     *
     */
    private Attributes elementAttributes;

    /**
     *
     */
    public ColladaLibrary() {
        elementName = null;
        parentElementName = null;
        elementText = null;
        elementAttributes = null;
    }

    /**
     *
     * @param elementName
     * @param parentElementName
     * @param elementAttributes
     */
    public void parseElementStart(String elementName, String parentElementName, Attributes elementAttributes) {
        this.elementText = null;
        this.elementName = elementName;
        this.parentElementName = parentElementName;
        this.elementAttributes = elementAttributes;
        parseElementStart();
    }

    /**
     *
     * @param elementName
     * @param parentElementName
     * @param elementText
     */
    public void parseElementEnd(String elementName, String parentElementName, String elementText) {
        this.elementAttributes = null;
        this.elementName = elementName;
        this.parentElementName = parentElementName;
        this.elementText = elementText;
        parseElementEnd();
    }

    /**
     *
     */
    public String getElementName() {
        return elementName;
    }

    /**
     *
     */
    public String getParentName() {
        return parentElementName;
    }

    /**
     *
     * @return
     */
    public String getElementText() {
        return elementText;
    }

    /**
     *
     * @param attributes
     * @param name
     * @return
     */
    public String getAttribute(String name) {
        if (elementAttributes == null) {
            /* @todo add proper error handling */
            throw new RuntimeException("Attributes == null");
        }
        int index = elementAttributes.getIndex(name);
        if (index == -1) {
            return null;
        } else {
            return elementAttributes.getValue(index);
        }
    }

    /**
     * Helper functions
     */
    /**
     * Parse floats
     */
    public static float[] parseFloats(String float_array, int count) {
        float[] floats = new float[count];
        String[] splits = float_array.trim().split("\\s");
        for (int i = 0; i < splits.length; i++) {
            floats[i] = Float.parseFloat(splits[i]);
        }
        return floats;
    }

    /**
     * Parse names
     */
    public static String[] parseNames(String name_array, int count) {
        String[] names = new String[count];
        String[] splits = name_array.trim().split("\\s");
        for (int i = 0; i < splits.length; i++) {
            names[i] = splits[i];
        }
        return names;
    }

    /**
     *
     */
    /*private static Matrix4f parseMatrix4f(String matrix) {
     FloatBuffer floats = BufferUtils.createFloatBuffer(4 * 4);
     String[] splits = matrix.split("\\s");
     for (int i = 0; i < splits.length; i++) {
     floats.put(Float.parseFloat(splits[i]));
     }
     Matrix4f mat = new Matrix4f();
     return (Matrix4f) mat.loadTranspose((FloatBuffer) floats.flip());
     }*/
    
    /**
     * Parse ints
     */
    public static int[] parseInts(String int_array, int count) {
        int[] ints = new int[count];
        try {
            String[] splits = int_array.trim().split("\\s");
            for (int i = 0; i < splits.length; i++) {
                ints[i] = Integer.parseInt(splits[i]);
            }
        } catch (Exception ex) {
            String[] splits = int_array.trim().split("\\s");
            System.err.println("Expected count: " + count + " split count: " + splits.length);
            ex.printStackTrace();
        }
        return ints;
    }

    /**
     *
     */
    public abstract void parseElementStart();

    /**
     *
     */
    public abstract void parseElementEnd();
}
