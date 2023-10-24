package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Camera {
    private Point position; // Position de la caméra (l'œil)
    private Point lookAt;   // Point regardé
    private Vector up;       // Vecteur vers le haut
    private double fov;     // Champ de vision

    public Camera() {
        this.position = null;
        this.lookAt = null;
        this.up = null; //up.normalyze(); // Assurez-vous que le vecteur vers le haut est normalisé
        this.fov = 0;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
    }

    public void setUp(Vector up) {
        this.up = up;
    }

    public void setFov(double fov) {
        this.fov = fov;
    }

    public Point getPosition() {
        return position;
    }

    public Point getLookAt() {
        return lookAt;
    }

    public Vector getUp() {
        return up;
    }

    public void loadCameraSettingsFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resource/" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("camera")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double u = Double.parseDouble(words[4]);
                            double v = Double.parseDouble(words[5]);
                            double w = Double.parseDouble(words[6]);
                            double a = Double.parseDouble(words[7]);
                            double b = Double.parseDouble(words[8]);
                            double c = Double.parseDouble(words[9]);
                            double f = Double.parseDouble(words[10]);
                            position = new Point(x, y, z);
                            lookAt = new Point(u, v, w);
                            up = new Vector(a, b, c).normalyze();
                            fov = f;
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de paramètres de la caméra.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }
}