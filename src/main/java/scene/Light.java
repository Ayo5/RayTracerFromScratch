package main.java.scene;
import main.java.scene.Color;

import java.io.*;

public class Light {
    private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

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
                                System.out.println("Format de nombre invalide dans la ligne 'color'.");
                            }
                        } else {
                            System.out.println("Format invalide dans la ligne 'color'.");
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

