package gradebook.test;

////////// GradeBook Test ////////////////////////////////
//
// Fig. 4.7: GradeBookTest.java
// Create GradeBook object and invoke its determineClassAverage method.

public class GradeBookTest
{
   public static void main( String[] args )
   {
      // create GradeBook object myGradeBook and 
      // pass course name to constructor
      GradeBook myGradeBook = new GradeBook( 
         "CSCS_1471 Computer Science II" );

      myGradeBook.displayMessage(); // display welcome message
      myGradeBook.determineClassAverage(); // find average of 10 grades
   } // end main
} // end class GradeBookTest

///////// end GradeBookTest /////////////////////
 
