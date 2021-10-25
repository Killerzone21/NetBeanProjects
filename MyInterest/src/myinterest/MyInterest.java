
package myinterest;

public class MyInterest {

    public static void main(String[] args) {
        
        double amountMonth = 500.0;
        double principal = 2000.0;
        double rate = 0.06;
        
        System.out.printf("%5s %20s\n", "Year", "Principal on deposit");
        
        for(int i = 1; i <= 40; i++)
        {
            principal = ((principal + (12 * amountMonth))* (1+rate));
            
            System.out.printf("%3d %20.2f\n", i, principal);
        }
        
    }
    
}
