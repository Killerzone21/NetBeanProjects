package arrayproblem3;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  October 30, 2019
* 
* Assignment:  Program #3:  ArrayProblem3
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: ArrayProblem3.java
* 
* Purpose:  Showcase an Array Expansion
* 
* Input: None
* 
* Preconditions/Assumptions: Array initialized already
* 
* Output:  Each step of the array expansion
* 
* Postconditions:  (optional)
* 
* Algorithm: 
i.	Create a MyArray that holds 5 integers
ii.	Output that Array using printArray method
iii.	Create a 2nd array that copies MyArray
iv.	Output both Arrays
v.	Assign MyArray to a new memory location that has double the size of the original array
vi.	Output both Arrays
vii.	In a for loop, assign the values from the 2nd array into MyArray
viii.	Output both Arrays
ix.	Assign the 2nd or copied array to null to allow for garbage collection.
***********************************************************************/ 

public class ArrayProblem3 
{

     public static void main(String[] args) 
    {
        
       
        int[] MyArray1 = {1,2,3,4,5};
        
        System.out.print("My Array: ");
        printArray(MyArray1);
        System.out.println();
        
        int[] CopyArray = MyArray1;
        
        System.out.print("My Array: ");
        printArray(MyArray1);
        System.out.print("Original Array: ");
        printArray(CopyArray);
        System.out.println();
        
        MyArray1 = new int[10];
        
        System.out.print("My Array: ");
        printArray(MyArray1);
        System.out.print("Original Array: ");
        printArray(CopyArray);
        System.out.println();
        
        for(int i = 0; i < CopyArray.length;i++)
        {
            MyArray1[i] = CopyArray[i];
            
        }
        System.out.print("My Array: ");
        printArray(MyArray1);
        CopyArray = null;
        System.out.println("Original Array: " + CopyArray);
    }
    
    public static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]);
        System.out.println();
    }
    
}
