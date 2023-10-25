package test.java;

<<<<<<< HEAD
import sae301.Point;
import sae301.Sphere;
=======
import main.java.coordinate.Point;
import main.java.object.Sphere;
>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335

public class SphereTest {
    public static void main(String[] args) {
        String fileName = "sphere.txt";
        Sphere sphere = new Sphere();
        sphere.settingFromFile(fileName);
        Point centre = sphere.getCentre();
        double radius = sphere.getRadius();
        if (centre != null) {
            System.out.println("Centre de la sphère : (" + centre.getX() + ", " +
                    centre.getY() + ", " + centre.getZ() + ")");
        } else {
            System.out.println("Centre de la sphère non défini.");
        }
        System.out.println("Rayon de la sphère : " + radius );
            }
}
