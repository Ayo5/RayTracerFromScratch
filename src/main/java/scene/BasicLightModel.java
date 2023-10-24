package main.java.scene;

import main.java.coordinate.Vector;

import java.util.List;

public class BasicLightModel implements LightModel {
    @Override
    public Color calculateColor(Vector normal, Color baseColor, List<Light> lights) {
        Color result = new Color(0,0,0);
        for (Light light : lights) {
            Vector lightDirection = light.getDirection();
            double lightIntensity = light.getIntensity();

            double dotProduct = normal.dotScalar(lightDirection);
            if (dotProduct > 0) {
                result = result.add(baseColor.multiply(light.getColor()).multiply(dotProduct * lightIntensity));
            }
        }
        return result;
    }
}