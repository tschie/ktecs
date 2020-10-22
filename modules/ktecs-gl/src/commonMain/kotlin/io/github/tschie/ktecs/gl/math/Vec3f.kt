package io.github.tschie.ktecs.gl.math

/**
 * Creates a 3-vector of floats with the given components.
 *
 * @param x component
 * @param y component
 * @param z component
 */
data class Vec3f(val x: Float = 0.0f, val y: Float = 0.0f, val z: Float = 0.0f) {
    constructor(xyz: Float) : this(xyz, xyz, xyz)
}

/**
 * Subtracts a vector from this vector.
 *
 * @return the difference
 */
operator fun Vec3f.minus(v: Vec3f) : Vec3f {
    return Vec3f(x - v.x, y - v.y, z - v.z)
}

/**
 * Adds a vector to this vector.
 *
 * @param v the vector to be added
 * @return the sum
 */
operator fun Vec3f.plus(v: Vec3f) : Vec3f {
    return Vec3f(x + v.x, y + v.y, z + v.z)
}

/**
 * Multiplies this vector by a scalar.
 *
 * @param s the scalar to be multiplied by
 * @return the product
 */
operator fun Vec3f.times(s: Float) : Vec3f {
    return Vec3f(x * s, y * s, z * s)
}

/**
 * Divides this vector by a scalar.
 *
 * @param s the scalar to be divided by
 * @return the quotient
 */
operator fun Vec3f.div(s: Float) : Vec3f {
    return Vec3f(x / s, y / s, z / s)
}

/**
 * Takes the remainder of a division by a scalar on all vector components.
 *
 * @param s the scalar divisor
 * @return the remainder
 */
operator fun Vec3f.rem(s: Float) : Vec3f {
    return Vec3f(x % s, y % s, z % s)
}

/**
 * Creates an array of the vector's components.
 *
 * @return array of vector's components
 */
fun Vec3f.toArray() : Array<Float> = arrayOf(this.x, this.y, this.z)
