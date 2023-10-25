package main.java.scene;

import main.java.math.Point;
import main.java.math.Triplet;
import main.java.object.SceneObject;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<SceneObject> objects;
    private List<Light> lights;
    private Camera camera;
    private int imgWidth;
    private int imgHeight;

    public List<SceneObject> getObjects() {
        return objects;
    }

    public List<Light> getLights() {
        return lights;
    }

    public Scene(int imgWidth, int imgHeight) {
        this.objects = new ArrayList<>();
        this.lights = new ArrayList<>();
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
    }

    public void addObject(SceneObject object) {
        objects.add(object);
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public int getImageWidth() {
        return imgWidth;
    }

    public int getImageHeight() {
        return imgHeight;
    }


    public static class Intersection {
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

        public Triplet getPoint(Point intersectionPoint) {
            return point;
        }

        public Triplet getNormal() {
            return normal;
        }

        public double getDistance() {
            return distance;
        }


        public void setIntersectionDistance(double distance) {
            this.distance = distance;
        }
    }
}