
package gradeleveltest;


/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  November 20, 2019
* 
* Assignment:  Program #3:  GradeLevel
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
i.	Create a GradeLevelTest Application:
1.	Make a new object called GradeLevel.
2.	Call in three methods: ProcessWords, CountSentences and Count Syllables
3.	Assign the methods return values to a variable
4.	Determine gradelevel via the equation 0.39(ProcessWords/CountSentences) + 11.8(CountSyllables/ProcessWords) – 15.59
5.	If the value is less than 0, it is assumed the grade level can be read at 1.
6.	Print out the grade level for the textfile.
***********************************************************************/ 


import java.io.IOException;


public class GradeLevelTest {

    
    public static void main(String[] args) throws IOException 
    {
        
  
        
        GradeLevel File = new GradeLevel();
        
        int NumWords = File.ProcessWords();
        
        int NumSentences = File.CountSentences();
        
        int NumSyllables = File.CountSyllables();
        
        int Gradelevel = (int) ( ((NumWords/NumSentences) * 0.39) + ( (NumSyllables/NumWords) * 11.8) - 15.59);
        
        if(Gradelevel < 0)
        {
            Gradelevel = 1;
        }
        System.out.printf("The Grade Level for this file is: %d \n", Gradelevel);
    }
    
}
