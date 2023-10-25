package main.java.scene;

import main.java.object.*;
import main.java.coordinate.*;
import main.java.scene.*;

public class SceneBuilder {
    private Scene scene;

    public SceneBuilder(int imgWidth, int imgHeight) {
        this.scene = new Scene(imgWidth, imgHeight);
    }

    public SceneBuilder addLight(Color color) {
        Light light = new Light(color);
        scene.addLight(light);
        return this;
    }

    public SceneBuilder addObject(SceneObject object) {
        scene.addObject(object);
        return this;
    }

    public SceneBuilder setCamera(Camera camera) {
        scene.setCamera(camera);
        return this;
    }

    public Scene build() {
        return scene;
    }

    public static void main(String[] args) {
        Triangle tri = new Triangle();
        Camera camera = new Camera(null, null, null, 0.0);
        camera.setPosition(new Point(0.0, 0.0, 0.0));
        camera.setLookAt(new Point(0.0, 0.0, -1.0));
        camera.setUp(new Vector(0.0, 1.0, 0.0));
        camera.setFov(60.0);
        tri.settingFromFile("triangle.txt");
        Scene scene = new SceneBuilder(640, 480)
                .addLight(new Color(1.0, 1.0, 1.0))
                .addObject(tri)
                .setCamera(camera)
                .build();


    }

}
