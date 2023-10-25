package main.java.object;

import main.java.math.Point;
import main.java.math.Vector;
import main.java.scene.*;

import java.io.*;

public class Sphere extends SceneObject {

    private Point center;
    private double radius;


    public Point getCentre() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return super.getColor();
    }

    public void setCentre(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public Sphere(Point center, double radius, Color color) {
        super(null);
        this.center = null;
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
                    if (keyword.equals("ambient")) {
                        try {
                            double r = Double.parseDouble(words[1]);
                            double g = Double.parseDouble(words[2]);
                            double b = Double.parseDouble(words[3]);
                            this.setColor(new Color(r, g, b));
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de la diffuse.");
                        }

                    }
                    if (keyword.equals("sphere")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double r = Double.parseDouble(words[4]);
                            center = new Point(x, y, z);
                            radius = r;
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

    @Override
    public Vector intersect(Ray ray) {
        Vector oc = new Point(ray.getOrigin().getX(), ray.getOrigin().getY(), ray.getOrigin().getZ()).subtract(center);
        double a = ray.getDirection().dotScalar(ray.getDirection());
        double b = 2.0 * oc.dotScalar(ray.getDirection());
        double c = oc.dotScalar(oc) - radius * radius;
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {

            double t1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
            double t2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);

            if (t1 > 0 && t2 > 0) {
                double t = Math.min(t1, t2);
                return new Vector(ray.getOrigin().getX(),ray.getOrigin().getY(),ray.getOrigin().getZ())
                        .addition(ray.getDirection().multiplicationScalar(t));
            } else if (t1 > 0) {
                return new Vector(ray.getOrigin().getX(),ray.getOrigin().getY(),ray.getOrigin().getZ())
                        .addition(ray.getDirection().multiplicationScalar(t1));
            } else if (t2 > 0) {
                return new Vector(ray.getOrigin().getX(),ray.getOrigin().getY(),ray.getOrigin().getZ())
                        .addition(ray.getDirection().multiplicationScalar(t2));
            }
        }
        return null;
    }

}

