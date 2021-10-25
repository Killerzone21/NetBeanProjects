/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: October 1, 2019
 *
 * Assignment: Program #7: Problem1
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: Problem1.java
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
package problem1;

public class Problem1 {

  
    public static void main(String[] args) {
        /*a)*/ 
        
        int c = 1; // Need to define c and give it a starting counter that works for the loop
        int product = 1; // Need to Define product so it can be used to multiply with c
        
        while ( c <= 5 )
        {                   
            product *= c;
            System.out.println(product);
            ++c;
        }       // Need a closing bracket for the block code
        
        /*b)*/ 
        
        int gender = 1; // Need to define the value for gender in order to test it
        
        if ( gender == 1 )
            System.out.println( "Woman" );
        else            // Remove the semi-colon so that it can properly execute the next line. It will execute it otherwise since the semi-colon ends the statement
            System.out.println( "Man" );
            
        /*c)*/ 
        
        int z = 5;  // Need to define z and give it a starting counter to work with the loop
        int sum = 0; // Need to define sum for the loop
        while ( z >= 0 )
        {                   // Need opening and closing brackets for the block of code. It needs to manipulate the z counter so that it can exit the loop
            sum += z;
            z--; // Z needs to be manipulated so that the loop can exit
        }
            System.out.println(sum); // Need a semi-colon to end the statement.
    }
    
}
