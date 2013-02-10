package org.fractalstudio.jcollada.controllers;

import org.fractalstudio.flatmath.Matrix4x4;

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
public class Skin {

    /**
     *
     */
    private String source;
    /**
     *
     */
    private Matrix4x4 bindShapeMatrix;
    /**
     *
     */
    private Joints joints;
    /**
     *
     */
    private VertexWeights vertexWeights;

    /**
     *
     * @param source
     */
    public Skin(String source) {
        this.source = source;
        joints = new Joints();
        vertexWeights = new VertexWeights();
    }

    /**
     *
     */
    public VertexWeights getVertexWeights() {
        return vertexWeights;
    }

    /**
     *
     */
    public Joints getJoints() {
        return joints;
    }

    /**
     *
     * @return
     */
    public String getSource() {
        return source;
    }

    /**
     *
     * @return
     */
    public Matrix4x4 getBindShapeMatrix() {
        return bindShapeMatrix;
    }

    /**
     *
     * @param bindShapeMatrix
     */
    public void setBindShapeMatrix(Matrix4x4 bindShapeMatrix) {
        this.bindShapeMatrix = bindShapeMatrix;
    }
}
