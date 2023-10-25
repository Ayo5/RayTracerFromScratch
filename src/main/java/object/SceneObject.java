package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
import main.java.scene.Color;
import main.java.scene.Material;
import main.java.scene.Ray;
import main.java.scene.Scene;

public abstract class SceneObject {
    private Color color;

    public SceneObject(Color color) {
        this.color = null;
    }

    public abstract boolean intersect(Ray ray, Scene.Intersection intersection);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double findIntersectionDistance(Point p, Vector d);
}
