package node;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 2315
* 
* Date:  March 5 2020
* 
* Assignment:  Program #3: Node List Assigmment 
* 
* Environment:  Java with Netbeans IDE
***********************************************************************/

import java.util.Scanner;


public class NodeListAssignment 
{
    private static Node<Integer> head = new Node(null, null);
    private static Node end = head;
    private static Scanner input = new Scanner(System.in);        
    
    public static void main(String[] args) 
    {
               
        int[] array;
        
        int length; 
        
        System.out.println("Specify the length of the array");
        length = input.nextInt();
        
        array = new int[length];
        
        for(int i = 0; i < length; i++)
        {
            System.out.println("Please enter the next number");
            array[i] = input.nextInt();
        }
        
        int h = CreateList(array, length);
        System.out.println();
        
        System.out.print("Your current list: ");
        Cursor(head);
        
        System.out.println();
        System.out.printf("Value of the linked list's head: %d\n\n", h);
        
        shift(head);     
    }
    
    public static int CreateList(int[] array, int length)
    {                
        for(int i = length-1; i >= 0; i--)
        {
            if(array[i] % 2 == 0)
            {
                int value = array[i];
                end.setNext(new Node(value, null));
                end = end.getNext();
            }
            
        }
        for(int i = 0; i < length; i++)
        {
            if(array[i] % 2 == 1)
            {
                int value = array[i];
                end.setNext(new Node(value, null));
                end = end.getNext();
            }
            
        }   
        
        head = head.getNext();
        
        return head.getValue();
    }
    
    public static void Cursor(Node list)
    {
         while(list.getNext() != null)
        {
            System.out.print(list.getValue() + " ");
            list = list.getNext();
        } 
        System.out.print(list.getValue() + " ");
    }
    
    public static void shift(Node list)
    {
        System.out.println("How much do you want to shift the list?");
        int shiftkey = input.nextInt();
             
        while(shiftkey != 0)
        {
            Node value = list;
            value.setValue(list.getValue());
            list = list.getNext();
            value.setNext(null);
            end.setNext(value);
            end = end.getNext();
            shiftkey--;
        }
        System.out.println();
        System.out.println("List after the shift");
        Cursor(list);
    }
    
}
