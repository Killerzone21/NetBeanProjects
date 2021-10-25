
package arrayquickcode;

/////////////////////// 2D-Array /////////////////////////
public class ArrayQuickCode
{
   // create and output two-dimensional arrays
   public static void main( String[] args )
   {
      int[][] array1 = { { 1, 2, 3 }, { 6, 5 }, { 8 } }; 

      System.out.println( "\nValues in array1 by row are: \n" );
      int arrayTotal = outputArray( array1 );                      
      System.out.printf("Array-total = %d \n", arrayTotal);
       
   } // end main

   // Write your method here   
public static int outputArray( int[][] array )
   {
	 int arrayTotal = 0; 
     
      // loop through array's rows
      for ( int row = 0; row < array.length; row++ ) 
      {
	   int rowTotal = 0;  
       
         // loop through columns of current row
         for ( int column = 0; column < array[ row ].length; column++ )
            {             
            System.out.printf( "%d  ", array[ row ][ column ] );
            rowTotal += array[row][column];
            }

         System.out.printf("  = %d", rowTotal);
         arrayTotal += rowTotal; 
         System.out.println(); // start new line of output
      } // end outer for 
     return arrayTotal;
   } // end method outputArray


 } // end class ArrayQuickCode