package lettergrade;

/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: October 1, 2019
 *
 * Assignment: Program #4: LetterGrade
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: LetterGrade.java, Java Problems.docx
 *
 * Purpose: Determine Letter Grade from integer input
 *
 * Input: Grade in Number (Integer)
 *
 * Preconditions/Assumptions: Only positive integers are input
 *
 * Output: Letter Grade, average
 *
 * Postconditions: (optional)
 *
 * Algorithm: Input number
 *            While the number is positive
 *           {
 *                  Determine whether the number is within certain grade ranges
 *                  Output the letter grade
 *                  Ask User for new number if they want to continue
 *           }
 *            Determine the average for all inputted grades
**********************************************************************
 */

import java.util.Scanner;

public class LetterGrade {

  
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int GradeNumber;
        double Total = 0;
        int count = 0;
        
        System.out.print("Enter Grade number between 1 - 100, enter 0 or a negative number to exit:");
        GradeNumber = input.nextInt();
        
        while(GradeNumber > 0)
        {
            
            if(GradeNumber > 90)
                System.out.println("Your Letter Grade is: A");
            else if(GradeNumber > 80)
                System.out.println("Your Letter Grade is: B");
            else if(GradeNumber > 70)
                System.out.println("Your Letter Grade is: C");
            else if(GradeNumber > 60)
                System.out.println("Your Letter Grade is: D");
            else
                System.out.println("Your Letter Grade is: F");
            
            Total = Total + GradeNumber;
            count++;
            
            System.out.print("Enter Grade number between 1 - 100, enter 0 or a negative number to exit:");
            GradeNumber = input.nextInt();
        }
        double average = Total/count;
        
        System.out.printf("The average for these %d grades is: %5.2f\n",count,average);
        
    }
}