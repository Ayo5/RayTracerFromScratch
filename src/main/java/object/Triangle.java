
package main.java.object;

import main.java.math.Vector;
import main.java.scene.Color;
import main.java.math.Point;
import main.java.scene.Ray;
import main.java.scene.Scene;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Triangle extends SceneObject {

    private Point p1;
    private Point p2;
    private Point p3;


    public Triangle(Point p1, Point p2, Point p3, Color color) {
        super(null);
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;

    }

    @Override
    public Vector intersect(Ray ray) {
        Vector e1 = p2.subtract(p1);
        Vector e2 = p3.subtract(p1);
        Vector h = ray.getDirection().dotVectorial(e2);
        double a = e1.lenght()*(h.lenght());

        if (a > -Double.MIN_VALUE && a < Double.MIN_VALUE) {
            return null; // Rayon parallèle au triangle
        }

        double f = 1.0 / a;
        Vector s = ray.getOrigin().subtract(p1);
        double u = f * s.lenght()*(h.lenght());

        if (u < 0.0 || u > 1.0) {
            return null;
        }

        Vector q = s.dotVectorial(e1);
        double v = f * ray.getDirection().dotScalar(q);

        if (v < 0.0 || u + v > 1.0) {
            return null;
        }

        double t = f * e2.dotScalar(q);

        if (t > Double.MIN_VALUE) {
            return new Vector(ray.getOrigin().getX(),ray.getOrigin().getY(),ray.getOrigin().getZ())
                    .addition(ray.getDirection().multiplicationScalar(t));
        } else {
            return null;
        }
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
                                p1 = listPoints[index1];
                                p2 = listPoints[index2];
                                p3 = listPoints[index3];
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
