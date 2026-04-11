#version 150

uniform sampler2D DiffuseSampler;
uniform float Radius;
uniform vec2 TexelSize;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec4 color = vec4(0.0);
    float total = 0.0;

    for (float i = -Radius; i <= Radius; i++) {
        float weight = exp(-i * i / (2.0 * Radius));
        vec2 offset = vec2(i * TexelSize.x, 0.0);

        color += texture(DiffuseSampler, texCoord + offset) * weight;
        total += weight;
    }

    fragColor = color / total;
}
