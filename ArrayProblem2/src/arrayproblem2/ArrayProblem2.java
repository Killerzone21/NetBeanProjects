package arrayproblem2;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  October 30, 2019
* 
* Assignment:  Program #2:  ArrayProblem2
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: ArrayProblem2.java
* 
* Purpose:  User makes an array of their choice, any size and any dimension. Outputs that array and determines the average of the entire array
* 
* Input: Row, Column, Value
* 
* Preconditions/Assumptions:  Positive Integers only
* 
* Output:  Array, Average
* 
* Postconditions:  (optional)
* 
* Algorithm: 
i.	Create a Scanner object that takes inputs
ii.	Ask the user for the number of rows in the array
iii.	In a for loop, ask the user for the number of columns for each row
iv.	In another loop, ask the user for the values in each row and column.
v.	Add their value to a total and add one to the counter
vi.	Get the average and output their array and average following it.
***********************************************************************/ 

import java.util.Scanner;

public class ArrayProblem2 {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        int row, col, num;
        double avg, total = 0, count = 0;
        
        System.out.print("Please enter the number of rows for the array:");
        row = input.nextInt();
        
        int[][] myArr = new int[row][];
        
        for(int i = 0; i < myArr.length; i++)
        {
            System.out.printf("Please enter the number of columns for row #%d:", i + 1);
            col = input.nextInt();
            myArr[i] = new int[col];
        }
        for(int i = 0; i < myArr.length; i++)
        {
            for(int j = 0; j < myArr[i].length; j++)
            {
                System.out.printf("Please enter the value for row #%d, column #%d:", i, j);
                num = input.nextInt();
                myArr[i][j] = num;
                total += num;
                count++;
                        
            }
        }
        if(count == 0)
        {
            count = 1;
        }
        System.out.println("Here is your array");
        outputArray(myArr);
        avg = total / count;
        System.out.printf("The average of all elements in this array is: %5.2f\n", avg);
        
    }
    
    public static void outputArray(int[][] array)
    {
        for( int row = 0; row < array.length; row++)
        {
            for(int col = 0; col < array[row].length; col++)
            {
                System.out.printf(" %d ", array[row][col]);
            }
            System.out.println();
        }
        
    }
}
