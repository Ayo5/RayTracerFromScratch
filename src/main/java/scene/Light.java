package main.java.scene;

import java.io.*;

/**
 * The Light class represents a light source in a three-dimensional scene.
 * It is characterized by its color.
 */
public class Light {
    private Color color;

    /**
     * Constructs a new Light with the specified color.
     *
     * @param color The color of the light source.
     */
    public Light(Color color) {
        this.color = color;
    }

    /**
     * Sets the color of the light source.
     *
     * @param color The color to be assigned to the light source.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the color of the light source.
     *
     * @return The color of the light source.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Loads properties of the light source from a file specified by the given file path.
     *
     * @param filePath The path to the file containing light properties.
     */
    public void loadPropertiesFromFile(String filePath) {
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length >= 1) {
                    if (words[0].equals("diffuse")) {
                        if (words.length >= 4) {
                            try {
                                double r = Double.parseDouble(words[1]);
                                double g = Double.parseDouble(words[2]);
                                double b = Double.parseDouble(words[3]);
                                color = new Color(r, g, b);
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
}
