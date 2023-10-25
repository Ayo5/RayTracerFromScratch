package main.java.scene;

import main.java.object.Plane;
import main.java.object.Sphere;
import main.java.object.Triangle;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SceneParser {

    public static Scene parseScene(String fileName) {
        Scene scene = new Scene(700, 700);
        try {
            File file = new File("src/main/ressource/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];

                    if (keyword.equals("directional")) {
                        DirectionalLight light = new DirectionalLight(null,null);
                        light.loadPropertiesFromFile(fileName);
                        scene.addLight(light);
                    }

                    if (keyword.equals("point")) {
                        PointLight light = new PointLight(null,null);
                        light.loadPropertiesFromFile(fileName);
                        scene.addLight(light);
                    }

                    if (keyword.equals("sphere")) {
                        Sphere sphere = new Sphere(null,0,null);
                        sphere.settingFromFile(fileName);
                        scene.addObject(sphere);
                    }

                    if (keyword.equals("plane")) {
                        Plane plane = new Plane(null,null,null);
                        plane.settingFromFile(fileName);
                        scene.addObject(plane);
                    }

                    if (keyword.equals("maxverts")) {
                        Triangle triangle = new Triangle(null, null ,null, null);
                        triangle.settingFromFile(fileName);
                        scene.addObject(triangle);
                    }

                    if (keyword.equals("camera")) {
                        Camera camera = new Camera(null,null,null,0);
                        camera.loadCameraSettingsFromFile(fileName);
                        scene.setCamera(camera);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
        return scene;
    }
}
