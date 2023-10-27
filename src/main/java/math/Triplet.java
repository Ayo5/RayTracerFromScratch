package main.java.math;


/**
 * The type Triplet.
 */
public class Triplet {
    private double x;
    private double y;
    private double z;

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() { return x; }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() { return y; }

    /**
     * Gets z.
     *
     * @return the z
     */
    public double getZ() { return z; }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(double x) { this.x = x; }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(double y) { this.y = y; }

    /**
     * Sets z.
     *
     * @param z the z
     */
    public void setZ(double z) { this.z = z; }

    /**
     * Instantiates a new Triplet.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }


    /**
     * Addition triplet.
     *
     * @param t2 the t 2
     * @return the triplet
     */
    public Triplet addition(Triplet t2 ) {
        return new Triplet(this.x + t2.x, this.y + t2.y, this.z + t2.z);
    }

    /**
     * Subtraction triplet.
     *
     * @param t2 the t 2
     * @return the triplet
     */
    public Triplet subtraction(Triplet t2 ) {
        return new Triplet(this.x - t2.x, this.y - t2.y, this.z - t2.z);
    }

    /**
     * Dot vectorial triplet.
     *
     * @param scalar the scalar
     * @return the triplet
     */
    public Triplet dotVectorial(double scalar) {
        return new Triplet(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    /**
     * Dot scalar double.
     *
     * @param t2 the t 2
     * @return the double
     */
    public double dotScalar(Triplet t2) {
        return this.x * t2.x + this.y * t2.y + this.z * t2.z;
    }

    /**
     * Multiply scalar triplet.
     *
     * @param t2 the t 2
     * @return the triplet
     */
    public Triplet multiplyScalar(Triplet t2) {
        return new Triplet(this.y * t2.z - this.z * t2.y, this.z * t2.x - this.x * t2.z, this.x * t2.y - this.y * t2.x);
    }

    /**
     * Dot schur triplet.
     *
     * @param t2 the t 2
     * @return the triplet
     */
    public Triplet dotSchur(Triplet t2) {
        return new Triplet(this.x * t2.x, this.y * t2.y, this.z * t2.z);
    }

    /**
     * Length double.
     *
     * @return the double
     */
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z );
    }

    /**
     * Normalize triplet.
     *
     * @return the triplet
     */
    public Triplet normalize() {
        double length = this.length();
        if (length != 0) {
            double invLength = 1 / length;
            return this.dotVectorial(invLength);
        } else {
            return this;
        }
    }

    /**
     * Distance float.
     *
     * @param a the a
     * @param b the b
     * @return the float
     */
    public static float distance(Triplet a, Triplet b) {
        return (float) Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) + Math.pow(a.getZ() - b.getZ(), 2));
    }

}

