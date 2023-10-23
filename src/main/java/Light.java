package main.java;
<<<<<<< HEAD

=======
>>>>>>> ecd4e5def82c0f752933cad18b8d364303b198c8
import java.io.*;

public class Light {
    private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void loadPropertiesFromFile(String filePath) {
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length >= 1) {
                    if (words[0].equals("color")) {
                        if (words.length >= 4) {
                            try {
                                double r = Double.parseDouble(words[1]);
                                double g = Double.parseDouble(words[2]);
                                double b = Double.parseDouble(words[3]);
                                color = new Color(r, g, b);
                            } catch (NumberFormatException e) {
                                System.out.println("Format de nombre invalide dans la ligne 'color'.");
                            }
                        } else {
                            System.out.println("Format invalide dans la ligne 'color'.");
                        }
                    }
                }
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
<<<<<<< HEAD
=======

>>>>>>> ecd4e5def82c0f752933cad18b8d364303b198c8
