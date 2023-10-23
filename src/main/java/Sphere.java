package main.java;

import main.java.Point;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Sphere {

    private Point centre;
    private double radius;

    public void settingFromFile(String line) {

        String[] words = line.split("\\s+");
        if (words[0].equals("sphere")) {
            try {
                double x = Double.parseDouble(words[1]);
                double y = Double.parseDouble(words[2]);
                double z = Double.parseDouble(words[3]);
                double r = Double.parseDouble(words[4]);

                centre = new Point(x, y, z);
                radius = r;
            } catch (NumberFormatException e) {
                System.out.println("Format de nombre invalide dans la ligne de la sphère.");
            }
        } else {
            System.out.println("Format de ligne de sphère invalide : " + line);
        }
    }

}
