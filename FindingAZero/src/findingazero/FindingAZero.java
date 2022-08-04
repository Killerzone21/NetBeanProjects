package findingazero;

/*------------------------------------------------------------------------------------------
    a. PROGRAMMER: Alexander Quirindongo

     b. COURSE: CSCI 3231.01

     c. DATE:  March 1 2022

     d. ASSIGNMENT:  Finding a Zero

     e. ENVIRONMENT: Windows 10, Apache Netbeans IDE 12.6, Java

     f. FILES INCLUDED: FindingAZero.java

     g. PURPOSE:  Using the secant method to solve a function where it equals zero.

     h. INPUT: Function is provided: x^5 - 0.2 sin(x) - 10.0 = 0 
               Initial values given: x = 1.0, x = 2.0, abs(f(x)) < 0.000000001.

     i. PRECONDITIONS: Provided answer is correct: 1.591181352398073

     j. OUTPUT: Trial number n, value for x, and answer for f(x)     

     l. ALGORITHM:
    Start with two random points (we will use the provided guesses of 1 and 2). We will calculate the secant using the given formula
    and output the value to the screen. We will then update our guesses using two new points (previous highest guess point is reused) and output the new value.
    This repeats until we reach the true answer or close enough.

     *      Assign variables n, x0 and x1
     *     Assign tempFuncAnswers for function x0 and x1
     *     Assign x2 by solving the secant method using solved answers from x0 and x1 and the secant formula   
     *     Format output and output the value of x2 from the initial function provided. Not the secant function.
     *     While the value of x2 has not reached the appropriate error value   
     *         Update our initial guesses
     *         Update our tempFuncAnswers
     *         Update x2 by reusing the formula
     *         Update iteration
     *         Output the new value of x2 from function method.
     * 
     *     print out conclusion.
------------------------------------------------------------------------------------------
*/
public class FindingAZero {

    public static void main(String[] args) {
        /* Values below are initial starting points */
        int n = 1;             
        double x0 = 1.0;
        double x1 = 2.0;
        
        // Solve values first, makes it easier to put together;
        double tempFunc = function(x0);
        double tempFunc2 = function(x1);
        
        // According to Secant Method, solve for next X using first two guesses
        double x2 = x1 - tempFunc2 * (x1 - x0)/(tempFunc2-tempFunc);
        
        double output = function(x2);
        //Format the output
        System.out.printf("%-3s%-15s%-15s\n","n","x","f(x)");
        
        // Print our first value
        System.out.printf("%-3d%-15.9f%-15.9f\n",n,x2,Math.abs(output));

        

        //Now, continue solving for f(x) until 0.000000001
        while(Math.abs(output)>1e-9){
            x0 = x1;
            x1 = x2;
            tempFunc = function(x0);
            tempFunc2 = function(x1);
            x2 = x1 - tempFunc2 * (x1 - x0)/(tempFunc2-tempFunc);
            output = function(x2);
            n++;
            System.out.printf("%-3d%-15.9f%-15.9f\n",n,x2,Math.abs(output));


        }
        System.out.println("");
        System.out.println("By using the secant methond, we can see that our guesses are getting cloer and closer"+  
        " to the true answer provided by the calculations.");

    }
    /*
    Uses provided function and solves for a provided x;
    Returns a double value;
    */
    public static double function(double x)
    {
        return ((x*x*x*x*x)+((-0.2)*Math.sin(x))-(10.0));
    }
    
}
