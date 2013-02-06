/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.flatmath;

import java.io.Serializable;
import java.nio.FloatBuffer;

/**
 * Basically a stupid typedef, to bad java doesn't support it :>
 *
 * @author Steffen
 */
public class Vec3 implements Serializable {

    private static final long serialVersionUID = 1L;
    public float x, y, z;

    /**
     * Constructor for Vec3.
     */
    public Vec3() {
        super();
    }

    /**
     * Constructor
     */
    public Vec3(float x, float y, float z) {
        set(x, y, z);
    }

    /*
     * (non-Javadoc) @see org.lwjgl.util.vector.WritableVector2f#set(float,
     * float)
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /*
     * (non-Javadoc) @see org.lwjgl.util.vector.WritableVec3#set(float,
     * float, float)
     */
    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @return the length squared of the vector
     */
    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    /**
     * @return the length of the vector
     */
    public final float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * Translate a vector
     *
     * @param x The translation in x
     * @param y the translation in y
     * @return this
     */
    public Vec3 translate(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    /**
     * Add a vector to another vector and place the result in a destination
     * vector.
     *
     * @param left The LHS vector
     * @param right The RHS vector
     * @param dest The destination vector, or null if a new vector is to be
     * created
     * @return the sum of left and right in dest
     */
    public static Vec3 add(Vec3 left, Vec3 right, Vec3 dest) {
        if (dest == null) {
            return new Vec3(left.x + right.x, left.y + right.y, left.z + right.z);
        } else {
            dest.set(left.x + right.x, left.y + right.y, left.z + right.z);
            return dest;
        }
    }

    /**
     * Subtract a vector from another vector and place the result in a
     * destination vector.
     *
     * @param left The LHS vector
     * @param right The RHS vector
     * @param dest The destination vector, or null if a new vector is to be
     * created
     * @return left minus right in dest
     */
    public static Vec3 sub(Vec3 left, Vec3 right, Vec3 dest) {
        if (dest == null) {
            return new Vec3(left.x - right.x, left.y - right.y, left.z - right.z);
        } else {
            dest.set(left.x - right.x, left.y - right.y, left.z - right.z);
            return dest;
        }
    }

    /**
     * The cross product of two vectors.
     *
     * @param left The LHS vector
     * @param right The RHS vector
     * @param dest The destination result, or null if a new vector is to be
     * created
     * @return left cross right
     */
    public static Vec3 cross(
            Vec3 left,
            Vec3 right,
            Vec3 dest) {

        if (dest == null) {
            dest = new Vec3();
        }

        dest.set(
                left.y * right.z - left.z * right.y,
                right.x * left.z - right.z * left.x,
                left.x * right.y - left.y * right.x);

        return dest;
    }

    /**
     * Negate a vector
     *
     * @return this
     */
    public Vec3 negate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    /**
     * Negate a vector and place the result in a destination vector.
     *
     * @param dest The destination vector or null if a new vector is to be
     * created
     * @return the negated vector
     */
    public Vec3 negate(Vec3 dest) {
        if (dest == null) {
            dest = new Vec3();
        }
        dest.x = -x;
        dest.y = -y;
        dest.z = -z;
        return dest;
    }

    /**
     * Normalise this vector and place the result in another vector.
     *
     * @param dest The destination vector, or null if a new vector is to be
     * created
     * @return the normalised vector
     */
    public Vec3 normalise(Vec3 dest) {
        float l = length();

        if (dest == null) {
            dest = new Vec3(x / l, y / l, z / l);
        } else {
            dest.set(x / l, y / l, z / l);
        }

        return dest;
    }

    /**
     * The dot product of two vectors is calculated as v1.x * v2.x + v1.y * v2.y
     * + v1.z * v2.z
     *
     * @param left The LHS vector
     * @param right The RHS vector
     * @return left dot right
     */
    public static float dot(Vec3 left, Vec3 right) {
        return left.x * right.x + left.y * right.y + left.z * right.z;
    }

    /**
     * Calculate the angle between two vectors, in radians
     *
     * @param a A vector
     * @param b The other vector
     * @return the angle between the two vectors, in radians
     */
    public static float angle(Vec3 a, Vec3 b) {
        float dls = dot(a, b) / (a.length() * b.length());
        if (dls < -1f) {
            dls = -1f;
        } else if (dls > 1.0f) {
            dls = 1.0f;
        }
        return (float) Math.acos(dls);
    }

    /*
     * (non-Javadoc) @see org.lwjgl.vector.Vector#load(FloatBuffer)
     */
    public Vec3 load(FloatBuffer buf) {
        x = buf.get();
        y = buf.get();
        z = buf.get();
        return this;
    }

    /*
     * (non-Javadoc) @see org.lwjgl.vector.Vector#scale(float)
     */
    public Vec3 scale(float scale) {

        x *= scale;
        y *= scale;
        z *= scale;

        return this;

    }

    /*
     * (non-Javadoc) @see org.lwjgl.vector.Vector#store(FloatBuffer)
     */
    public Vec3 store(FloatBuffer buf) {

        buf.put(x);
        buf.put(y);
        buf.put(z);

        return this;
    }

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sb = new StringBuilder(64);

        sb.append("Vec3[");
        sb.append(x);
        sb.append(", ");
        sb.append(y);
        sb.append(", ");
        sb.append(z);
        sb.append(']');
        return sb.toString();
    }

    /**
     * @return x
     */
    public final float getX() {
        return x;
    }

    /**
     * @return y
     */
    public final float getY() {
        return y;
    }

    /**
     * Set X
     *
     * @param x
     */
    public final void setX(float x) {
        this.x = x;
    }

    /**
     * Set Y
     *
     * @param y
     */
    public final void setY(float y) {
        this.y = y;
    }

    /**
     * Set Z
     *
     * @param z
     */
    public void setZ(float z) {
        this.z = z;
    }

    /*
     * (Overrides) @see org.lwjgl.vector.ReadableVec3#getZ()
     */
    public float getZ() {
        return z;
    }
}