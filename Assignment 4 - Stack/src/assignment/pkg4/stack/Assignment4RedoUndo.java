
package assignment.pkg4.stack;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 2315
* 
* Date:  April 3, 2020
* 
* Assignment:  Program #4: Redo/Undo Stacks
* 
* Description: Design a program that utilizes the ListStack data structure (and any necessary accompanying files)
*              to create the undo/redo commands that Microsoft Word uses. 
* 
* Environment:  Java with Netbeans IDE
***********************************************************************/


import java.util.Scanner;

public class Assignment4RedoUndo
{
    public static void main(String []args)
    {

	Scanner in = new Scanner(System.in);
	System.out.print("Please enter a sentence of your choice: ");
	String s = in.nextLine();
        
        
        String[] WordArray = s.split(" ");
        
        int cursor = WordArray.length - 1;
        
        ListStack<String> undo = new ListStack<>();
        ListStack<String> redo = new ListStack<>();
        
        int action;
        
        String UndoWord;
        String RedoWord;
        
        PrintInstructions();
        
        do
        {
            
            System.out.println("Please enter an action to do: ");
            
            action = in.nextInt();
            in.nextLine();
            switch (action) {
                case 1:
                    redo.makeEmpty();
                    System.out.println("Please enter a word");
                    UndoWord = in.nextLine();
                    cursor++;
                    if(cursor == WordArray.length)
                        WordArray = ArrayExpand(WordArray);
                    WordArray[cursor] = UndoWord;   
                    undo.push("A" + UndoWord);
                    break;
                case 2:
                    redo.makeEmpty();
                    UndoWord = WordArray[cursor];
                    undo.push("D" + UndoWord);
                    WordArray[cursor] = null;
                    cursor--;
                    break;
                case 3:
                    UndoWord = undo.topAndPop();
                    redo.push(UndoWord);
                    if(UndoWord.charAt(0) == 'A')
                    {
                        WordArray[cursor] = null;
                        cursor--;
                    }
                    else if(UndoWord.charAt(0) == 'D')
                    {
                        UndoWord = UndoWord.substring(1, UndoWord.length());
                        cursor++;
                        WordArray[cursor] = UndoWord;
                    }  
                    UndoWord = null;
                    break;
                case 4:
                    RedoWord = redo.topAndPop();
                    if(RedoWord.charAt(0) == 'A')
                    {
                        cursor++;
                        WordArray[cursor] = RedoWord.substring(1, RedoWord.length());
                        
                    }
                    else if(RedoWord.charAt(0) == 'D')
                    {
                        WordArray[cursor] = null;
                        cursor--;
                    }  
                    RedoWord = null;
                    break;
                case 5:
                    for (int i = 0; i <= cursor; i++)
                    {
                        System.out.print(WordArray[i] + " ");           
                    }
                    System.out.println();
                    break;
                case 6:
                    PrintInstructions();
                    break;
                default:
                    break;
            }
            
            
        }
        while(action != 7);
        
    }
    
    public static String[] ArrayExpand(String array[])
    {
        String[] newArray = new String[array.length*2];
        
        System.arraycopy(array, 0, newArray, 0, array.length);
        
        return newArray;
    }
    
    public static void PrintInstructions()
    {
        System.out.printf("Here is a list of actions for you to do:\n" 
                              + "1. Add a word to the sentence\n"
                              + "2. Delete the last word added into the sentence\n"
                              + "3. Undo your previous action\n"
                              + "4. Redo your undo action\n"
                              + "5. Print the sentence\n"
                              + "6. Print Instructions again\n"
                              + "7. Quit out of the program!\n");
    }
}

    