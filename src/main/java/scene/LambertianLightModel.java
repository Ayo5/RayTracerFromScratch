package main.java.scene;

import main.java.coordinate.Vector;

import java.util.List;

public class LambertianLightModel implements LightModel {
    @Override
    public Color calculateColor(Vector normal, Color baseColor, List<Light> lights) {
        Color result = new Color(0,0,0);
        for (Light light : lights) {
            Vector lightDirection = light.getDirectionToSurfacePoint();
            double lightIntensity = light.getIntensity();

            double dotProduct = normal.dot(lightDirection);
            if (dotProduct > 0) {
                double LambertFactor = dotProduct;
                result = result.add(baseColor.multiply(light.getColor()).multiply(LambertFactor * lightIntensity));
            }
        }
        return result;
    }
}