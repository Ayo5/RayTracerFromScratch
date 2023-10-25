package main.java.scene;


import main.java.coordinate.Vector;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The RayTracer class is responsible for rendering a 3D scene to a 2D image using ray tracing.
 */
public class RayTracer {
    private int imgWidth; // Largeur de l'image en pixels
    private int imgHeight; // Hauteur de l'image en pixels
    private double fov; // Champ de vision en degrés
    private String outputFileName; // Nom du fichier de sortie
    private BufferedImage image; // Image en cours de construction
    private Scene scene; // Scène à rendre

    /**
     * Constructs a new RayTracer with the specified image dimensions, field of view, output file name, and scene.
     *
     * @param imgWidth        The width of the image in pixels.
     * @param imgHeight       The height of the image in pixels.
     * @param fov             The field of view in degrees.
     * @param outputFileName  The name of the output file.
     * @param scene           The scene to render.
     */
    public RayTracer(int imgWidth, int imgHeight, double fov, String outputFileName, Scene scene) {
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.fov = fov;
        this.outputFileName = outputFileName;
        this.image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        this.scene = scene;
    }

    /**
     * Renders the scene using ray tracing and constructs the image.
     */
    public void render() {
        double pixelWidth = 2.0 * Math.tan(Math.toRadians(fov / 2.0)) / imgWidth;
        double pixelHeight = 2.0 * Math.tan(Math.toRadians(fov / 2.0)) / imgHeight;

        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {

                Vector direction = scene.getCamera().getUp();

                Ray ray = new Ray(scene.getCamera().getPosition(), direction);

            }
        }
    }

    /**
     * Saves the constructed image to the specified output file.
     */
    public void saveImage() {
        try {
            File outputfile = new File(outputFileName);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of the program for rendering a scene with ray tracing.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int imgWidth = 800;
        int imgHeight = 600;
        double fov = 60;
        String outputFileName = "test.png";

        Scene scene = SceneParser.parseScene("scene.txt");

        RayTracer rayTracer = new RayTracer(imgWidth, imgHeight, fov, outputFileName, scene);
        rayTracer.render();
        rayTracer.saveImage();
    }
}

