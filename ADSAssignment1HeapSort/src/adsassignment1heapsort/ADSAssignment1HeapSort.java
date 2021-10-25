
package adsassignment1heapsort;

import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class ADSAssignment1HeapSort {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                
        System.out.println("Please enter the length of the array:");            // Ask user to input a length for the array
        
        int userinput = input.nextInt();
                
        int[] UserArray = new int[userinput];
        
        for(int i = 0; i < userinput; i++)
        {
            System.out.println("Please enter the next number:");
            int number = input.nextInt();
            UserArray[i] = number;                    
        }
        
        HeapSort(UserArray);                                                    // Program begins sort here
        PrintArray(UserArray);
    }
    
    private static void PrintArray(int[] array)                                 // Simple function to print out the sorted array
    {
        
        for(int i = 0; i < array.length; i++)
                System.out.print(array[i] + " ");
    }
    
    private static void HeapSort(int[] array)
    {
        int m = array.length;                                                   // Variable used for length of array
        
        for (int i = m / 2 - 1; i >= 0; i--)                                    // Tree is developed from heapify-ing the values given from the array. 
            heap(array, m, i); 
        
        for (int i = m - 1; i > 0; i--)                                         // After initial heap is developed, extract elements from the heap. 
        {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;                                                     // We move the root to the end so we can check subchildren
            
            heap(array, i, 0);                                                  // Heapify the reduced heap
        }
    }
    
    private static void heap(int[] array, int j, int k)                         // Our main heapify function. j acts as the size of the heap while k is the node in the array.
    {
        int largest = k;
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        
        
        if(left < j && array[left] > array[largest])                            //Check if the left child is larger than the root
            largest = left;
        
        if(right < j && array[right] > array[largest])                          //check if the right child is larger than the root
            largest = right;
        
        if (largest != k)                                                       // Is the root the largest value?
        {
            int tmp = array[k];
            array[k] = array[largest];
            array[largest] = tmp;
            
            heap(array, j, largest);                                            //Recursively check the adjusted tree now
        }
    }
    
}
