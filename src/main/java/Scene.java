package main.java;

import main.java.SceneObject;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<SceneObject> objects;
    private List<Light> lights;
    private Camera camera;
    private int imgWidth;
    private int imgHeight;

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

    public Scene createScene() {
        Scene scene = new Scene(500, 500);

        Material red = new Material(Color.RED, 0.5, 0.5);
        Material green = new Material(Color.GREEN, 0.5, 0.5);
        Material blue = new Material(Color.BLUE, 0.5, 0.5);
        Material white = new Material(Color.WHITE, 0.5, 0.5);

        Sphere sphere1 = new Sphere(new Vector3(0, 0, 0), 1, red);
        Sphere sphere2 = new Sphere(new Vector3(2, 0, 0), 1, green);
        Sphere sphere3 = new Sphere(new Vector3(0, 2, 0), 1, blue);
        Sphere sphere4 = new Sphere(new Vector3(0, 0, 2), 1, white);

        scene.addObject(sphere1);
        scene.addObject(sphere2);
        scene.addObject(sphere3);
        scene.addObject(sphere4);

        scene.addLight(new Light(new Vector3(0, 0, 0), 1));

        scene.setCamera(new Camera(new Vector3(0, 0, -5), new Vector3(0, 0, 1), new Vector3(0, 1, 0), 1));

        return scene;
    }

}
