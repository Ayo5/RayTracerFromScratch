package sae301;

import java.awt.*;
import java.awt.Color;

public class Material {
    private java.awt.Color color;
    private double reflectivity;
    private double shininess;

    public Material(Color color, double reflectivity, double shininess) {
        this.color = color;
        this.reflectivity = reflectivity;
        this.shininess = shininess;
    }
}
