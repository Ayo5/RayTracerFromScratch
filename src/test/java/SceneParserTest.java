package test.java;

import main.java.scene.Scene;
import main.java.scene.SceneParser;

/**
 * This class contains a test for the SceneParser that reads and parses a scene configuration file.
 * It then prints some basic information about the parsed scene, including the number of objects, the camera,
 * and the number of lights.
 */
public class SceneParserTest {

    public static void main(String[] args) {
        String fileName = "scene.txt"; // Replace "scene.txt" with the name of your configuration file

        // Parse the scene from the file
        Scene scene = SceneParser.parseScene(fileName);

        // Print some information about the scene
        System.out.println("Number of objects in the scene: " + scene.getObjects().size());
        System.out.println("Camera of the scene: " + scene.getCamera());
        System.out.println("Number of lights: " + scene.getLights().size());

        // You can add additional tests here as needed
    }
}
