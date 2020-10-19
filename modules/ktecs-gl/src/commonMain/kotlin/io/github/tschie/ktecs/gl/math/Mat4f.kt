package io.github.tschie.ktecs.gl.math

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
}

expect fun Mat4f.times(other: Mat4f) : Mat4f

expect fun Mat4f.transpose() : Mat4f

expect fun Mat4f.inverse() : Mat4f

expect fun perspective(aspect: Float, fov: Float, near: Float, far: Float) : Mat4f




