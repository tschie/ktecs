package io.github.tschie.ktecs.gl.math

/**
 * A 4x4 matrix of floats. Defaults to a matrix of all zeros.
 *
 * @property elements elements of the matrix
 */
data class Mat4f(val elements: Array<Array<Float>> = Array(4) { FloatArray(4).toTypedArray() }) {

    constructor(elements: Array<Float>) : this(elements.toList().chunked(4).map { it.toTypedArray() }.toTypedArray())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Mat4f

        if (!elements.contentDeepEquals(other.elements)) return false

        return true
    }

    override fun hashCode(): Int {
        return elements.contentDeepHashCode()
    }

    operator fun get(i: Int) : Array<Float> = elements[i]

    operator fun get(i: Int, j: Int) : Float = elements[i][j]
}

/**
 * Multiplies another matrix by this matrix.
 *
 * @return a new matrix with the result of the multiplication
 */
expect fun Mat4f.times(other: Mat4f) : Mat4f

/**
 * Takes the transpose of this matrix.
 *
 * @return matrix transpose
 */
expect fun Mat4f.transpose() : Mat4f

/**
 * Takes the inverse of this matrix.
 *
 * @return matrix inverse
 */
expect fun Mat4f.inverse() : Mat4f

/**
 * Creates a perspective projection matrix.
 *
 * @param aspect aspect ratio; typically viewport width / height
 * @param fov field of view
 * @param near near clipping plane distance
 * @param far far clipping plane distance
 * @return perspective projection matrix
 */
expect fun perspective(aspect: Float, fov: Float, near: Float, far: Float) : Mat4f




