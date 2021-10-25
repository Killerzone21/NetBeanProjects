/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: October 1, 2019
 *
 * Assignment: Program #8: Problem2
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: Problem2.java
 *
 * Purpose: Debug incorrect code
 *
 * Input: None
 *
 * Preconditions/Assumptions: None
 *
 * Output: Corrected Code
 *
 * Postconditions: (optional)
 *
 * Algorithm: 
 *          N/A - Debugging Code
**********************************************************************
 */
package problem2;

public class Problem2 {

  
    public static void main(String[] args) {
        /*a)*/ 
        
       int age = 70; // age must be initialized prior to the if statement. 
       if ( age >= 65 ) // No semi-colon for it will end the if statement without doing a proper check
            System.out.println( "Age is greater than or equal to 65" );
       else  // bad indentation, must line up with the prior if statement.
            System.out.println( "Age is less than 65"); // bad indentation, must be slightly indented after the else or be on one line with it. 2nd set of Quotes must be inside the paraenthesis
        
        /*b)*/ 
        
       int x = 1, total = 0; // total is not initialized before while loop. Program won't run if total is not initialized before running the loop if the potential case for not entering it happens.
       while ( x <= 10 )
        {
            total += x; // Name must equal exactly as it was initialized up above.
            ++x;
        }
            
        /*c)*/ 
        
        while ( x <= 100 )
        {                   // This is a block code for the while loop so there must be brackets. Loop would be infinite without the x value incrementing
            total += x;
             ++x;
        }
        
        /*d)*/
        int y = 10; // Y must be initialized prior to running the loop
        while ( y > 0 )
         {
        System.out.println( y );
        --y;            // Value should decrement or the control variable in the loop must be changed. This would be an infinite loop otherwise.
         }              // Missing closing bracket for loop
    }
    
}
