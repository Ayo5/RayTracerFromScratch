package main.java;

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

    public void render() {
        // Calculez la largeur et la hauteur des pixels en fonction du champ de vision et de la taille de l'image
        double pixelWidth = 2.0 * Math.tan(Math.toRadians(fov / 2.0)) / imgWidth;
        double pixelHeight = 2.0 * Math.tan(Math.toRadians(fov / 2.0)) / imgHeight;

        // Parcourez tous les pixels de l'image
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {

                // Calculez le vecteur direction ⃗d
                Vector direction = scene.getCamera().calculateDirectionVector(i, j, pixelWidth, pixelHeight);

                // Créez un rayon à partir de la position de la caméra et de la direction calculée
                Ray ray = new Ray(scene.getCamera().getPosition(), direction);

                // Calculez l'intersection entre le rayon et les objets de la scène
                Intersection intersection = scene.calculateIntersection(ray);

                // Si le rayon a touché un objet, calculez la couleur du pixel
                if (intersection != null) {
                    Vector color = calculateColor(intersection, ray);
                    image.setRGB(i, j, color.toRGB());
                }
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
        int imgWidth = 800;
        int imgHeight = 600;
        double fov = 60;
        String outputFileName = "output.png";

        Scene scene = createScene();

        RayTracer rayTracer = new RayTracer(imgWidth, imgHeight, fov, outputFileName, scene);
        rayTracer.render();
        rayTracer.saveImage();
    }
}

