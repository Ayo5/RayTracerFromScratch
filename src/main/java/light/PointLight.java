
package main.java.light;

import main.java.math.Point;


public class PointLight extends Light {
    private Point point;

    public PointLight(Point point , Colors color) {
        super(color);
        this.point = point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }
}
