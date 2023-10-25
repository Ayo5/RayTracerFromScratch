package main.java.scene;

import main.java.object.*;
import main.java.coordinate.*;
import main.java.scene.*;

/**
 * The SceneBuilder class is used to construct a Scene by adding lights, objects, and configuring a camera.
 */
public class SceneBuilder {
    private Scene scene;

    /**
     * Constructs a new SceneBuilder with the specified image dimensions.
     *
     * @param imgWidth  The width of the rendered image in pixels.
     * @param imgHeight The height of the rendered image in pixels.
     */
    public SceneBuilder(int imgWidth, int imgHeight) {
        this.scene = new Scene(imgWidth, imgHeight);
    }

    /**
     * Adds a light with the specified color to the scene being built.
     *
     * @param color The color of the light to add.
     * @return This SceneBuilder for method chaining.
     */
    public SceneBuilder addLight(Color color) {
        Light light = new Light(color);
        scene.addLight(light);
        return this;
    }

    /**
     * Adds a scene object to the scene being built.
     *
     * @param object The scene object to add.
     * @return This SceneBuilder for method chaining.
     */
    public SceneBuilder addObject(SceneObject object) {
        scene.addObject(object);
        return this;
    }

    /**
     * Sets the camera for the scene being built.
     *
     * @param camera The camera to set.
     * @return This SceneBuilder for method chaining.
     */
    public SceneBuilder setCamera(Camera camera) {
        scene.setCamera(camera);
        return this;
    }

    /**
     * Builds and returns the final Scene.
     *
     * @return The Scene built by this SceneBuilder.
     */
    public Scene build() {
        return scene;
    }

    public static void main(String[] args) {
        // Example usage of the SceneBuilder
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
