package main.java.math;


public class Triplet {
    private double x;
    private double y;
    private double z;

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public boolean equals(Object o) {
        if (o instanceof Triplet t) {
            return x == t.x && y == t.y && z == t.z;
        }
        return false;
    }

    public Triplet addition(Triplet t2 ) {
        return new Triplet(this.x + t2.x, this.y + t2.y, this.z + t2.z);
    }

    public Triplet subtraction(Triplet t2 ) {
        return new Triplet(this.x - t2.x, this.y - t2.y, this.z - t2.z);
    }

    public Triplet dotVectorial(double scalar) {
        return new Triplet(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double dotScalar(Triplet t2) {
        return this.x * t2.x + this.y * t2.y + this.z * t2.z;
    }

    public Triplet multiplyScalar(Triplet t2) {
        return new Triplet(this.y * t2.z - this.z * t2.y, this.z * t2.x - this.x * t2.z, this.x * t2.y - this.y * t2.x);
    }
    public Triplet dotSchur(Triplet t2) {
        return new Triplet(this.x * t2.x, this.y * t2.y, this.z * t2.z);
    }
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z );
    }

    public Triplet normalize() {
        double length = this.length();
        if (length != 0) {
            double invLength = 1 / length;
            return this.dotVectorial(invLength);
        } else {
            return this;
        }
    }
    public static float distance(Triplet a, Triplet b) {
        return (float) Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) + Math.pow(a.getZ() - b.getZ(), 2));
    }

}

