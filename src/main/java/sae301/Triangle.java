package sae301;

import sae301.Point;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Triangle {

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle() {
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
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
        List<Point> points = new ArrayList<>();
        try {
            File file = new File("src/main/ressource/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("maxverts")) {
                        int nb_Point = Integer.parseInt(words[1]) ;
                    }
                    else if (keyword.equals("vertex")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            Point vertex = new Point(x, y, z);
                            points.add(vertex);
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de vertex.");
                        }
                    } else if (keyword.equals("tri")) {
                        try {
                            int index1 = Integer.parseInt(words[1]);
                            int index2 = Integer.parseInt(words[2]);
                            int index3 = Integer.parseInt(words[3]);

                            Point p1 = points.get(index1);
                            Point p2 = points.get(index2);
                            Point p3 = points.get(index3);

                            this.p1 = p1;
                            this.p2 = p2;
                            this.p3 = p3;
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de tri.");
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
