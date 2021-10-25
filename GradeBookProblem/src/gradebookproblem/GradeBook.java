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

public class GradeBook {

    private String courseName;
    private int[][] grades;

    public GradeBook(String name, int[][] gradesArray) {
        courseName = name;
        grades = gradesArray;
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayMessage() {

        System.out.printf("Welcome to the grade book for\n%s!\n\n",
                getCourseName());
    }

    public void processGrades() {
        outputGrades();
        System.out.printf("\n%s %d\n%s %d\n\n",
                "Lowest grade in the grade book is", getMinimum(),
                "Highest grade in the grade book is", getMaximum());
        outputBarChart();
    }

    public int getMaximum() {
        int highGrade = grades[0][0];
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade > highGrade) {
                    highGrade = grade;
                }
            }
        }
        return highGrade;
    }

    public int getMinimum() {
        int lowGrade = grades[0][0];

        for (int[] studentGrades : grades) {

            for (int grade : studentGrades) {
                if (grade < lowGrade) {
                    lowGrade = grade;
                }
            }
        }
        return lowGrade;
    }

    public double getAverage(int[] setOfGrades) {
        int total = 0;
        for (int grade : setOfGrades) {
            total += grade;
        }
        return (double) total / setOfGrades.length;
    }

    public void outputBarChart() {
        System.out.println("Overall grade distribution:");
        int[] frequency = new int[11];
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                ++frequency[grade / 10];
            }
        }
        for (int count = 0; count < frequency.length; count++) {
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

    public void outputGrades() {
        System.out.println("The grades are:\n");
        System.out.print(" ");
        for (int test = 0; test < grades[0].length; test++) {
            System.out.printf("Test %d ", test + 1);
        }
        System.out.println("Average");
        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student %2d", student + 1);
            for (int test : grades[student]) {
                System.out.printf("%8d", test);
            }
            double average = getAverage(grades[student]);
            System.out.printf("%9.2f\n", average);
        }
    }
}
