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
import java.util.Scanner;

public class AccountTest {
    // main method begins execution of Java application

    public static void main(String[] args) {
        Account account1 = new Account(50.00); // create Account object
        Account account2 = new Account(-7.53); // create Account object

        // display initial balance of each object
        System.out.printf("account1 balance: $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n\n",
                account2.getBalance());

        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);
        double depositAmount; // deposit amount read from user

        System.out.println("Enter deposit amount for account1: "); // prompt
        depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("\nadding %.2f to account1 balance\n\n",
                depositAmount);
        account1.credit(depositAmount); // add to account1 balance

        // display balances
        System.out.printf("account1 balance: $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n\n",
                account2.getBalance());

        System.out.print("Enter withdraw amount for account1: "); // prompt
        depositAmount = input.nextDouble(); // obtain user input
        if (account1.getBalance() > 0) {
            System.out.printf("\ntaking %.2f from account1 balance\n\n",
                    depositAmount);
            account1.debit(depositAmount); // subtract from account2 balance
        } else {
            System.out.println("You don't have any money to be able to withdraw!");
        }

        // display balances
        System.out.printf("account1 balance: $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n\n",
                account2.getBalance());

        System.out.print("Enter deposit amount for account2: "); // prompt
        depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("\nadding %.2f to account2 balance\n\n",
                depositAmount);
        account2.credit(depositAmount); // add to account2 balance

        // display balances
        System.out.printf("account1 balance: $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n\n",
                account2.getBalance());

        if (account2.getBalance() > 0) {
            System.out.print("Enter withdraw amount for account2: "); // prompt
            depositAmount = input.nextDouble(); // obtain user input
            System.out.printf("\ntaking %.2f from account2 balance\n\n",
                    depositAmount);
            account2.debit(depositAmount); // subtract from account2 balance
        } else {
            System.out.printf("You don't have any money to be able to withdraw!\n\n");
        }
        // display balances
        System.out.printf("account1 balance: $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n",
                account2.getBalance());
    } // end main
} // end class AccountTest


