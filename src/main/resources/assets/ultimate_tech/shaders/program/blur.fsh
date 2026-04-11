#version 150

uniform sampler2D DiffuseSampler;
uniform vec2 BlurDir;
uniform float BlurRadius;

in vec2 texCoord;
in vec2 oneTexel;

out vec4 fragColor;

void main() {
    int radius = int(BlurRadius);
    vec4 color = vec4(0.0);
    float totalWeight = 0.0;

    for (int i = -radius; i <= radius; i++) {
        float sigma = max(BlurRadius, 1.0);
        float weight = exp(-float(i * i) / (2.0 * sigma * sigma));
        vec2 offset = float(i) * oneTexel * BlurDir;
        color += texture(DiffuseSampler, texCoord + offset) * weight;
        totalWeight += weight;
    }

    fragColor = color / totalWeight;
}
