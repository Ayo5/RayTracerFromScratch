package main.java.light;

/**
 * The type Light.
 */
public class Light {
    private Colors color;

    /**
     * Instantiates a new Light.
     *
     * @param color the color
     */
    public Light(Colors color) {
        this.color = color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Colors color) {
        this.color = color;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Colors getColor() {
        return color;
    }

}

