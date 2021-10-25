
package initarray3;

// Fig. 7.4: InitArray.java
// Calculating values to be placed into elements of an array.

import java.util.Random;

public class InitArray3
{
   public static void main( String[] args )
   {
       Random rand = new Random();
       
      final int ARRAY_LENGTH = 10; // constant
      int[] array = new int[ ARRAY_LENGTH ]; // create array

      // calculate value for each array element
      for ( int counter = 0; counter < array.length; counter++ )
         array[ counter ] = 1 + rand.nextInt(100);

      System.out.printf( "%s%8s\n", "Index", "Value" ); // column headings
   
      // output each array element's value 
      for ( int counter = 0; counter < array.length; counter++ )
         System.out.printf( "%5d%8d\n", counter, array[ counter ] );
   } // end main
}