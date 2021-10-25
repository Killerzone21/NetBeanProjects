
package gradeleveltest;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  November 20, 2019
* 
* Assignment:  Program #3:  GradeLetter
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: GradeLevel.java, GradeLevelTest.java, Java Problems.docx
* 
* Purpose:  Determine the Grade level of a text file
* 
* Input: TextFile
* 
* Preconditions/Assumptions:  Only Words allowed
* 
* Output:  Number of Lines, Number of words, number of sentences, number of syllables and final level Grade for reading it.
* 
* Postconditions:  (optional)
* 
* Algorithm: 
ii.	Create a GradeLevel Class based on the above application:
1.	Import all the necessary util classes.
2.	Create a private bufferreader so all methods can use it
3.	Create the ProcessWords method by reading a file, make a string for a new line and while newline reading is not null, add 1 to the num of lines, add the words to an array of strings, take the length of each token and add them to a variable called num words. Have it output the number of lines and words found.
4.	Return the number of words back to the main application
5.	Create the CountSentences method by reading in a file, create a string for punctuations, create a string newline and while its reading is not null, go through the length of the line until it reaches a punctuation, then add one to a sentence variable. Have it output the number of sentences found.
6.	Return the number of sentences back to the main application
7.	Create the CountSyllables method by reading a file, create an int value for syllables, create a string newline and while its reading is not null, add each word separated by spaces into an array of tokens. Then in a for loop, have it go through the array and divide the length of each token by 3. Add it to the syllables variable. Have it output the number of syllables.
8.	Return the number of syllables back to the main application.

***********************************************************************/ 

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class GradeLevel 
{
    
    private BufferedReader inputStream = null;
    
    
    public int ProcessWords() throws IOException
    {
        
	int NumLines = 0;
	int WordsInLine = 0;
        int NumWords = 0;
        
        try 
        {
            inputStream = new BufferedReader(new FileReader("C:\\Users\\Alexander\\Desktop\\Green Eggs and Ham.txt"));
            String newLine;
            while ((newLine = inputStream.readLine()) != null)
            {
		NumLines++;
		String[] tokens = newLine.split(" ");
		WordsInLine = tokens.length;
                NumWords = NumWords + WordsInLine;
            }
  
        } 
        finally 
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
	System.out.printf("The total Number of Lines is: %d ; The total number of Words is: %d \n", NumLines, NumWords); 
    
        return NumWords;
    }
    
    public int CountSentences() throws IOException
    {
        
        
        String punctuations = "?!.";
        int SentencesinFile = 0;
        
        try 
        {
            inputStream = new BufferedReader(new FileReader("C:\\Users\\Alexander\\Desktop\\Green Eggs and Ham.txt"));
            String newLine;
            while ((newLine = inputStream.readLine()) != null)
            {
                for(int i = 0; i < newLine.length(); i++)
                {
                    if(punctuations.indexOf(newLine.charAt(i)) != -1)
                        SentencesinFile++;
                }
            }
  
        } 
        finally 
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
	System.out.printf("Total Number of Sentences in this file is: %d \n", SentencesinFile); 
    
        return SentencesinFile;
    }
    
    public int CountSyllables() throws IOException
    {
        int Syllables = 0;
        
        try 
        {
            inputStream = new BufferedReader(new FileReader("C:\\Users\\Alexander\\Desktop\\Green Eggs and Ham.txt"));
            String newLine;
            while ((newLine = inputStream.readLine()) != null)
            {
                String[] tokens = newLine.split(" ");
                
                for(int i = 0; i < tokens.length; i++)
                {
                    Syllables = Syllables + (tokens[i].length()/3);
                }
            }
  
        } 
        finally 
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
	System.out.printf("Total Number of Syllables in this file is: %d \n", Syllables);
    
        return Syllables;
    }
}
