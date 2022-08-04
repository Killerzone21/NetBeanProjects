package roundingerrorassignment;

/**
     a. PROGRAMMER: Alexander Quirindongo

     b. COURSE: CSCI 3321.01

     c. DATE: February 8, 2022

     d. ASSIGNMENT: Rounding Errors versus Truncation Error

     e. ENVIRONMENT: Windows 10, Apache Netbeans IDE 12.6, Java

     f. FILES INCLUDED: RoundingErrorAssignment.java

     g. PURPOSE:  To demonstrate the effects of rounding and truncation errors. An approximation of the derivative of a function is used.

     h. INPUT:  Function is provided: f(x) = x^2 - sin(2 x^2) - 1;

     i. PRECONDITIONS: Provided answer is correct: 4 - 8 cos(8) or 5.1640002604679082070). 

     j. OUTPUT:  40 Trials are ran for h, approximation and error.

     k. POSTCONDITIONS: After running 40 trials, correct answer should be given or really close to it. 

     l. ALGORITHM:  
     *  
     *     Assign variables x, derivative, true answer, error and h.
     *     Assign derivative to provided formula
     *     Setup table for handling trials    
     *     for i up to 40   
     *         Assign a new derivative using provided formula
     *         Assign new error
     *         print out new h, new approximation and error
     *         Divide h by 2 for new trial
     * 
     *     print out conclusion.
     * 
 */
public class RoundingErrorAssignment 
{

   
    public static void main(String[] args) 
    {
        
        double h = 1;
        double deriv;
        
        double ActualAnswer = (4 - (8 * Math.cos(8)));
      
        double error;
        
        System.out.println("i         h\t\tApprox\t\terror\n");
        
        for(int i = 0; i < 10; i++)  // Contains the first 9 numbers for formatting reasons
        {
            deriv = Derivative(h);
            error = (ActualAnswer - (deriv));
            System.out.printf("%d  %.6e\t\t%f\t%.6e\n",i, h, deriv, error);
            h = h/2;
        }
        for(int i = 10; i < 40; i++)  // Contains the last 31 numbers for formattnig reasons
        {
            deriv = Derivative(h);
            error = (ActualAnswer - (deriv));
            System.out.printf("%d  %.6e\t%f\t%.6e\n",i, h, deriv, error);
            h = h/2;
        }
        
        
        System.out.println("\nConclusions: As h gets smaller and smaller, the approximation starts to get closer and closer to the true value.\n"
                          + "However, as we get closer and closer to the true value, the error starts to get smaller and smaller.\n"
                          + "Even though the error is negative, we can assume absolute values and approximate the error.");
        
        
    }
    
    public static double Derivative(double h)
    {
        /*
        
        This function will handle initial derivative using the provided formula of:
        f'(x) = (f(x + h) - f(x)) / h
                In order to achieve this, f(x) is split into two separate functions: 
        One will contain the h addition and one will not contain for purpose
        of ease. 
              
        */
        
        double x = 2.0 + h;
        double y = 2.0;
               
        double xFunc = ((x * x) - Math.sin(2 * (x * x))) - 1; // This is for f(x+h)
        double yFunc = ((y * y) - Math.sin(2 * (y * y))) - 1; // This is for f(x)
        
        double derivative = (xFunc - yFunc) / h;  // We get a value for f(x+h) and a value for f(x), now subtact the two and divide by h.
        
        return derivative;  // After calculating the value, send it back.
                              
    }
}
