package main.java.object;

import main.java.math.Point;
import main.java.math.Vector;
import main.java.scene.Color;
import main.java.scene.Ray;

public abstract class SceneObject {
    private Color color;

    public SceneObject(Color color) {
        this.color = null;
    }

    public abstract Vector intersect(Ray ray);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
