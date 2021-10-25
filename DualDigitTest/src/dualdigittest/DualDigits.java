package dualdigittest;

/************************************************************************ 
* Programmer:  Alexander Quirindongo
* 
* Course:  CSCI 2315
* 
* Date:  February 17 2020
* 
* Assignment:  Program #1: Dual Digits 
* 
* Environment:  Java with Netbeans IDE
***********************************************************************/

import java.util.Scanner;

public class DualDigits 

{
    private int[] contents;
    private String[] DualDigitsDisplay;
    
    public void inputNumbers()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter how many numbers you are inputting: ");
        
        int totalnums = input.nextInt();
        contents = new int[totalnums];
        DualDigitsDisplay = new String[totalnums];
        
        for(int i = 0; i < totalnums; i++)
        {
            System.out.println("Please enter your number: ");
            contents[i] = input.nextInt();
        }
        
    }
    
    public void computeDualDigits()
    {
        for(int i = 0; i < contents.length; i++)
        {
            int currentNum = contents[i];
            int j = 2;
            boolean found = false;
            
            while(!found)
            {
                int DualDigit = currentNum * j;
                if( (DualDigit > 9 && DualDigit < 100) && DualDigit % 11 != 0)
                {
                    found = true;
                    DualDigitsDisplay[i] = Integer.toString(DualDigit);
                }
                else 
                {
                    found = CheckDualDigit(DualDigit);
                    if(found)
                        DualDigitsDisplay[i] = Integer.toString(DualDigit);
                }
                j++;
            }
        }
    }
    
    private boolean CheckDualDigit(int number)
    {
        String check = Integer.toString(number);
        int unique = 1;
        char num = check.charAt(0);
        
        for(int i = 1; i < check.length(); i++)
        {
            
            char nextnum = check.charAt(i);
         
            if(num != nextnum)
            {
                unique++;
                num = nextnum;                
            }
            if(unique > 2)
            {
                break;
            }            
        }
        return unique == 2;
    }
    
    public void describeDualDigits()
    {
        char num;
        char uniquenum1;
        char uniquenum2;
        
        
        for(int i = 0; i < contents.length; i++)
        {
             int count1 = 1;
             int count2 = 1;
             String number = DualDigitsDisplay[i];
             num = number.charAt(0);
             uniquenum1 = number.charAt(0);
             uniquenum2 = number.charAt(0);
             
             for(int j = 1; j < number.length(); j++)
             {
                 char nextnum = number.charAt(j);
                 
                 if( (num == nextnum) && uniquenum2 == uniquenum1)
                     count1++;
                 else if((num == nextnum) && uniquenum2 != uniquenum1)
                 {
                     count2++;
                 }
                 else
                 {
                     num = nextnum;
                     uniquenum2 = num;
                 }
             }
            System.out.printf("%d: %d %S %d %S\n", contents[i], count1, uniquenum1, count2, uniquenum2);
        }
     
    }
    
}
