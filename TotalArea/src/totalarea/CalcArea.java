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


class CalcArea {

    public double calcTriangle(double width, double height)
    {
        return (width*height)/2;
    }
    
    public double calcRectangle(double width, double length)
    {
        return width * length;
    }
    
    public double calcCircle(double radius)
    {
        return (radius * radius) * Math.PI;
    }
        
}
