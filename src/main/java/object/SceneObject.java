package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
import main.java.scene.Material;
import main.java.scene.Ray;
import main.java.scene.Scene;

public abstract class SceneObject {
    private Material material;

    public  SceneObject() {
        this.material = null;
    }

    public abstract boolean intersect(Ray ray, Scene.Intersection intersection);

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public abstract double findIntersectionDistance(Point p, Vector d);
}
