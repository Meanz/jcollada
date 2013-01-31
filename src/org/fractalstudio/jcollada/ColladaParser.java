/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada;

import java.util.Stack;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.fractalstudio.jcollada.geometry.GeometryLibrary;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Copyright (C) 2013 Steffen Evensen
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Meanz
 */
public class ColladaParser extends DefaultHandler {

    /**
     *
     */
    private ColladaDocument colladaDocument;
    /**
     *
     */
    private ColladaLibrary currentLibrary;
    /**
     * ML Specific
     */
    private final Stack<String> parentElements = new Stack<>();
    private StringBuilder characterBuffer = new StringBuilder();

    /**
     *
     * @param fileName
     * @param model
     */
    public ColladaParser() {
        colladaDocument = new ColladaDocument();
        currentLibrary = null;
    }

    /**
     *
     */
    public ColladaDocument parse(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(fileName, this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return colladaDocument;
    }

    /**
     *
     * @param uri
     * @param localName
     * @param name
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        //Rewind the character buffer
        characterBuffer.setLength(0);
        //Store our parent temporary
        String parent = parentElements.isEmpty() ? null : parentElements.peek();

        switch (name) {
            case "library_geometries":
                currentLibrary = colladaDocument.getGeometryLibrary();
                break;
            case "library_images":
                break;
            case "library_effects":
                break;
            case "library_controllers":
                break;
            case "library_visual_scenes":
                break;
            case "scene":
                break;
        }

        //If we are in a library order that library to be loaded
        if (currentLibrary != null) {
            currentLibrary.parseElementStart(name, parent, attributes);
        }

        //Add our element to the parent list
        parentElements.push(name);
    }

    /**
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName,
            String name) throws SAXException {
        this.parentElements.pop();
        String parent = this.parentElements.isEmpty()
                ? null
                : this.parentElements.peek();

        switch (name) {
            case "library_geometries":
            case "library_images":
            case "library_effects":
            case "library_controllers":
            case "library_visual_scenes":
            case "scene":
                currentLibrary = null;
                break;
        }

        //If we are in a library order that library to be loaded
        if (currentLibrary != null) {
            currentLibrary.parseElementEnd(name, parent, characterBuffer.toString().trim());
        }

    }

    /**
     *
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        characterBuffer.append(ch, start, length);
    }
}
