package main.java;

public abstract class SceneObject {
    private Material material;

    public SceneObject(Material material) {
        this.material = material;
    }

    public abstract boolean intersect(Ray ray, Intersection intersection);

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}