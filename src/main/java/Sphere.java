package main.java;

import main.java.Point;

import java.io.*;

public class Sphere extends SceneObject{

    private Point center;
    private double radius;

    public Sphere(Material material) {
        super(material);
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
                    if (keyword.equals("sphere")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double r = Double.parseDouble(words[4]);
                            center = new Point(x, y, z);
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
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean intersect(Ray ray, Intersection intersection) {
        // Code pour déterminer s'il y a intersection et la distance, vous pouvez implémenter cela ici
        // Assurez-vous de mettre à jour l'objet Intersection en conséquence.
        // Retournez true si une intersection a été trouvée, sinon false.
        // Vous pouvez utiliser la méthode findIntersectionDistance pour calculer la distance d'intersection.
        // N'oubliez pas de gérer également les coordonnées du point d'intersection.

        // Exemple simple pour trouver une intersection entre un rayon et une sphère :
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
        // Implémentez ici le calcul de la distance d'intersection entre le point p et la sphère
        // en suivant une direction d.
        // Si aucune intersection n'est trouvée, retournez une distance négative.
        // Vous pouvez utiliser un code similaire à celui de la méthode intersect.

        Vector oc = p.subtract(center);
        double a = d.dotScalar(d);
        double b = 2.0 * oc.dotScalar(d);
        double c = oc.dotScalar(oc) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            // Pas d'intersection
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
