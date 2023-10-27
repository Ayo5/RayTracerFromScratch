
package main.java.math;

/**
 * The type Ray.
 */
public class Ray {
    private Point origin;
    private Vector direction;

    /**
     * Instantiates a new Ray.
     *
     * @param origin    the origin
     * @param direction the direction
     */
    public Ray(Point origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    /**
     * Gets origin.
     *
     * @return the origin
     */
    public Point getOrigin() {
        return origin;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public Vector getDirection() {
        return direction;
    }


    /**
     * Point at point.
     *
     * @param t the t
     * @return the point
     */
    public Point pointAt(double t) {
        double x = origin.getX() + t * direction.getX();
        double y = origin.getY() + t * direction.getY();
        double z = origin.getZ() + t * direction.getZ();
        return new Point(x, y, z);
    }

}
