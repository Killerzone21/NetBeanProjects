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
public class BTreeNode {
    
    public int[] keys;
    public int degree;
    public BTreeNode[] Children;
    public int NumofKeys;
    public boolean leaf;
    
    public BTreeNode(int degree, boolean leaf)
    {
        this.degree = degree;
        this.keys = new int[2*degree-1];
        this.Children = new BTreeNode[2*degree];
        this.NumofKeys = 0;
        this.leaf = leaf;
    }
    public void traverse()
    {
        int i;
        for( i = 0; i < NumofKeys; i++){
            if(!leaf)                                                           // If traverse is not a leaf
            {
                Children[i].traverse();                                         // Traverse through the subtree 
            }
            System.out.print(" " + keys[i]);                                    // print the value of the node
                    }
        
        if(!leaf)                                                               // Handles last child
        {
            Children[i].traverse();
        }
    }
    
    public void splitChildren(int i, BTreeNode b)
    // Method for breaking up the tree into a new root and new children. New child will hold (t - 1) keys
    // Used to handle rules of B-Trees
    {
        BTreeNode t = new BTreeNode(b.degree, b.leaf);
        t.NumofKeys = degree - 1;
        
        // Copy the previous (t-1) keys into new B-tree
        for(int p = 0; p < degree-1; p++)
        {
            t.keys[p] = b.keys[p+degree];
        }
        
        // Copy the last t children into new B-tree
        if(b.leaf == false)
        {
            for(int j = 0; j < degree; j++)
                t.Children[j] = b.Children[i+degree];
        }
        
        // Reduce the number of keys in old tree
        b.NumofKeys = degree - 1;
        
        // Node will have a new child, make space for it
        for(int k = NumofKeys; k >= 1; k--)
        {
            Children[k+1] = Children[k];
          
        }
        
        // Link the new child to the new root B-Tree
        Children[i+1] = t;
        
        // A new key of b will move into this new node. Find where it belongs and mvoe all keys greater than that key ahead of it.
        for(int j = NumofKeys-1; j >= i; j--)
        {
            keys[j+1] = keys[j];
        }
        
        // Copy the middle key into this node
        keys[i] = b.keys[degree-1];
        
        // Update the number of keys
        NumofKeys = NumofKeys + 1;
                
        
    }
    
    public void insertNotFull(int k)
    //If the rules of the B-tree are not broken, this method will insert the key into the appropriate child.
    {
        int i = NumofKeys - 1;
        
        if(leaf == true)                                                        // Is the node a leaf?
        {
            while(i >= 0 && keys[i] > k)                                        // Find location of new key to be inserted
            {                                                                   // Move all keys greater than that to one place ahead
                keys[i+1] = keys[i];
                i--;
            }
            
            // insert new key at location
            keys[i+1] = k;
            // increment the amount of keys in root.
            NumofKeys = NumofKeys + 1;
        }
        
        else                                                                    // If its not a leaf
        {
            
            while(i >= 0 && keys[i] > k)                                        // Figure out which child will have the new key
                i--;
            
            if(Children[i+1].NumofKeys == 2*degree-1)                           // Is the child full?
            {
                splitChildren(i+1, Children[i+1]);                              // Split the child
                
                if(keys[i+1] < k)                                               // After split, middle key of C[i] will go up and C[i] will be split into two
                    i++;                                                        // See where the key goes now.
            }
            Children[i+1].insertNotFull(k);
                        
            }
        }
        
        
    }
