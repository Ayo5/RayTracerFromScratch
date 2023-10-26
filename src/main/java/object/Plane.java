package main.java.object;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;

public class Plane extends SceneObject {
    private Point point ;
    private Vector normal ;


    public Point getPoint() {
        return point;
    }

    public Vector getNormal() {
        return normal;
    }

    public Plane(Point point , Vector normal  , Colors color) {
        super(color);
        this.point = point ;
        this.normal  = normal  ;
    }



    @Override
    public double intersect(Point lookFrom, Vector d) {
        return 0;
    }

    @Override
    public Point intersectOnP(Point lookFrom, Vector d) {
        return null;
    }

    @Override
    public Vector createVectorN(Point lookFrom, Vector d) {
        return null;
    }
}
