package org.fractalstudio.jcollada.visualscene;

import org.fractalstudio.flatmath.Matrix4x4;
import org.fractalstudio.flatmath.Vec3;

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
public class Transform {

    /**
     *
     */
    private Matrix4x4 transformMatrix = new Matrix4x4(); //Is this tha lwjgl matrix or an own custom one ?

    /**
     *
     */
    public Transform() {
    }

    /**
     *
     */
    public Matrix4x4 getMatrix() {
        return transformMatrix;
    }

    /**
     *
     */
    public void setMatrix(Matrix4x4 matrix) {
        this.transformMatrix = matrix;
    }

    /**
     *
     */
    public void translate(float x, float y, float z) {
        translate(new Vec3(x, y, z));
    }

    /**
     *
     */
    public void translate(Vec3 vec) {
        transformMatrix.translate(vec);
    }

    /*'
     * 
     */
    public void rotate(float x, float y, float z, float rot) {
        rotate(rot, new Vec3(x, y, z));
    }

    /**
     *
     */
    public void rotate(float angle, Vec3 rotation) {
        transformMatrix.rotate(angle, rotation);
    }
}
