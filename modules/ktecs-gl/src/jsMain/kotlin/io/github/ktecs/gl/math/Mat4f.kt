package io.github.ktecs.gl.math

import org.khronos.webgl.Float32Array
import org.khronos.webgl.get

actual fun Mat4f.inverse(): Mat4f {
    val out = Mat4.create() as Float32Array
    Mat4.invert(out, this.toFloat32Array())
    return Mat4f(out.toArray())
}

actual fun perspective(aspect: Float, fov: Float, near: Float, far: Float): Mat4f {
    return Mat4f((
        Mat4.perspective(
            Mat4.create() as Float32Array,
            fov,
            aspect,
            near,
            far
        ) as Float32Array).toArray())
}

fun Float32Array.toArray() : Array<Float> {
    val array = FloatArray(this.length)
    for (i in 0 until this.length) {
        array[i] = this[i]
    }
    return array.toTypedArray()
}

actual operator fun Mat4f.times(other: Mat4f): Mat4f {
    return Mat4f(
        (Mat4.multiply(
            Mat4.create() as Float32Array,
            this.toFloat32Array(),
            other.toFloat32Array()
        ) as Float32Array).toArray()
    )
}

actual fun Mat4f.transpose(): Mat4f {
    val out = Mat4.create() as Float32Array
    Mat4.transpose(out, this.toFloat32Array())
    return Mat4f(out.toArray())
}

fun Mat4f.toFloat32Array() : Float32Array {
    return Float32Array(this.elements.flatten().toTypedArray())
}
