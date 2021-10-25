package sphere;

import java.util.Scanner;

public class Sphere {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       mySphere obj1 = new mySphere();
       
       System.out.print("Enter radius of sphere:");
       double radius = input.nextDouble();
       
       System.out.printf("Volume is %f\n", obj1.sphereVolume(radius));
    }
    
}
