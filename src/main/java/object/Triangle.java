package main.java.object;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;

public class Triangle extends SceneObject {

    private Point p1;
    private Point p2;
    private Point p3;


    public Triangle(Point p1, Point p2, Point p3, Colors color) {
        super(color);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

    }




    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
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
