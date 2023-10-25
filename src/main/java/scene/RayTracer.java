package main.java.scene;

import main.java.coordinate.Triplet;
import main.java.coordinate.Vector;


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

    public Color calculatePixelColor(Ray ray) {
        Intersection closestIntersection = findClosestIntersection(ray);
        if (closestIntersection == null) {
            return new Color(0.0, 0.0, 0.0);
        }
        Color objectColor = closestIntersection.getObject().getColor();
        Triplet normal = closestIntersection.getNormal().normalyze();




        // Calculez la couleur diffuse (Lambertian reflection)
        Color diffuseColor = objectColor.multiply(1);

        return diffuseColor;
    }

    private Intersection findClosestIntersection(Ray ray) {
        // Implémentez la logique de recherche de l'intersection la plus proche ici
        // et retournez l'intersection la plus proche ou null si aucune intersection
        return null;
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

                Ray ray = new Ray(scene.getCamera().getPosition(), direction);

                Color pixelColor = calculatePixelColor(ray);

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
        int imgWidth = 1900 / 2;
        int imgHeight = 1080 / 2;
        double fov = 60;
        String outputFileName = "test.png";

        Scene scene = SceneParser.parseScene("scene.txt");

        RayTracer rayTracer = new RayTracer(imgWidth, imgHeight, fov, outputFileName, scene);
        rayTracer.render();
        rayTracer.saveImage();
    }
}
