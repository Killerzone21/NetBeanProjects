
package copylines;

////////////////////////////////////////////////////
/**
 *
 * Oracle Code modified by Charles Phillips
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CopyLines
{
    
    public static void main(String[] args) throws IOException
    {
       
    	BufferedReader inputStream = null;
        PrintWriter outputStream = null;
	int NumLines = 0;
	int WordsInLine = 0;
        double SentencesinFile = 0;
        double NumWords = 0;
	double NumSentences = 0;
        double Syllables = 0;
        double GradeLevel = 0;
        String delimiters = "?!.";
        
        try 
        {
            inputStream = new BufferedReader(new FileReader("C:\\Users\\Alexander\\Desktop\\gettysburg.txt"));
            outputStream = new PrintWriter(new FileWriter("C:\\Users\\Alexander\\Desktop\\GettysburgOutput.txt"));

            String newLine;
            while ((newLine = inputStream.readLine()) != null)
            {
                outputStream.println(newLine);
		NumLines++;
		String[] tokens = newLine.split(" ");
		WordsInLine = tokens.length;
                NumWords = NumWords + WordsInLine;
		System.out.printf("Number of Words in Line %d is: %d \n", NumLines, WordsInLine);
                
                for(int i = 0; i < newLine.length(); i++)
                {
                    if(delimiters.indexOf(newLine.charAt(i)) != -1)
                        SentencesinFile++;
                }
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
            if (outputStream != null) 
            {
                outputStream.close();
            }
        }
        
        double number1 = (NumWords/SentencesinFile * 0.39);
        double number2 = (Syllables/NumWords * 11.8);
        double number3 = number1 + number2;
        System.out.printf("%5.2f %5.2f %5.2f \n", number1,number2,number3);
        
        GradeLevel = number3 - 15.59;
        
	System.out.printf("The total Number of Lines is: %d ; The total number of Words is: %d \n", NumLines, (int) NumWords);
        System.out.printf("Total Number of Sentences in this file is: %d \n", (int) SentencesinFile);
        System.out.printf("Total Number of Syllables in this file is: %d \n", (int) Syllables);
        System.out.printf("The Grade Level for this text file is: %d \n", (int) GradeLevel);
    } 
}
