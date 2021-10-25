
package assignment6;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 2315
* 
* Date:  April 29, 2020
* 
* Assignment:  Program #6: Sorting Algorithms
* 
* Description: Design a program that utilizes sorting algorithms publicly available by Mark Allen Weiss
*              User specifies an array length and inserts it with random integers. They then select their 
*              choice of sorting algorithm. The program then sorts it and removes duplicates before printing the array
* 
* Environment:  Java with Netbeans IDE
***********************************************************************/
import java.util.Scanner;


public class Assignment6
{

    
    public static void main(String[] args) 
    
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to the Sorting Program!");
        
        System.out.println("Please enter the length of the array:");
        
        int userinput = input.nextInt();
                
        int[] UserArray = new int[userinput];
        
        for(int i = 0; i < userinput; i++)
        {
            System.out.println("Please enter the next number:");
            int number = input.nextInt();
            UserArray[i] = number;                    
        }
        
        System.out.printf("Here is a list of sorts you may use:\n" 
                              + "1. Insertion Sort\n"
                              + "2. Shell Sort\n"
                              + "3. Merge Sort\n"
                              + "4. Quick Sort\n");
        
        System.out.println("Please enter which array you want to use");
        
        userinput = 0;
        
        userinput = input.nextInt();
        
        while(userinput < 1 || userinput > 4)
        {
            System.out.println("That is not a valid selection, please try again:");
            userinput = input.nextInt();
        }
            
        switch(userinput)
            {
                case 1:
                    insertionSort(UserArray);
                    break;
                case 2:
                    shellsort(UserArray);
                    break;
                case 3:
                    mergeSort(UserArray);
                    break;
                case 4:
                    quickSort(UserArray);
                    break;
                default:
                    break;
            }
        
        removeDuplicates(UserArray, UserArray.length);
    }
    
    private static void PrintArray(int[] array, int length)
    {
        
        for(int i = 0; i < length; i++)
            if(array[i] != array[i + 1])
                 System.out.print(array[i] + " ");
    }
      
    public static void removeDuplicates( int[] array, int end)
    {
        
        int j = 0, m = 0;
        
        int[] duplicateArray = new int[end];
        
        for(int i = 0; i < end - 1; i++)
        {
            if(array[i] != array[i+1])
                array[j++] = array[i];
            else
                duplicateArray[m++] = array[i];
        }
        
        array[j++] = array[end - 1];
        
        System.out.print("Your sorted array is: ");
        PrintArray(array, j);
        System.out.println();
        System.out.print("Your Duplicated Values are: ");
        PrintArray(duplicateArray, m);
        
    }
    
    public static void insertionSort( int[] array)
    {
        for( int i = 1; i < array.length; i++)
        {
            int temp = array[ i ];
            int position = i;
            
            for( ; position > 0 && temp < array[position - 1]; position--)
            {
                array[position] = array[position - 1];
            }
            array[position] = temp;
        }
    }
    
    public static void shellsort( int[] array)
    {
        for(int gap = array.length / 2; gap > 0; gap = gap == 2 ? 1: (int) (gap / 2.2))
            for( int i = gap; i < array.length; i++)
            {
                int temp = array[ i ];
                int position = i;
                
                for( ; position >= gap && temp < array[position - gap]; position -= gap)
                    array[position] = array[ position - gap];
                array[position] = temp;
            }
    }
    
    public static void mergeSort( int[] array)
    {
        int[] tempArray = new int[array.length];
        mergeSort( array, tempArray, 0, array.length - 1);
    }
    
    private static void mergeSort(int[] array, int[] tempArray, int left, int right)
    {
        if( left < right)
        {
            int center = (left + right) / 2;
            mergeSort( array, tempArray, left, center);
            mergeSort( array, tempArray, center + 1, right);
            merge( array, tempArray, left, center + 1, right);
        }        
    }
    
    private static void merge(int[] array, int[] tempArray, int leftPos, int rightPos, int rightEnd)
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        
        while( leftPos <= leftEnd && rightPos <= rightEnd)
            if( array[leftPos] <= array[rightPos])
                tempArray[ tmpPos++ ] = array[ leftPos++];
            else
                tempArray[ tmpPos++ ] =  array[ rightPos++ ];
        
        while( leftPos <= leftEnd)
            tempArray[ tmpPos++ ] = array[ leftPos++ ];
        
        while( rightPos <= rightEnd)
            tempArray[ tmpPos++ ] = array[ rightPos++ ];
        
        for( int i = 0; i < numElements; i++, rightEnd--)
            array[rightEnd] = tempArray[ rightEnd ];
    }
    
    public static void quickSort( int[] array)
    {
        quicksort( array, 0, array.length - 1);
    }
    
    private static void quicksort(int[] array, int low, int high)
    {
        if( low + 10 > high)
            insertionSort(array, low, high);
        else
        {
            int middle = (low + high) / 2;
            if(array[middle] < array[low])
                swapReferences( array, low, middle);
            if(array[high] < array[low])
                swapReferences( array, low, high);
            if(array[high] < array[middle])
                swapReferences( array, middle, high);
            
            swapReferences( array, middle, high - 1);
            
            int pivot = array[high - 1];
            
            int i, j;
            for( i = low, j = high -1; ;)
            {
                while( array[ ++i] < pivot)
                    ;
                while( pivot < array[--j])
                    ;
                if( i >= j)
                    break;
                swapReferences(array, i, j);
            }
            
            swapReferences( array, i, high - 1);
            
            quicksort( array, low, i - 1);
            quicksort( array, i+1, high);
        }
    }
    
    private static void swapReferences(int[] array, int index1, int index2)
    {
        int tmp = array[ index1 ];
        array[ index1 ] = array[ index2 ];
        array[ index2 ] = tmp;
    }
    
    private static void insertionSort( int [ ] array, int low, int high )
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
