package main.java;

import java.io.*;

public class Sphere {

    private Point centre;
    private double radius;

    public void settingFromFile(String fileName) {
        try {

            File file = new File("src/main/ressource/" + fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(file.toURI().toURL().openStream()));
            String line = br.readLine();
            if (line != null) {
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
            } else {
                System.out.println("Fichier de sphère vide.");
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
