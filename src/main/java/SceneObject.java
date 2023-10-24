package main.java;

public abstract class SceneObject {
    private Material material;

    public  SceneObject() {
        this.material = null;
    }

    public abstract boolean intersect(Ray ray, Scene.Intersection intersection);

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
