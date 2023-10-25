package main.java.scene;

import main.java.coordinate.Vector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The DirectionalLight class represents a directional light source in a three-dimensional scene.
 * It emits light uniformly in a specified direction.
 */
public class DirectionalLight extends Light {
    private Vector direction;

    /**
     * Constructs a new DirectionalLight with the specified color and direction.
     *
     * @param color     The color of the directional light.
     * @param direction The direction in which the light is emitted.
     */
    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction;
    }

    /**
     * Loads properties of the directional light from a file specified by the given file path.
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
                    if (words[0].equals("directional")) {
                        if (words.length > 0) {
                            try {
                                double x = Double.parseDouble(words[1]);
                                double y = Double.parseDouble(words[2]);
                                double z = Double.parseDouble(words[3]);
                                double r = Double.parseDouble(words[4]);
                                double g = Double.parseDouble(words[5]);
                                double b = Double.parseDouble(words[6]);
                                direction = new Vector(x, y, z);
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
     * Gets the direction in which the light is emitted.
     *
     * @return The direction vector of the light.
     */
    public Vector getDirection() {
        return direction;
    }
}
