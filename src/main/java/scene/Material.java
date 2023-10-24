package main.java.scene;

import main.java.scene.Color;

public class Material {
    private main.java.scene.Color color;
    private double reflectivity;
    private double shininess;
    private Color diffuseColor;

    public Material(Color color, Color diffuseColor) {
        this.color = color;
        this.reflectivity = 0;
        this.shininess = 0;
        this.diffuseColor = diffuseColor;
    }
}
