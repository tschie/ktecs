const path = require("path");
const nodeModulesPath = path.resolve(__dirname, "node_modules");

config.module.rules.push({
    test: /\.(glsl|frag|vert)$/,
    loader: ["raw-loader", "glslify-loader"],
    exclude: [nodeModulesPath],
});
