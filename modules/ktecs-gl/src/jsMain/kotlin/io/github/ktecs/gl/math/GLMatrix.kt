@file:JsModule("gl-matrix")
@file:JsNonModule
package io.github.ktecs.gl.math

import org.khronos.webgl.Float32Array
import org.khronos.webgl.get

@JsName("mat4")
internal external class Mat4 {
    companion object {
        fun create(): dynamic /* dynamic | Float32Array */

        fun identity(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */): dynamic /* dynamic | Float32Array */

        fun identity(out: Float32Array): dynamic /* dynamic | Float32Array */

        fun invert(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Any): dynamic /* dynamic | Float32Array */

        fun invert(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Float32Array): dynamic /* dynamic | Float32Array */

        fun invert(out: Float32Array, a: Any): dynamic /* dynamic | Float32Array */

        fun invert(out: Float32Array, a: Float32Array): dynamic /* dynamic | Float32Array */

        fun multiply(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Any, b: Any): dynamic /* dynamic | Float32Array */

        fun multiply(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Any, b: Float32Array): dynamic /* dynamic | Float32Array */

        fun multiply(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Float32Array, b: Any): dynamic /* dynamic | Float32Array */

        fun multiply(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Float32Array, b: Float32Array): dynamic /* dynamic | Float32Array */

        fun multiply(out: Float32Array, a: Any, b: Any): dynamic /* dynamic | Float32Array */

        fun multiply(out: Float32Array, a: Any, b: Float32Array): dynamic /* dynamic | Float32Array */

        fun multiply(out: Float32Array, a: Float32Array, b: Any): dynamic /* dynamic | Float32Array */

        fun multiply(out: Float32Array, a: Float32Array, b: Float32Array): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, q: Any, v: Any, s: Float32Array): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, q: Any, v: Float32Array, s: Any): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, q: Any, v: Float32Array, s: Float32Array): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: Float32Array, q: Any, v: Any, s: Any): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: Float32Array, q: Any, v: Any, s: Float32Array): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: Float32Array, q: Any, v: Float32Array, s: Any): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: Float32Array, q: Any, v: Float32Array, s: Float32Array): dynamic /* dynamic | Float32Array */

        fun fromRotationTranslationScale(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, q: Any, v: Any, s: Any): dynamic /* dynamic | Float32Array */

        fun perspective(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, fovy: Number, aspect: Number, near: Number, far: Number): dynamic /* dynamic | Float32Array */

        fun perspective(out: Float32Array, fovy: Number, aspect: Number, near: Number, far: Number): dynamic /* dynamic | Float32Array */

        fun transpose(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Any): dynamic /* dynamic | Float32Array */

        fun transpose(out: dynamic /* JsTuple<Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number, Number> */, a: Float32Array): dynamic /* dynamic | Float32Array */

        fun transpose(out: Float32Array, a: Any): dynamic /* dynamic | Float32Array */

        fun transpose(out: Float32Array, a: Float32Array): dynamic /* dynamic | Float32Array */
    }
}

@JsName("quat")
internal external class Quat {
    companion object {
        fun create(): dynamic /* dynamic | Float32Array */

        fun fromEuler(out: dynamic /* JsTuple<Number, Number, Number, Number> */, x: Any, y: Any, z: Any): dynamic /* dynamic | Float32Array */
    }
}
