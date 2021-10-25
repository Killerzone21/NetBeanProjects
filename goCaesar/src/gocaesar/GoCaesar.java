
package gocaesar;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  November 20, 2019
* 
* Assignment:  Program #2:  GoCaesar
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: GoCaesar.java, Java Problems.docx
* 
* Purpose:  Get a random word from the user and encrypt or decrypt it
* 
* Input: String
* 
* Preconditions/Assumptions:  Only Words allowed, Positive integers
* 
* Output:  Original Message, Encrypted/Decrypted Message
* 
* Postconditions:  (optional)
* 
* Algorithm: 
i.	Ask the user for a message
ii.	Ask the user if they want to encrypt or decrypt the message: Check if they enter a value greater than 1 or less than 0.
iii.	Ask the user for an integer value as the key. Check if they don’t enter an integer
iv.	If the key entered is less than 0 (negative number), cancel the negation. 
v.	Have the key take the remainder of 26 if the user happens to enter a number bigger than 26.
vi.	For Encrypting a message:
1.	In a for loop, go through the length of the message and grab the index letter. If the letter is between a and z, take a new letter by adding the key’s value to the acquired letter. If the new letter is greater than z, then have it add the value of a and subtract the value of z while also subtracting 1 (values start at 0). 
2.	Add the letter to an encrypted message string
3.	Uppercase the message and output both the encrypted message and the user’s original message.
vii.	For Decrypting a message:
1.	In a for loop, go through the length of the message and grab the index letter. If the letter is between a and z, take a new letter by subtracting the key’s value from the acquired letter. If the new letter is less than a, then have it subtract the value of a and add the value of z while also adding 1 (values start at 0). 
2.	Add the letter to a decrypted message string
3.	Output both the original message and the decrypted message.

***********************************************************************/ 


import java.util.InputMismatchException;
import java.util.Scanner;

public class GoCaesar {

    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       int key = 0;
       int type = 0;
       String message = "";
       String lowerMessage = "";
       String Encrypted = "";
       String Decrypted = "";
       
       System.out.print("Please enter a message: ");
       
       message = input.nextLine();
       
       lowerMessage = message.toLowerCase();
       
       boolean continueLoop = true;
       
       do
       {
         try
         {
           
       
                System.out.print("Do you want to encrpyt or decrypt a message? Enter 0 for Encryption and 1 for Decryption: ");
                type = input.nextInt();       
       
                if (type > 1 || type < 0)
                    throw new IndexOutOfBoundsException();
                
                continueLoop = false;
         }
         catch (IndexOutOfBoundsException e)
         {
                   System.err.printf( "\nException: %s\n", e);
                   System.out.println("Please either enter 0 for encryption or 1 for decryption!\n");
         }
       }
       
       while (continueLoop);
       
       continueLoop = true;
       
        do 
        {
            try
            {
               
                
                if(type == 0)
                     System.out.print("Please enter a key to encrypt: ");
                if(type == 1)
                     System.out.print("Please enter a key to decrypt: ");

                key = input.nextInt();
                
                continueLoop = false;
            }
            catch ( InputMismatchException inputMismatchException)
            {
                System.err.printf( "\nError: %s\n", inputMismatchException );
                
                input.nextLine();
                System.out.println("You must enter integers. Please try again. \n");
            }
            
        }    while( continueLoop );
       
       if(key < 0)
           key *= -1;
       if(key > 26) 
           key %= 26; 
        
       if(type == 0)
       {
           for(int i = 0; i < lowerMessage.length(); i++)
           {
               char letter = lowerMessage.charAt(i);
               if( letter >= 'a' && letter <= 'z')
               {
                   letter = (char) (letter + key);
                   if ( letter > 'z' )
                       letter = (char) (letter + 'a' - 'z' - 1);
                   Encrypted = Encrypted + letter;
               }
           }
           Encrypted = Encrypted.toUpperCase();
           System.out.println("The Encrypted Message is: " + Encrypted);
           System.out.println("Your original Message is: " + message);
       }
       else if(type == 1)
       {
           for(int i = 0; i < lowerMessage.length(); i++)
           {
               char letter = lowerMessage.charAt(i);
               if( letter >= 'a' && letter <= 'z')
               {
                   letter = (char) (letter - key);
                   if( letter < 'a' )
                       letter = (char) (letter - 'a' + 'z' + 1);
                   Decrypted = Decrypted + letter;
               }
           }
           
           System.out.println("The Decrypted Message is: " + Decrypted);
           System.out.println("Your original Message is: " + message);
       }
    }
}