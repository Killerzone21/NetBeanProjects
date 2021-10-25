
package assignment.pkg5.trees;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove minimum item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */


public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    
    public BinarySearchTree()
    {
        root = null;
    }
    public void insert( AnyType x)
    {
        root = insert( x, root);
    }
    public void remove( AnyType x)
    {
        root = remove( x, root);
    }
    public void removeMin()
    {
        root = removeMin( root );
    }
    public AnyType findMin( )
    {
        return elementAt( findMin( root ) );
    }
    public AnyType findMax( )
    {
        return elementAt( findMax( root) );
    }
    public AnyType find( AnyType x)
    {
        return elementAt( find( x, root) );
    }
    public void makeEmpty()
    {
        root = null;
    }
    public boolean isEmpty( )
    {
        return root == null;
    }
    
    public void print()
    {
        if(isEmpty())
            System.out.println("The Tree is empty!");
        else
            printTree(root, 0);
    }
       
    private void printTree( BinaryNode<AnyType> t, int depth)
    {
        for(int i = 0; i < depth; i++ )
        {
            System.out.print("*");
        }
        
        System.out.println( t.element);
        depth++;
        
        if( t.left != null)
        {
            
            printTree(t.left, depth);
        }
        if( t.right != null)
        {
            
            printTree(t.right, depth);
        }
            
        
    }
      
    private AnyType elementAt( BinaryNode<AnyType> t)
    {
        return t == null ? null : t.element;
    }
    private BinaryNode<AnyType> find( AnyType x, BinaryNode<AnyType> t)
    {
        
        if( x == t.element)
            return t;
        else if ( x.compareTo(t.element) < 0)
            return find( x , t.left);
        else 
            return find( x, t.right);
       
    }
    
    protected BinaryNode<AnyType> findMin( BinaryNode<AnyType> t)
    {
        
        if(t.left == null)
            return t;
        else
            return findMin(t.left);
  
    }
    
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t)
    {
        
        if(t.right == null)
            return t;
        else
            return findMax(t.right);

    }
    
    protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t)
    {
       if( t == null)
           t = new BinaryNode<AnyType>( x );
       else if (x.compareTo( t.element) < 0)
           t.left = insert(x, t.left );
       else if(x.compareTo(t.element) > 0)
           t.right = insert( x, t.right);
       else
           throw new DuplicateItemException( x.toString());
       return t;
    }
    protected BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t)
    {
        if( t == null )
            throw new ItemNotFoundException();
        else if(t.left != null)
        {
            t.left = removeMin( t.left );
            return t;
        }
        else
            return t.right;
    }
    
    protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t)
    {
        if( t == null)
            throw new ItemNotFoundException( x.toString() );
        if( x.compareTo(t.element) < 0)
            t.left = remove( x, t.left );
        else if( x.compareTo(t.element) > 0)
            t.right = remove( x, t.right);
        else if( t.left != null && t.right != null)
        {
            t.element = findMin( t.right).element;
            t.right = removeMin(t.right);
        }
        else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }
    
    
    
    protected BinaryNode<AnyType> root;
}
