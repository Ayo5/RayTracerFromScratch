package main.java.scene;

import main.java.light.Colors;
import main.java.light.DirectionalLight;
import main.java.light.PointLight;
import main.java.math.Point;
import main.java.math.Triplet;
import main.java.math.Vector;
import main.java.object.Plane;
import main.java.object.Sphere;
import main.java.object.Triangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Scene parser.
 */
public class SceneParser {

    /**
     * Parse scene scene.
     *
     * @param fileName the file name
     * @return the scene
     */
    public static Scene parseScene(String fileName) {
        Scene scene = new Scene(0, 0); // Default size
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/main/ressource/" + fileName)))) {
            Colors colorCurrent = new Colors(0, 0, 0);
            int maxverts = 0;
            Point p1 = null, p2 = null, p3 = null;
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("size")) {
                        try {
                            int width = Integer.parseInt(words[1]);
                            int height = Integer.parseInt(words[2]);
                            scene.setImgWidth(width);
                            scene.setImgHeight(height);
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de la taille.");
                        }

                    } else if (keyword.equals("output")) {
                        if (words.length < 2) {
                            scene.setOutputFileName("output.png");
                        } else {
                            scene.setOutputFileName(words[1]);
                        }
                    } else if (keyword.equals("camera")) {
                        try {
                            double eyeX = Double.parseDouble(words[1]);
                            double eyeY = Double.parseDouble(words[2]);
                            double eyeZ = Double.parseDouble(words[3]);
                            double lookX = Double.parseDouble(words[4]);
                            double lookY = Double.parseDouble(words[5]);
                            double lookZ = Double.parseDouble(words[6]);
                            double upX = Double.parseDouble(words[7]);
                            double upY = Double.parseDouble(words[8]);
                            double upZ = Double.parseDouble(words[9]);
                            double fov = Double.parseDouble(words[10]);
                            Camera camera = new Camera(new Point(eyeX, eyeY, eyeZ),
                                    new Point(lookX, lookY, lookZ),
                                    new Vector(upX, upY, upZ), fov);
                            scene.setCamera(camera);
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de la caméra.");
                        }
                    } else if (keyword.equals("ambient")) {
                        try {
                            double r = Double.parseDouble(words[1]);
                            double g = Double.parseDouble(words[2]);
                            double b = Double.parseDouble(words[3]);
                            colorCurrent.setRGB(new Triplet(r, g, b));
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de la couleur ambiante.");
                        }
                    } else if (keyword.equals("directional")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double r = Double.parseDouble(words[4]);
                            double g = Double.parseDouble(words[5]);
                            double b = Double.parseDouble(words[6]);
                            DirectionalLight light = new DirectionalLight(new Vector(x, y, z), new Colors(r, g, b));
                            scene.addLight(light);
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne 'directional'.");
                        }
                    } else if (keyword.equals("point")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double r = Double.parseDouble(words[4]);
                            double g = Double.parseDouble(words[5]);
                            double b = Double.parseDouble(words[6]);
                            PointLight light = new PointLight(new Point(x, y, z), new Colors(r, g, b));
                            scene.addLight(light);
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne 'point'.");
                        }
                    } else if (keyword.equals("maxverts")) {
                        maxverts = Integer.parseInt(words[1]);
                    } else if (keyword.equals("vertex")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            if (p1 == null) {
                                p1 = new Point(x, y, z);
                            } else if (p2 == null) {
                                p2 = new Point(x, y, z);
                            } else if (p3 == null) {
                                p3 = new Point(x, y, z);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de vertex.");
                        }
                    } else if (keyword.equals("tri")) {
                        try {
                            if (p1 != null && p2 != null && p3 != null) {
                                Triangle triangle = new Triangle(p1, p2, p3, colorCurrent);
                                scene.addObject(triangle);
                            } else {
                                System.out.println("Points du triangle non définis correctement.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de triangle.");
                        }
                    } else if (keyword.equals("sphere")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double radius = Double.parseDouble(words[4]);
                            Sphere sphere = new Sphere(new Point(x, y, z), radius, colorCurrent);
                            scene.addObject(sphere);
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne de la sphère.");
                        }
                    } else if (keyword.equals("plane")) {
                        try {
                            double a = Double.parseDouble(words[1]);
                            double b = Double.parseDouble(words[2]);
                            double c = Double.parseDouble(words[3]);
                            double d = Double.parseDouble(words[4]);
                            double e = Double.parseDouble(words[5]);
                            double f = Double.parseDouble(words[6]);
                            Plane plane = new Plane(new Point(a,b,c),new Vector(d,e,f), colorCurrent);
                            scene.addObject(plane);
                        } catch (NumberFormatException e) {
                            System.out.println("Format de nombre invalide dans la ligne du plan.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
        return scene;
    }
}
