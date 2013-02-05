/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada;

import org.fractalstudio.jcollada.effects.EffectsLibrary;
import org.fractalstudio.jcollada.geometry.GeometryLibrary;
import org.fractalstudio.jcollada.materials.MaterialLibrary;
import org.fractalstudio.jcollada.visualscene.VisualSceneLibrary;

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
public class ColladaDocument {

    /**
     * The geometry library
     */
    private GeometryLibrary geometryLibrary;
    /**
     * The visual scene library
     */
    private VisualSceneLibrary visualSceneLibrary;
    /**
     * The material library
     */
    private MaterialLibrary materialLibrary;
    /**
     *
     */
    private EffectsLibrary effectsLibrary;

    /**
     *
     */
    public ColladaDocument() {
        geometryLibrary = new GeometryLibrary();
        visualSceneLibrary = new VisualSceneLibrary();
        materialLibrary = new MaterialLibrary();
        effectsLibrary = new EffectsLibrary();
    }

    /**
     *
     */
    public EffectsLibrary getEffectsLibrary() {
        return effectsLibrary;
    }

    /**
     *
     */
    public MaterialLibrary getMaterialLibrary() {
        return materialLibrary;
    }

    /**
     *
     */
    public VisualSceneLibrary getVisualSceneLibrary() {
        return visualSceneLibrary;
    }

    /**
     *
     */
    public GeometryLibrary getGeometryLibrary() {
        return geometryLibrary;
    }
}
