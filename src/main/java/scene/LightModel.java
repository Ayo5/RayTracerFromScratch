package main.java.scene;

import main.java.coordinate.Vector;

import java.util.List;

public interface LightModel {
    Color calculateColor(Vector normal, Color baseColor, List<Light> lights);
}
