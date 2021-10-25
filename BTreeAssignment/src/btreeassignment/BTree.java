/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btreeassignment;

/**
 *
 * @author Alexander
 */
public class BTree {
    
    private BTreeNode root;
    private int degree;
    
    public BTree(int degree)
    {
        this.root = null;
        this.degree = degree;
                
    }
    
    public void traverse()
    {
        if(root != null)
            root.traverse();
    }
    
    public void insert(int key)
    {
        if(root == null)
        {
            root = new BTreeNode(degree, true);                          // Create a new root for the BTree
            root.keys[0] = key;                                          // Insert key for BTree
            root.NumofKeys = 1;                                          // Adjust the key count;
        }
        else
        {
            if(root.NumofKeys == 2*degree -1)                           //  Do the number of keys exceed the rules of the BTree? Increase the height and make a new root
            {
                BTreeNode node = new BTreeNode(degree, false);         //  Make a new BTree node to act as the root  
                
                node.Children[0] = root;                              //  Make the old root a child now of the new root
                
                node.splitChildren(0, root);                         // Split the old root and insert new key into new root
                
                int i = 0;                                          // New root now has children now. Verify which child shall receive the new key
                if(node.keys[0] < key)
                {
                    i++;
                }
                
                root = node;                                        // Change root to the new root
            }
            else
                root.insertNotFull(key);                           // If root isn't full, insert key into non-full root.
        }
    }
    
    public void printBTree()
    {
        printBTree(root, 0, 1);
    }
    
    private void printBTree(BTreeNode node, int level, int n)
    {
        if(node == null)
            return;
        System.out.println("\n------");
        System.out.println("Level " + level);
        System.out.println("These are the elements at this level " + level + " with node: " + n);
        System.out.println("------");
        for(int i = 0; i < node.NumofKeys; i++)
        {
            System.out.print(node.keys[i] + " ");
            
        }
        level++;
        n = 0;
        for(BTreeNode child : node.Children)
        {
            printBTree(child, level, n++);
        }                
    }
}
