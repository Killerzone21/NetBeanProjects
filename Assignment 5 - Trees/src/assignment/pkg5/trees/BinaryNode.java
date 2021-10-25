
//Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// this package.

package assignment.pkg5.trees;

public class BinaryNode<AnyType>
{
        //Constructor
    BinaryNode( AnyType theElement)
    {
        element = theElement;
        left = right = null;
    }
    
        //Data; accessible by other package routines
    AnyType             element;        //The data in the node 
    BinaryNode<AnyType> left;           // Left Child
    BinaryNode<AnyType> right;          // Right Child    
}
