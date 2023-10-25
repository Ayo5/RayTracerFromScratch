<<<<<<<< HEAD:src/main/java/sae301/DirectionalLight.java
package sae301;
========
package main.java.scene;

import main.java.coordinate.Vector;
>>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335:src/main/java/scene/DirectionalLight.java

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
