package main.java;

public class Intersection {
    private SceneObject object; // L'objet avec lequel le rayon interagit
    private Triplet point; // Point d'intersection en coordonnées mondiales
    private Triplet normal; // Normale à la surface d'intersection
    private double distance; // Distance du point de départ du rayon à l'intersection

    public Intersection(SceneObject object, Triplet point, Triplet normal, double distance) {
        this.object = object;
        this.point = point;
        this.normal = normal;
        this.distance = distance;
    }

    public SceneObject getObject() {
        return object;
    }

    public Triplet getPoint() {
        return point;
    }

    public Triplet getNormal() {
        return normal;
    }

    public double getDistance() {
        return distance;
    }
}
