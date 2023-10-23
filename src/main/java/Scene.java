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

}
