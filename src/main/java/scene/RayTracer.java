package main.java.scene;

import main.java.math.Point;
import main.java.math.Triplet;
import main.java.math.Vector;
import main.java.object.SceneObject;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RayTracer {
    private int imgWidth; // Largeur de l'image en pixels
    private int imgHeight; // Hauteur de l'image en pixels
    private double fov; // Champ de vision en degrés
    private String outputFileName; // Nom du fichier de sortie
    private BufferedImage image; // Image en cours de construction
    private Scene scene; // Scène à rendre

    public RayTracer(int imgWidth, int imgHeight, double fov, String outputFileName, Scene scene) {
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.fov = fov;
        this.outputFileName = outputFileName;
        this.image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        this.scene = scene;
    }


    private Vector findClosestIntersection(Ray ray) {
        Vector closestIntersection = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (SceneObject object : scene.getObjects()) {
            Point intersection = new Point(object.intersect(ray).getX(),object.intersect(ray).getY(),object.intersect(ray).getZ());
            if (intersection != null) {
                double distance = Point.distance(ray.getOrigin(),new Point(intersection.getX(),intersection.getY(),intersection.getZ()));
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestIntersection = new Vector(intersection.getX(),intersection.getY(),intersection.getZ());
                }
            }
        }

        return closestIntersection;
    }


    public void render() {
        double pixelWidth = 2.0 * Math.tan(Math.toRadians(fov / 2.0)) / imgWidth;
        double pixelHeight = 2.0 * Math.tan(Math.toRadians(fov / 2.0)) / imgHeight;

        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                double x = (i + 0.5) * pixelWidth - Math.tan(Math.toRadians(fov / 2.0));
                double y = (j + 0.5) * pixelHeight - Math.tan(Math.toRadians(fov / 2.0));

                // Calculez la direction du rayon pour ce pixel en fonction des coordonnées x et y,
                // la position de la caméra et les vecteurs de la caméra
                Vector direction = scene.getCamera().getUp() ;
                Point pov = scene.getCamera().getPosition();
                Ray ray = new Ray(pov, direction);

                Color pixelColor = new Color(0.5, 0, 0.5);

                image.setRGB(i, j, pixelColor.toRGB());
            }
        }
    }

    public void saveImage() {
        try {
            File outputfile = new File(outputFileName);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int imgWidth = 640;
        int imgHeight = 480;
        double fov = 60;
        String outputFileName = "m.png";

        Scene scene = SceneParser.parseScene("scene.txt");

        RayTracer rayTracer = new RayTracer(imgWidth, imgHeight, fov, outputFileName, scene);
        rayTracer.render();
        rayTracer.saveImage();
    }
}
