package main.java;

import main.java.Point;

import java.io.*;

public class Sphere {

    private Point centre;
    private double radius;

    public Sphere() {
        this.centre = null;
        this.radius = 0;
    }

    public void settingFromFile(String fileName) {
        try {
            File file = new File("src/main/ressource/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("sphere")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double r = Double.parseDouble(words[4]);
                            centre = new Point(x, y, z);
                            radius = r;
                            // Process sphere parameters
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de la sphère.");
                        }
                    }

                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }

    public Point getCentre() {
        return centre;
    }

    public double getRadius() {
        return radius;
    }
}
