package main.java.object;

import main.java.coordinate.Vector;
import main.java.scene.Material;
import main.java.coordinate.Point;
import main.java.scene.Ray;
import main.java.scene.Scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Triangle extends SceneObject {

    private Vector a;
    private Vector b;
    private Vector c;
    private Plane plane; //Plane containing the triangle
    private Material material;

    public Triangle(Vector a, Vector b, Vector c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.material = null;

        //Define the plane of the triangle using points p1, p2, p3
        Vector n = (b.subtraction(a)).cross(c.subtraction(a)).normalyze();
        this.plane = new Plane(a, n);
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
        double t = plane.findIntersectionDistance(lookFrom, direction);

        //If t is positive and the point is inside the triangle, return t
        //If not, return infinity
        if (t < 0) {
            return Double.POSITIVE_INFINITY;
        }

        Vector intersectionPoint = lookFrom.add(direction.scale(t));

        //Check if the intersection point is inside the triangle
        if (isInsideTriangle(intersectionPoint)) {
            return t;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    private boolean isInsideTriangle(Vector p) {
        Vector ab = b.subtraction(a);
        Vector bc = c.subtraction(b);
        Vector ca = a.subtraction(c);
        Vector ap = p.subtraction(a);
        Vector bp = p.subtraction(b);
        Vector cp = p.subtraction(c);

        return (ab.cross(ap).dot(plane.getNormal()) >= 0)
                && (bc.cross(bp).dot(plane.getNormal()) >= 0)
                && (ca.cross(cp).dot(plane.getNormal()) >= 0);
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public void settingFromFile(String fileName) {
        try {
            File file = new File("src/main/ressource/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int nbPoints = 0;
            Point[] listPoints = null;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("maxverts")) {
                        nbPoints = Integer.parseInt(words[1]);
                        listPoints = new Point[nbPoints];
                    } else if (keyword.equals("vertex")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            Point vertex = new Point(x, y, z);
                            if (nbPoints > 0) {
                                listPoints[nbPoints - 1] = vertex;
                                nbPoints--;
                            } else {
                                System.out.println("Trop de points spécifiés par rapport à maxverts.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de vertex.");
                        }
                    } else if (keyword.equals("tri")) {
                        try {
                            int index1 = Integer.parseInt(words[1]);
                            int index2 = Integer.parseInt(words[2]);
                            int index3 = Integer.parseInt(words[3]);

                            if (index1 < listPoints.length && index2 < listPoints.length && index3 < listPoints.length) {
                                Point p1 = listPoints[index1];
                                Point p2 = listPoints[index2];
                                Point p3 = listPoints[index3];
                                Triangle triangle = new Triangle();
                                triangle.setP1(p1);
                                triangle.setP2(p2);
                                triangle.setP3(p3);
                            } else {
                                System.out.println("Indices de triangle invalides par rapport aux points spécifiés.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de triangle.");
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
