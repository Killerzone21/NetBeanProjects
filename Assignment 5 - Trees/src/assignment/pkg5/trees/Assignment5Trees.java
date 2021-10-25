
package assignment.pkg5.trees;


/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 2315
* 
* Date:  April 17, 2020
* 
* Assignment:  Program #5: Trees
* 
* Description: Design a program that utilizes the BinaryNode and BinarySearchTree data structure (and any necessary accompanying files)
*              Reimplement provided methods recursively for find, findmin, findmax, findkth (not implemented)
*              Print the Tree throughout usage
* 
* Environment:  Java with Netbeans IDE
***********************************************************************/

import java.util.Scanner;

public class Assignment5Trees {

  
    public static void main(String[] args) 
    {
       BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
       Scanner in = new Scanner(System.in);
       
       System.out.println("Welcome to the Binary Search Tree Program for Integers!");
 
       PrintInstructions();
               
       int decision = 0;
       int value = 0;
       
       while(decision != 11)
       {
           System.out.println("Please enter an action to do: ");
            
           decision = in.nextInt();
             
           switch(decision)
           {
               case 1:
                   System.out.println("Please enter a value:");
                   value = in.nextInt();
                   tree.insert(value);
                   break;
               case 2:
                   System.out.println("Please enter a value:");
                   value = in.nextInt();
                   tree.remove(value);
                   break;
               case 3:
                   System.out.println("Removing smallest value.");
                   tree.removeMin();
                   break;
               case 4:
                   System.out.println("Please Enter a value to find:");
                   value = in.nextInt();
                   System.out.println(tree.find(value) + " was located.");
                   break;
               case 5:
                   System.out.println("Finding smallest value.");
                   System.out.println(tree.findMin());
                   break;
               case 6:
                   System.out.println("Finding the maximum value.");
                   System.out.println(tree.findMax());
                   break;
               case 7:
                   System.out.println("Emptying the tree.");
                   tree.makeEmpty();
                   break;
               case 8:
                   System.out.print("Checking if the tree is empty: ");
                   if(tree.isEmpty())
                       System.out.println("Tree is empty.");
                   else
                       System.out.println("Tree is not empty.");
                   break;
               case 9:
                   System.out.println("Printing your Tree");
                   tree.print();                   
                   break;
               case 10:
                   PrintInstructions();
                   break;
               case 11:
                   System.out.println("Goodbye");
                   break;
               default:
                   break;
                   
           }
                          
           
       
       
       
       }
    }
    
    
    public static void PrintInstructions()
    {
        System.out.printf("Here is a list of actions for you to do:\n" 
                              + "1. Insert a Value into the Tree\n"
                              + "2. Remove a Value from the Tree\n"
                              + "3. Remove the smallest value from the Tree\n"
                              + "4. Find a value from the Tree\n"
                              + "5. Find the smallest value in the Tree\n"
                              + "6. Find the maximum value in the Tree\n"
                              + "7. Empty the Tree (Deletes all values)\n"
                              + "8. Check if the Tree is Empty\n"
                              + "9. Print the tree\n"
                              + "10. Print instructions\n"
                              + "11. Quit the program\n");   
    }

    
}
