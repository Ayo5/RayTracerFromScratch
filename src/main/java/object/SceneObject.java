package main.java.object;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;


public abstract class SceneObject {
    private Colors color;

    protected SceneObject(Colors color) {
        this.color = color;
    }

    public abstract double intersect(Point lookFrom, Vector d);

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }


    public abstract Point intersectOnP(Point lookFrom, Vector d);

    public abstract Vector createVectorN(Point lookFrom, Vector d);
}
