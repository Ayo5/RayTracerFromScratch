package test.java;


import main.java.scene.Scene;
import main.java.scene.SceneParser;

public class SceneParserTest {

    public static void main(String[] args) {
        String fileName = "scene.txt"; // Remplacez "scene.txt" par le nom de votre fichier de configuration

        // Parse la scène à partir du fichier
        Scene scene = SceneParser.parseScene(fileName);

        // Affiche quelques informations sur la scène
        System.out.println("Nombre d'objets dans la scène : " + scene.getObjects().size());
        System.out.println("Camera de la scène : " + scene.getCamera());

        // Vous pouvez ajouter d'autres tests ici selon les besoins
    }
}
