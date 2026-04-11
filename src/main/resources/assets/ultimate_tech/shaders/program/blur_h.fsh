#version 150

uniform sampler2D DiffuseSampler;
uniform float Radius;
uniform vec2 TexelSize;

in vec2 texCoord;

out vec4 fragColor;

void main() {
    vec4 color = vec4(0.0);
    float totalWeight = 0.0;
    int r = int(Radius);
    for (int i = -r; i <= r; i++) {
        float weight = exp(-float(i * i) / (2.0 * Radius * Radius));
        color += texture(DiffuseSampler, texCoord + vec2(float(i) * TexelSize.x, 0.0)) * weight;
        totalWeight += weight;
    }
    fragColor = color / totalWeight;
}
