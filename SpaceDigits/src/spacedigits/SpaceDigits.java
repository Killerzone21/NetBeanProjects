package spacedigits;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  September 10, 2019
* 
* Assignment:  Program #3:  Space Digits
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: SpaceDigits.java, Java Problems.docx
* 
* Purpose:  Determine even/odd number, space the digits in number  
* 
* Input:  5 - digit number 
* 
* Preconditions/Assumptions:  Only positive integers are input
* 
* Output:  Even/Odd Number, digits in numbers spaced evenly
* 
* Postconditions:  (optional)
* 
* Algorithm: 
*      Input 5-digit number
*      Output even or odd
*      Output the 5 digits in number spaced  
***********************************************************************/ 

import java.util.Scanner; // program uses class Scanner

public class SpaceDigits {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        int Space; // Space integer
        
        System.out.println("Please enter a 5 digit number: ");
        Space = input.nextInt();
        
        if(Space % 2 == 0){
            System.out.println("This integer is even.");
        }
        else{
            System.out.println("This integer is odd.");
        }
        int Digit5 = Space % 10;
        int Digit4 = (Space/10)%10;
        int Digit3 = (Space/100)%10;
        int Digit2 = (Space/1000)%10;
        int Digit1 = Space/10000; 
        
        System.out.printf("Digits in %d are %d %d %d %d %d ", Space, Digit1,Digit2,Digit3,Digit4,Digit5);
    }
    
}
