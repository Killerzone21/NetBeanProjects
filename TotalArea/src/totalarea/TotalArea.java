/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: October 8, 2019
 *
 * Assignment: Program #8: Total Area of shapes
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: TotalArea.java, CalcArea.java, Java Problems.docx
 *
 * Purpose: Allows user to input any number and combination of shapes and get their individual and combined areas.
 *
 * Input: Number of shapes (triangle, rectangle, circle) and the width, and length(height for triangle).
 *
 * Preconditions/Assumptions: Only positive numbers are entered for the dimensions, no negative numbers for number of shapes
 *
 * Output: Dimensions and area of each individual shape, then the total area of all inputted shapes
 *
 * Postconditions: (optional)
 *
 * Algorithm: Create a CalcArea object that holds 3 methods for calculating a triangle, rectangle and circle's area.
 *            Ask the user for how many triangles, rectangles and circles there are. 
 *            Ask the user for the dimensions of a triangle, then output the dimensions and area of that shape
 *            Repeat until all triangles are entered in
 *            Ask the user for the dimensions of a rectangle, then output the dimensions and area of that shape
 *            Repeat until all rectangles are entered in
 *            Ask the user for the dimensions of a circle, then output the dimensions and area of that shape
 *            Repeat until all circles are entered in
 *            Output the total area for all inputted shapes.
**********************************************************************
* **/
package totalarea;

import java.util.Scanner;

public class TotalArea {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        CalcArea myArea = new CalcArea();
        
        int triangle = 0, rectangle = 0, circle = 0;
        double length = 0, width = 0, area = 0, totalarea = 0;
        
        System.out.print("Please enter the number of triangles:");
        triangle = input.nextInt();
        System.out.print("Please enter the number of rectangles:");
        rectangle = input.nextInt();
        System.out.print("Please enter the number of circles:");
        circle = input.nextInt();
        
        for(int i = 0; i < triangle; i++)
        {
            System.out.printf("\nPlease enter the base width of triangle %d:", i+1);
            width = input.nextDouble();
            System.out.printf("Please enter the height of triangle %d:", i+1);
            length = input.nextDouble();
            area = myArea.calcTriangle(width,length);
            totalarea = totalarea + area;
            System.out.printf("The dimensions of triangle %d are %3.2f and %3.2f with an area of %3.2f square units.\n\n", i+1, width, length, area);
        }
        for(int i = 0; i < rectangle; i++)
        {
            System.out.printf("Please enter the width of rectangle %d:", i+1);
            width = input.nextDouble();
            System.out.printf("Please enter the length of rectangle %d:", i+1);
            length = input.nextDouble();
            area = myArea.calcRectangle(width,length);
            totalarea = totalarea + area;
            System.out.printf("The dimensions of rectangle %d are %3.2f and %3.2f with an area of %3.2f square units.\n\n", i+1, width, length, area);
        }
        for(int i = 0; i < circle; i++)
        {
            System.out.printf("Please enter the radius of circle %d:", i+1);
            width = input.nextDouble();
            area = myArea.calcCircle(width);
            totalarea = totalarea + area;
            System.out.printf("The radius of circle %d is %3.2f with an area of %3.2f square units.\n\n", i+1, width, area);
        }
        
        System.out.printf("The combined area for %d triangle(s), %d rectangle(s), and %d circle(s) is: %3.2f square units\n", triangle, rectangle, circle, totalarea);
        
    }
    
}
