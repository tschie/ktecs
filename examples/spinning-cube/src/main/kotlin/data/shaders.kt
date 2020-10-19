package data

val vertexShaderSource = """
    precision mediump float;

    attribute vec3 position;
    attribute vec3 color;
    varying vec3 colorV;

    uniform mat4 positionMatrix;

    void main() {
        colorV = color;
        gl_Position = positionMatrix * vec4(position, 1);
    }
  """.trimIndent()

val fragmentShaderSource = """
    precision mediump float;

    varying vec3 colorV;

    void main() {
        gl_FragColor = vec4(colorV, 1);
    }
  """.trimIndent()
