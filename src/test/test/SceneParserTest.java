package test;

import main.java.object.SceneObject;
import main.java.scene.Scene;
import main.java.scene.SceneParser;


public class SceneParserTest {

    public static void main(String[] args) {
        String fileName = "sphere.txt";


        Scene scene = SceneParser.parseScene(fileName);
        double camx= scene.getCamera().getLookFrom().getX() ;
        double camy= scene.getCamera().getLookFrom().getY() ;
        double camz= scene.getCamera().getLookFrom().getZ() ;
        // Affiche quelques informations sur la scène
        System.out.println("Nombre d'objets dans la scène : " + scene.getObjects().size());
        for (SceneObject object : scene.getObjects()) {
            System.out.println("Object " + object + " : " + object.getColor().getR());
        }
        System.out.println("Camera de la scène : " + camx + "; " + camy + "; " + camz);
        System.out.println("Nombre de lumière: " + scene.getLights().size());
        System.out.println("Image width: " + scene.getImageWidth());
        System.out.println("Image height: " + scene.getImageHeight());

    }
}
