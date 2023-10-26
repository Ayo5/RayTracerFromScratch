package main.java;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;
import main.java.object.SceneObject;
import main.java.scene.Camera;
import main.java.scene.Scene;
import main.java.scene.SceneParser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RayTracer {
    private static final Scene scene = SceneParser.parseScene("sphere.txt");
    private static final BufferedImage image =
            new BufferedImage(scene.getImageWidth(), scene.getImageHeight(), BufferedImage.TYPE_INT_RGB);
    public RayTracer() {}

    public void saveImage() {
        try {
            File outputfile = new File(scene.getOutputFileName());
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int imgWidth = scene.getImageWidth();
        int imgHeight = scene.getImageHeight();

        Camera camera = scene.getCamera();
        Point lookFrom = camera.getLookFrom();
        Point lookAt = camera.getLookAt();

        Vector w_unNormalize = lookAt.subtract(lookFrom);
        Vector w = w_unNormalize.normalize();
        Vector u_unNormalize = w.dotVectorial(camera.getUp());
        Vector u = u_unNormalize.normalize();
        Vector v = w.dotVectorial(u).normalize();

        double fovr = Math.toRadians(camera.getFov());
        double realHeight = 2 * Math.tan(fovr / 2);
        double pixelHeight = realHeight / imgHeight;
        double realWidth = pixelHeight * imgWidth;
        double pixelWidth = realWidth / imgWidth;

        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                double a = (-realWidth / 2.0) + (i + 0.5) * pixelWidth;
                double b = (realHeight / 2.0) - (j + 0.5) * pixelHeight;
                Vector d = u.multiplicationScalar(a).addition(v.multiplicationScalar(b)).addition(w).normalize();

                Colors pixelColor = new Colors(0, 0, 0);
                double closestIntersection = Double.POSITIVE_INFINITY;

                for (SceneObject object : scene.getObjects()) {
                    double t = object.intersect(lookFrom, d);
                    if (t >= 0 && t < closestIntersection) {
                        closestIntersection = t;
                        pixelColor = object.getColor();
                    }
                }

                image.setRGB(i, j, pixelColor.toRGB());
            }
        }

        RayTracer rayTracer = new RayTracer();
        rayTracer.saveImage();
    }

}
