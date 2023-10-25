package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
import main.java.scene.Ray;
import main.java.scene.Scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Plane extends SceneObject {
    private Point a ;
    private Point b ;
    private Vector q; //Point belonging to the plane
    private Vector n; //Normal of the plane


    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Plane(Vector q, Vector n) {
        this.a = null ;
        this.b = null ;
        this.q = q;
        this.n = n.normalyze();
    }

    @Override
    public boolean intersect(Ray ray, Scene.Intersection intersection) {
        return false;
    }

    @Override
    public double findIntersectionDistance(Point p, Vector d) {
        return 0;
    }

    @Override
    public double findIntersectionDistance(Vector lookFrom, Vector direction) {
        double dotProduct = direction.dotScalar(n);

        //If the direction vector is parallel to the plane (dotProduct = 0), there is no intersection
        if (dotProduct == 0) {
            return Double.POSITIVE_INFINITY;
        }

        double t = q.subtraction(lookFrom).dotScalar(n) / dotProduct;

        //If t is negative, the intersection is behind the camera's direction
        if (t < 0) {
            return Double.POSITIVE_INFINITY;
        }
        return t;
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
