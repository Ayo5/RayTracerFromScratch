
package main.java.math;

public class Ray {
    private Point origin;
    private Vector direction;

    public Ray(Point origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }
    public Point getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }


    public Point pointAt(double t) {
        double x = origin.getX() + t * direction.getX();
        double y = origin.getY() + t * direction.getY();
        double z = origin.getZ() + t * direction.getZ();
        return new Point(x, y, z);
    }

}
