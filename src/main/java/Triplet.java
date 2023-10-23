package main.java;

public class Triplet {
    private double x;
    private double y;
    private double z;

    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public boolean equals(Object o) {
        if (o instanceof Triplet) {
            Triplet t = (Triplet) o;
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

    public Triplet mulplicationScalar(double scalar) {
        return new Triplet(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double dotScalar(Triplet t2) {
        return this.x * t2.x + this.y * t2.y + this.z * t2.z;
    }
    public Triplet dotVectorial(Triplet t2) {
        return new Triplet(this.y * t2.z - this.z * t2.y, this.z * t2.x - this.x * t2.z, this.x * t2.y - this.y * t2.x);
    }
    public Triplet dotSchur(Triplet t2) {
        return new Triplet(this.x * t2.x, this.y * t2.y, this.z * t2.z);
    }
    public double lenght() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z );
    }
    public Triplet normalisation() {
        double opposed_lenght = (1 / this.lenght());
        return mulplicationScalar(opposed_lenght);
    }
}
