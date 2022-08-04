package checkingforcomment;

/*
    This is a simple program to test a state diagram written for a comment
    Learning Parsing, Lexical/Syntax Analysis, Lexical Analysis, and Grammar
    Written by: Alexander Quirindongo in Apache Netbeans IDE 12.6
*/


import java.util.Scanner;

public class CheckingForComment {
    
    public static void main(String[] args)
    {
        /*
            This is a simple main function to check whether a user has inputted a valid comment
        */
        int letter;
        int state = 0;
        String Userinput;
    
        Scanner kbin = new Scanner(System.in);
        System.out.print("Please enter a comment: ");
        Userinput = kbin.nextLine();
       
        char[] comment = Userinput.toCharArray();       // Convert the string into an array of characters to check each character inputted
        
        for(letter = 0; letter < comment.length; letter++)
        {
            switch(state)
            {
                case 0: 
                {
                    if(comment[letter] == '/')          // First state, do we have a /?
                    {
                        state = 1; 
                    }
                    break;
                }
                case 1:
                {
                    if(comment[letter] == '*')          // Second State, do we have a *?
                    {
                        state = 2; 
                    }
                    break;
                }
                case 2:
                {
                    if(comment[letter] == '*')          // Third State, do we have another *?
                    {
                        state = 3; 
                    }
                    break;
                }
                case 3:
                {
                    if(comment[letter] == '*')          // Check if another * was inputted, return to state 3 if so
                    {
                        state = 3; 
                    }
                    
                    else if (comment[letter] == '/')    // Check if another / was inputted, go to state 4 if so to close out the comment
                    {
                        state = 4;
                    }
                    else
                    {
                        state = 2;                      // If no * or /, means user wrote other characters, go back to state 2 as they are still writing a comment
                    }      
                    break;
                }
                case 4:                                 // We have entered acceptance state, and thus, their comment is finished
                {
                    break;
                }
            }
        }
            if(state == 4)
            {
                System.out.println("The string you have inputted is recognized as a comment!");
            }
            else
            {
                System.out.println("The string you have inputted is not recognized as a comment!");
            }
        }   
    }
