<<<<<<<< HEAD:src/main/java/sae301/Plane.java
package sae301;
========
package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
import main.java.scene.Ray;
import main.java.scene.Scene;
>>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335:src/main/java/object/Plane.java

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Plane extends SceneObject {
    private Point a ;
    private Point b ;


    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Plane() {
        this.a = null ;
        this.b = null ;
    }

    @Override
    public boolean intersect(Ray ray, Scene.Intersection intersection) {
        return false;
    }

    @Override
    public double findIntersectionDistance(Point p, Vector d) {
        return 0;
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
                    if (keyword.equals("plane")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double u = Double.parseDouble(words[4]);
                            double v = Double.parseDouble(words[5]);
                            double w = Double.parseDouble(words[6]);
                            a = new Point(x, y, z);
                            b = new Point(u, v, w);
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
}
