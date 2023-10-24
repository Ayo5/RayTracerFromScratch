package sae301;

public class DirectionalLight extends Light {
    private Vector direction;

    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction;
    }

    public Vector getDirection() {
        return direction;
    }
}
