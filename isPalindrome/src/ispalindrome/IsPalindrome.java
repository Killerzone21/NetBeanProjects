
package ispalindrome;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  November 20, 2019
* 
* Assignment:  Program #1:  IsPalindrome
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: IsPalindrome.java, Java Problems.docx
* 
* Purpose:  Get a random word from the user and determine if its a palindrome
* 
* Input: String
* 
* Preconditions/Assumptions:  Only Words allowed
* 
* Output:  Original Word, Is Palindrome, Adjusted Message
* 
* Postconditions:  (optional)
* 
* Algorithm: 
i.	Import the scanner 
ii.	Ask the user for a word
iii.	Create 2 new strings: One will be empty (s2) and the other will be the user’s string but all in lowercase (s3)
iv.	In a for loop, copy the letters of the string (s3) with lowercase letters into the empty string (s2) backwards. Start at the end of the lowercase letters string and add them into the empty string
v.	Use an equals method from the String class to test whether the lowercase string (s3) matches the backwards string (s2). Output whether it is a palindrome or not
vi.	Output the user’s original string and the backwards string (s2).


***********************************************************************/ 

import java.util.Scanner;

public class IsPalindrome {

    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        String s1 = new String();
        
        System.out.println("Enter a word:");
        s1 = input.nextLine();
        
        String s2 = new String();
        
        String s3 = s1.toLowerCase();
        
        for(int i = s3.length()-1; i > -1; i--)
        {
            s2 = s2 + s3.charAt(i);
        }
        
        if(s3.equals(s2))
        {
            System.out.println("Is a Palindrome");
        }
        else
        {
            System.out.println("Is not a Palindrome");
        }
        
        System.out.println(s1);
        System.out.println(s2);
    }
    
}
