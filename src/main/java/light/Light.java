package main.java.light;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Light {
    private Colors color;

    public Light(Colors color) {
        this.color = color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

}

