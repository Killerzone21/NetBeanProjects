package gradebookproblem;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 1471 
* 
* Date:  October 30, 2019
* 
* Assignment:  Program #4:  GradeBook
* 
* Environment:  Java with Netbeans IDE
* 
* Files Included: GradeBookProblem.java, GradeBook.java, Java Problems.docx
* 
* Purpose:  Output Student Grades, their average, highest grade, lowest grade and their distribution  
* 
* Input: None
* 
* Preconditions/Assumptions:  Array is already filled
* 
* Output:  Student Grades, Average, Highest Grade, Lowest Grade, BarChart
* 
* Postconditions:  (optional)
* 
* Algorithm: 
i.	Create a GradeBookTest application with the following:
1.	Initialize an array with predetermined values for each student
2.	Create a Gradebook object with arguments: Title of class and array of grades.
3.	Call methods for display message and processing grades
ii.	Create a GradeBook class that is usable by the application above:
1.	Create 2 private class variables for course name and grades
2.	Create a constructor for Grade book that takes a string name and an array of grades and assigns them to their appropriate variables
3.	Create methods for setting the coursename, get coursename, and to display the message using the coursename.
4.	Create a process grades method that calls outputGrades(), getMinimum(), getMaximum(), and outputs a barchart for the array of grades.
5.	Create a method for getMaximum which returns the max grade from the array
6.	Create a method for getMinimum which returns the minimum grade from the array
7.	Create a method for getAverage which returns the average of all grades for the student.
8.	Create a method for outputting the barchart which shows the frequency of grades within a set range
9.	Create a method for outputting the grades for each student and show them the average for all their grades.

***********************************************************************/ 

public class GradeBookProblem 
{

        public static void main(String[] args) 
        {

            int[][] gradesArray = {{87, 96, 70},
            {68, 87, 90},
            {94, 100, 90},
            {100, 81, 82},
            {83, 65, 85},
            {78, 87, 65},
            {85, 75, 83},
            {91, 94, 100},
            {76, 72, 84},
            {87, 93, 73}};
            GradeBook myGradeBook = new GradeBook(
                    "CSCI3134 Introduction to Java Programming", gradesArray);
            myGradeBook.displayMessage();
            myGradeBook.processGrades();
        } 
    } 
