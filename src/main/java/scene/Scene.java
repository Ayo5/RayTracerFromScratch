package main.java.scene;

import main.java.light.Light;
import main.java.object.SceneObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Scene.
 */
public class Scene {
    private List<SceneObject> objects;
    private List<Light> lights;
    private Camera camera;
    private int imgWidth;
    private int imgHeight;
    private String outputFileName;

    /**
     * Gets output file name.
     *
     * @return the output file name
     */
    public String getOutputFileName() {
        return outputFileName;
    }

    /**
     * Sets output file name.
     *
     * @param outputFileName the output file name
     */
    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    /**
     * Gets objects.
     *
     * @return the objects
     */
    public List<SceneObject> getObjects() {
        return objects;
    }

    /**
     * Gets lights.
     *
     * @return the lights
     */
    public List<Light> getLights() {
        return lights;
    }

    /**
     * Sets img width.
     *
     * @param imgWidth the img width
     */
    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    /**
     * Sets img height.
     *
     * @param imgHeight the img height
     */
    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    /**
     * Instantiates a new Scene.
     *
     * @param imgWidth  the img width
     * @param imgHeight the img height
     */
    public Scene(int imgWidth, int imgHeight) {
        this.objects = new ArrayList<>();
        this.lights = new ArrayList<>();
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
    }

    /**
     * Add object.
     *
     * @param object the object
     */
    public void addObject(SceneObject object) {
        objects.add(object);
    }

    /**
     * Add light.
     *
     * @param light the light
     */
    public void addLight(Light light) {
        lights.add(light);
    }

    /**
     * Gets camera.
     *
     * @return the camera
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Sets camera.
     *
     * @param camera the camera
     */
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /**
     * Gets image width.
     *
     * @return the image width
     */
    public int getImageWidth() {
        return imgWidth;
    }

    /**
     * Gets image height.
     *
     * @return the image height
     */
    public int getImageHeight() {
        return imgHeight;
    }

}