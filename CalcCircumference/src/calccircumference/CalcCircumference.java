package calccircumference;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  September 10, 2019
* 
* Assignment:  Program #2:  CalcCircumference
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: CalcCircumference.java, Java Problems.docx
* 
* Purpose:  Calculate Diameter, Area, and Circumference  
* 
* Input:   Radius
* 
* Preconditions/Assumptions:  Only positive integers are input
* 
* Output:  Diameter, Area, Circumference
* 
* Postconditions:  (optional)
* 
* Algorithm: 
*      Input radius
*      Output Area, Diameter, Circumference
***********************************************************************/ 

import java.util.Scanner; // program uses class Scanner

public class CalcCircumference {
    
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        int radius; // Input Radius
        
        System.out.print("Enter the radius of the circle: "); // prompt
        radius = input.nextInt(); // read input from user
        
        System.out.printf("Diameter is %d\n", 2*radius);        
        System.out.printf("Area is %f\n",(Math.PI * radius * radius));
        System.out.printf("Circumference is %f\n", (2 * Math.PI * radius));
        
    }
    
}
