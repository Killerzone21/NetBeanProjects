package arrayproblem;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  October 30, 2019
* 
* Assignment:  Program #1:  GradeBook
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: ArrayMethods.java, ArrayProblem1.java, Java Problems.docx
* 
* Purpose:  Get an array of 30 random integers, output the maximum, minimum, average and a bar chart for the values.
* 
* Input: None
* 
* Preconditions/Assumptions:  Array is already filled
* 
* Output:  Average, Maximum, Minimum, BarChart
* 
* Postconditions:  (optional)
* 
* Algorithm: 
i.	Create an Array application that does the provided actions:
1.	Import Random and create a random Object.
2.	Create an ArrayMethod object that contains methods for maximum, minimum, average and barchart.
3.	Initialize an array of 30 integers and assign random values to each spot using a for loop.
4.	Print out the maximum number in the array
5.	Print out the minimum number in the array
6.	Print out the average in array
7.	Print out the bar chart for the array.
ii.	Create an ArrayMethods class based on the application above:
1.	Create a maximum method that determines the max value inside an array. Use a for loop to go iterate through it.
2.	Create a minimum method that determines the smallest value inside an array. Use a for loop to iterate through it
3.	Create an average method that determine the average of all values inside an array. Use a for loop to iterate through it.
4.	Create a BarChart method that takes an array and makes a bar chart from it. Makes a new array that adds 1 to each assigned position based on the number from the array sent in. Then makes a bar chart using values x0 – x9 and adds a star to display the frequency.

***********************************************************************/ 

public class ArrayMethods {

    public int Maximum(int[] myArr) {
        int max = myArr[0];

        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] > max) {
                max = myArr[i];
            }
        }
        return max;
    }

    public int Minimum(int[] myArr) {
        int min = myArr[0];

        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] < min) {
                min = myArr[i];
            }
        }
        return min;
    }

    public double Average(int[] myArr) {
        double avg;
        int total = 0;

        for (int i = 0; i < myArr.length; i++) {
            total += myArr[i];
        }
        avg = total / myArr.length;
        return avg;
    }

    public void BarChart(int[] myArr) 
    {
        System.out.println("Displaying Bar Chart for this Array:");

        int[] frequency = new int[11];
        
        for (int num : myArr) 
        {
                ++frequency[num / 10];
        }
        
        for (int count = 0; count < frequency.length; count++) 
        {

            if (count == 10) {
                System.out.printf("%5d: ", 100);
            } else {
                System.out.printf("%02d-%02d: ",
                        count * 10, count * 10 + 9);
            }

            for (int stars = 0; stars < frequency[count]; stars++) {
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
}
