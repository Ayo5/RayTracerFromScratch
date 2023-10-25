package main.java.scene;

/**
 * The Material class represents the material properties of an object in a three-dimensional scene.
 * It includes color, reflectivity, and shininess characteristics.
 */
public class Material {
    private main.java.scene.Color color;
    private double reflectivity;
    private double shininess;

    /**
     * Constructs a new Material with the specified color and default reflectivity and shininess values.
     *
     * @param color The color of the material.
     */
    public Material(main.java.scene.Color color) {
        this.color = color;
        this.reflectivity = 0;
        this.shininess = 0;
    }
}
