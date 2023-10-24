package main.java;

import java.awt.*;

public class Material {
    private Color color;
    private double reflectivity;
    private double shininess;

    public Material(Color color) {
        this.color = color;
        this.reflectivity = 0;
        this.shininess = 0;
    }
}
