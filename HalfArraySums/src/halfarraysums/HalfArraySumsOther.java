package halfarraysums;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 2315
* 
* Date:  February 26 2020
* 
* Assignment:  Program #2: Half Array Sum Equality Problem  
* 
* Environment:  Java with Netbeans IDE
***********************************************************************/

import java.util.Scanner;

public class HalfArraySumsOther {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array;
        int len, mid;
        boolean found;

        System.out.println("Please enter the length of the array:");
        len = input.nextInt();
        array = new int[len];

        for (int i = 0; i < len; i++) {
            System.out.println("Please enter the next number into the array:");
            array[i] = input.nextInt();
        }

        if (array.length % 2 == 1) {
            mid = array.length / 2 + 1;
        } else {
            mid = array.length / 2;
        }

        found = DetermineEquality(array, (array.length / 2) - 1, array.length - 1, mid);

        if (found) {
            System.out.printf("Each half of the array add up to: %d\n", DetermineSum(array, (array.length / 2) - 1, mid));

            if (array.length % 2 == 1) {
                found = DetermineHalfArrayEquality(array, 0, array.length - 1, mid - 1);
            } else {
                found = DetermineHalfArrayEquality(array, 0, array.length - 1, mid);
            }

            if (found) {
                DetermineMirror(array, 0, array.length - 1);
            }
        } else {
            System.out.println("Each half of the array do not add up to the same number!");
        }

    }

    public static int DetermineSum(int[] array, int Cursor, int midpoint) {

        if (Cursor == 0 || Cursor == midpoint) {
            return array[Cursor];
        } else {
            return array[Cursor] + DetermineSum(array, Cursor - 1, midpoint);
        }
    }

    public static boolean DetermineEquality(int[] array, int leftCursor, int rightCursor, int midpoint) {
        return DetermineSum(array, leftCursor, midpoint) == DetermineSum(array, rightCursor, midpoint);

    }

    public static boolean DetermineHalfArrayEquality(int[] array, int leftCursor, int rightCursor, int midpoint) {
        if (leftCursor >= midpoint) {
            System.out.println("Both halves of the array contain the same number");
            return true;
        } else if ((array[leftCursor] != array[rightCursor]) && rightCursor == midpoint) {
            System.out.println("The numbers on the left are not the same as the numbers on the right");
            return false;

        } else if (array[leftCursor] != array[rightCursor]) {
            return DetermineHalfArrayEquality(array, leftCursor, rightCursor - 1, midpoint);
        } else {
            return DetermineHalfArrayEquality(array, leftCursor + 1, array.length - 1, midpoint);
        }
    }

    public static void DetermineMirror(int[] array, int leftCursor, int rightCursor) {
        if (leftCursor >= rightCursor) {
            System.out.println("Both halves of the array are mirrors of each other");
        } else if (array[leftCursor] != array[rightCursor]) {
            System.out.println("Both halves of the array are not mirrors of each other");
        } else {
            DetermineMirror(array, leftCursor + 1, rightCursor - 1);
        }
    }
}