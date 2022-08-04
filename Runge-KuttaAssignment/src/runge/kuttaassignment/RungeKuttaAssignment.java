package runge.kuttaassignment;

/**
     a. PROGRAMMER: Alexander Quirindongo

     b. COURSE: CSCI 3321.01

     c. DATE: April 14, 2022

     d. ASSIGNMENT: Solving Ordinary Differential Equations using a Fourth-Order Runge-Kutta of Your Own Creation

     e. ENVIRONMENT: Windows 10, Apache Netbeans IDE 12.6, Java

     f. FILES INCLUDED: RungeKuttaAssignment.java

     g. PURPOSE:  To illustrate the use of a fourth-order explicit Runge-kutta method.
     
     h. INPUT:  Function is provided: f(x) = x^2 - sin(2 x^2) - 1
                Initial Condition is given: x(0) = 1.0
                and 7 steps given: 20, 40, 80, 160, 320, 640, and 1280

     i. PRECONDITIONS: Provided answer is correct: 0.753913186469598763502963347

     j. OUTPUT:  7 trials are ran for h, value of h is printed, table for t and x, and the error at t = 2.

     k. POSTCONDITIONS: After running 7 trials, correct answer should be given or really close to it. 

     l. ALGORITHM:  
     *  
     *     Assign variables a0, a1, a2, a3, b10, b20, b21, b30, b31, b32, c0, c1, c2, c3, steps, TrueValue and error.
     *     Create a separate function for generating the formula given.
     *     In a for loop up to 7 h values, 
     *         generate an h value 
     *         the starting x0 
     *         starting t0 
     *         new table for each value.
     *         In a new for loop up to the steps given
     *         Generate our 4-order runge-kutta values
     *         Output the value and the appropriate h value to it.
     *         Multiply the steps by 2.
     *     Figure out the error  
     *     Output conclusion
     * 
 */

public class RungeKuttaAssignment {

    
    public static void main(String[] args) 
    {
        double a0 = 0.0;//alpha 
        double a1 = 1.0 / 5.0;
        double a2 = 3.0 / 5.0;
        double a3 = 1.0;//alpha 4
        double b10 = 3.0 / 8.0; // beta 1,0
        double b20 = 5.0 / 24.0; // beta 2,0
        double b21 = 5.0 / 6.0; //beta 2,1
        double b30 = 23.0 / 39.0; //beta 3,0
        double b31 = -20.0 / 39.0; //beta 3,1
        double b32 = 12.0 / 13.0; //beta 3,2
        double c0 = 13.0 / 90.0; //c0
        double c1 = 16.0 / 45.0; //c1
        double c2 = 16.0 / 45.0; //c2
        double c3 = 13.0 / 90.0; //c3     
        double steps = 20;
        final double TrueValue = 0.753913186469598763502963347;
        double error = 0;
               
        for (int j = 0; j < 7; j++)
        {

            double h = 2.0 / steps; //calcuate stepsize for next run
            double x0 = 1.0; //set x0 to initial state
            double t0 = 0.0; // set time to 0.0      
            System.out.printf(h + ":\n\n");
            System.out.printf("t:\t|\tx:\n\n");
            
            for(int i = 1; i <= steps; i++)
            {
                double x1 = x0 + h * (b10 * Function(t0, x0)); //calculate x1
                double x2 = x0 + h * (b20 * Function(t0, x0) + b21 * Function(t0 + a2 * h, x1)); //calculate x2
                double x3 = x0 + h * (b30 * Function(t0, x0) + b31 * Function(t0 + a2 * h, x1) + b32 * Function(t0 + a3 * h, x2)); //calculate x3
                double x4 = x0 + h * (c0 * Function(t0, x0) + c1 * Function(t0 + a1 * h, x1) + c2 * Function(t0 + a2 * h, x2) + c3 * Function(t0 + a3 * h, x3)); //calculate x4
                x0 = x4; //set x0 to x4
                t0 = t0 + h; //increment time         
                System.out.printf("%.6f\t|\t%.6f\n\n", t0, x0);
                error = Math.abs(TrueValue - x0);
             }
            steps = steps * 2;
        }
        System.out.printf("\nThe error for t = 2 is: " + error);
        System.out.printf("\n\nIn conclusion, as we get closer and closer to t = 2 and h is decreasing, \nthe accuracy of our guesses become more and more accurate.\n ");
    }
    
    public static double Function(double t, double x)
    {
        return ((3*x*x) * Math.cos(5*t));
    }   
    
}

