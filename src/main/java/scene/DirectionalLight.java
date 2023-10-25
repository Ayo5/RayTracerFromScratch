
package main.java.scene;

import main.java.coordinate.Vector;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DirectionalLight extends Light {
    private Vector direction;

    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction;
    }


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
                                this.setColor(new Color(r, g, b)) ;
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




    public Vector getDirection() {
        return direction;
    }
}
