/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: October 1, 2019
 *
 * Assignment: Program #5: Account/AccountTest
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: Account.java, AccountTest.java, Java Problems.docx
 *
 * Purpose: Allow users to deposit and withdraw money from their bank account
 *
 * Input: Deposit Money (Double), Withdraw Money (Double)
 *
 * Preconditions/Assumptions: Only positive numbers are input, their accounts have money
 *
 * Output: Final Balance after money is deposited and withdrawn
 *
 * Postconditions: (optional)
 *
 * Algorithm: Assign Accounts with starting values
 *            Notify the user of the balance in their accounts
 *            Ask user how much money they wish to deposit
 *            Ask user how much money they wish to withdraw
 *            Display the balance after each action taken by user.
**********************************************************************
 */

package accounttest;

public class Account
{   
   private double balance; // instance variable stores balance

   // constructor  
   public Account( double initialBalance )
   {
      // validate that initialBalance is greater than 0.0; 
      // if it is not, balance is initialized to default value 0.0
      if ( initialBalance > 0.0 ) 
         balance = initialBalance; 
   } // end Account constructor

   // credit (add) an amount to the account
   public void credit( double amount )
   {      
      balance = balance + amount; // add amount to balance 
   } // end method credit
   
   // Withdraw (subtract) an amount from the account
   public void debit( double amount )
   {  
       if(getBalance() - amount > -1)
       {
         balance = balance - amount; // Subtract amount from balance
       }
       else
       {
           System.out.println("You don't have enough money to take out!\n");
       }
   } // end method debit

   // return the account balance
   public double getBalance()
   {
      return balance; // gives value of balance to calling method
   } // end method getBalance
} // end class Account