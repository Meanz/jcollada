/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada;

/**
 *
 * @author Meanz
 */
public class JCollada {

    public static ColladaDocument parseDocument(String documentName) {
        ColladaParser colladaParser = new ColladaParser();
        ColladaDocument colladaDocument = colladaParser.parse(documentName);
        return colladaDocument;
    }
}
