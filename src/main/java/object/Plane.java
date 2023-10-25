
package main.java.object;

import main.java.math.Point;
import main.java.math.Vector;
import main.java.scene.Color;
import main.java.scene.Ray;
import main.java.scene.Scene;


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

    public Plane(Point a , Point b , Color color) {
        super(null);
        this.a = null ;
        this.b = null ;
    }

    @Override
    public Vector intersect(Ray ray) {
        double t = -(ray.getOrigin().getY()-a.getY()) / ray.getDirection().getY();
        if (t > 0 && Float.isFinite((float) t))
        {
            return new Vector(ray.getOrigin().getX(),ray.getOrigin().getY(),ray.getOrigin().getZ())
                    .addition(ray.getDirection().multiplicationScalar(t));
        }
        return null;
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
                    if (keyword.equals("ambient")) {
                        try {
                            double r = Double.parseDouble(words[1]);
                            double g = Double.parseDouble(words[2]);
                            double b = Double.parseDouble(words[3]);
                            this.setColor(new Color(r, g, b));
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de la couleur.");
                        }
                }
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
