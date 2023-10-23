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
    private BufferedImage image;

    public RayTracer(int imgWidth, int imgHeight, double fov, String outputFileName) {
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.fov = fov;
        this.outputFileName = outputFileName;
        this.image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
    }

    public void render() {
        // Create a scene
        Scene scene = createScene();

        // Eye position (lookFrom)
        Vector3 lookFrom = new Vector3(0, 0, 0); // Replace with your camera/eye position

        // Convert the field of view from degrees to radians
        double fovr = Math.toRadians(fov);

        // Calculate the dimensions of a pixel in the (u, v, w) coordinate system
        double pixelHeight = Math.tan(fovr / 2);
        double pixelWidth = pixelHeight * (imgWidth / (double) imgHeight);

        // Iterate through each pixel of the image
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                // Calculate the direction vector ⃗d from the eye (lookFrom) to pixel (i, j)
                Vector3 d = calculateDirectionVector(lookFrom, i, j, pixelWidth, pixelHeight);

                // Find the nearest intersection with an object in the scene
                Intersection intersection = scene.findNearestIntersection(lookFrom, d);

                if (intersection != null) {
                    // If an intersection is found, calculate the color of the object hit
                    Color pixelColor = calculateColor(intersection.getObject(), intersection.getPoint());

                    // Paint the pixel (i, j) with the appropriate color in the image
                    image.setRGB(i, j, pixelColor.toRGB());
                } else {
                    // No intersection, paint the pixel black
                    image.setRGB(i, j, Color.BLACK.toRGB());
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
        int imgWidth = 800; // Largeur de l'image en pixels
        int imgHeight = 600; // Hauteur de l'image en pixels
        double fov = 60; // Champ de vision en degrés
        String outputFileName = "output.png"; // Nom du fichier de sortie

        RayTracer rayTracer = new RayTracer(imgWidth, imgHeight, fov, outputFileName);
        rayTracer.render();
        rayTracer.saveImage();
    }
}

