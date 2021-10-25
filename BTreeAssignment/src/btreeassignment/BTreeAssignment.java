/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btreeassignment;

import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class BTreeAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BTree tree = new BTree(4);
        Scanner in = new Scanner(System.in);
        int count, num;
        System.out.print("Enter the number of elements you want: ");
        count = in.nextInt();
        System.out.println("Enter the next integer: " );
        for(int i = 1; i <= count; i++)
        {
            num = in.nextInt();
            tree.insert(num);
        }
        tree.traverse();
        tree.printBTree();
    }
    
}
