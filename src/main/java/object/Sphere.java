package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
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
        super(null) ;
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
    public boolean intersect(Ray ray, Scene.Intersection intersection) {
        Vector oc = ray.getOrigin().subtract(center);
        double a = ray.getDirection().dotScalar(ray.getDirection());
        double b = 2.0 * oc.dotScalar(ray.getDirection());
        double c = oc.dotScalar(oc) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);

            // Vérifiez si t1 ou t2 est positif (devrait être le cas si le rayon est orienté vers la sphère)
            if (t1 > 0 || t2 > 0) {
                double distance = Math.min(t1, t2);
                Point intersectionPoint = ray.pointAt(distance);
                intersection.getPoint(intersectionPoint);
                intersection.setIntersectionDistance(distance);
                return true;
            }
        }

        return false;
    }

    @Override
    public double findIntersectionDistance(Point p, Vector d) {

        Vector oc = p.subtract(center);
        double a = d.dotScalar(d);
        double b = 2.0 * oc.dotScalar(d);
        double c = oc.dotScalar(oc) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {

            return -1.0;
        } else {
            double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);

            if (t1 > 0 || t2 > 0) {
                return Math.min(t1, t2);
            }
        }

        return -1.0;
    }
}

