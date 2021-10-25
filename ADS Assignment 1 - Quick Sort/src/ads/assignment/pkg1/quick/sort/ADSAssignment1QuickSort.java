package ads.assignment.pkg1.quick.sort;

import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class ADSAssignment1QuickSort {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                
        System.out.println("Please enter the length of the array:");              // Ask user to input a length for the array
        
        int userinput = input.nextInt();
                
        int[] UserArray = new int[userinput];
        
        for(int i = 0; i < userinput; i++)
        {
            System.out.println("Please enter the next number:");
            int number = input.nextInt();
            UserArray[i] = number;                    
        }
        
        quicksort(UserArray, 0, UserArray.length -1);                              // Program begins sort here
        PrintArray(UserArray);
    }
    
    private static void PrintArray(int[] array)                                    // Simple function to print out the sorted array
    {
        
        for(int i = 0; i < array.length; i++)
                System.out.print(array[i] + " ");
    }
    
    private static void quicksort(int[] array, int low, int high)               // Begin quick sort based on partitioning and divide and conquer method
    {
        if( low + 5 > high)                                                    // If the array is small enough, we can solve it easily with insertion sort. Otherwise, follow the divide and conquer method until Array is small enough
            insertionSort(array, low, high);
        else                                                                    // If the array is too large, follow algorithm for quick sort. Divide it until insertion sort can conquer it easily.
        {
            int middle = (low + high) / 2;                                      // Identify initial middle number for pivot picking. 
            if(array[middle] < array[low])                                      // Is the middle number smaller than what is at the beginning?
                swapReferences( array, low, middle);
            if(array[high] < array[low])                                        // Is the last number smaller than what is at the beginning?
                swapReferences( array, low, high);
            if(array[high] < array[middle])                                     // Is the last number smaller than our middle number?
                swapReferences( array, middle, high);
            
            swapReferences( array, middle, high - 1);                           // Move our pivot number to the end
            
            int pivot = array[high - 1];                                        
            
            int i, j;
            for( i = low, j = high -1; ;)                                       // Using our pivot, we will identify our two partition arrays.
            {
                while( array[ ++i] < pivot)                                     // Are the numbers at the start of the array smaller than the pivot?
                    ;
                while( pivot < array[--j])                                      // Are the numbers at the end of the array larger than the pivot?
                    ;
                if( i >= j)                                                     // Have i and j crossed or reached each other?
                    break;
                swapReferences(array, i, j);                                    // If i and j haven't reached each other, then swap what is in i and j until the numbers smaller than the pivot are to the left and the larger numbers are to the right.
            }
            
            swapReferences( array, i, high - 1);                                // Put the pivot in the correct position now. This will divide the array into two smaller arrays.
            
            quicksort( array, low, i - 1);                                      // Repeat this process for the numbers to the left of the pivot (All numbers smaller than our initial pivot)
            quicksort( array, i+1, high);                                       // Repeat this process for the numbers to the right of the pivot (All numbers larger than our initial pivot)
        }
    }
    
    private static void swapReferences(int[] array, int index1, int index2)             //Assisting function for swapping numbers in an array
    {
        int tmp = array[ index1 ];
        array[ index1 ] = array[ index2 ];
        array[ index2 ] = tmp;
    }
    
    private static void insertionSort( int [ ] array, int low, int high )              //Our conquer function. We have divided the array small enough that we can solve it with insertion sort. 
    {
        for( int p = low + 1; p <= high; p++ )                                   
        {
            int temp = array[ p ];
            int j;

            for( j = p; j > low && temp < array[j - 1]; j-- )
                array[ j ] = array[ j - 1 ];
            array[ j ] = temp;
        }
    }   
}