
package main.java.scene;

import main.java.coordinate.Point;

import main.java.scene.Color;
import main.java.scene.Light;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.java.coordinate.Point;

/**
 * The PointLight class represents a point light source in a three-dimensional scene.
 * It is characterized by its color and position.
 */
public class PointLight extends Light {
    private Point point;

    /**
     * Constructs a new PointLight with the specified color and position.
     *
     * @param color The color of the point light source.
     * @param point The position of the point light source.
     */
    public PointLight(Color color, Point point) {
        super(color);
        this.point = point;
    }

    /**
     * Loads properties of the point light source from a file specified by the given file path.
     *
     * @param filePath The path to the file containing light properties.
     */
    public void loadPropertiesFromFile(String filePath) {
        try {
            File file = new File("src/main/ressource/" + filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length >= 1) {
                    if (words[0].equals("point")) {
                        if (words.length > 0) {
                            try {
                                double x = Double.parseDouble(words[1]);
                                double y = Double.parseDouble(words[2]);
                                double z = Double.parseDouble(words[3]);
                                double r = Double.parseDouble(words[4]);
                                double g = Double.parseDouble(words[5]);
                                double b = Double.parseDouble(words[6]);
                                point = new Point(x, y, z);
                                this.setColor(new Color(r, g, b));
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number format in the 'color' line.");
                            }
                        } else {
                            System.out.println("Invalid format in the 'color' line.");
                        }
                    }
                }
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the position of the point light source.
     *
     * @return The position of the point light source.
     */
    public Point getPoint() {
        return point;
    }
}
