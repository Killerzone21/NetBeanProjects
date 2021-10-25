/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: October 2, 2019
 *
 * Assignment: Program #6: YourCarTrip/MyCar
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: YourCarTrip.java, MyCar.java, Java Problems.docx
 *
 * Purpose: Allows user to determine the distance from point A to point B and if they need gas for a return trip
 *
 * Input: Distance of each leg trip (Double), Speed of Car (Int), How much fuel they have in car (Double), Add another leg of the trip (int)
 *
 * Preconditions/Assumptions: Only 0 or positive numbers are entered, they have fuel for the trip, 
 *
 * Output: Distance of the trip, how long it took, do they have enough gas for a return trip
 *
 * Postconditions: (optional)
 *
 * Algorithm: Create a new Car object for the user's car
 *            Ask the user if they are going on a trip? Print something simple if not
 *            Ask the user how much gas they have in their car and apply it to their car object
 *            Display the details of the car before each leg including how much fuel they have left and how fast they are going
 *            Ask the user the distance of the leg of the trip
 *            Ask the user the speed they are traveling for this leg of the trip
 *            Ask the user if they wish to add another leg to the trip
 *            Repeat those steps until they wish to stop
 *            Tell the user how the distance of the trip, how long it took and whether they need more gas for a return trip
**********************************************************************
* **/
package yourcartrip; 


public class MyCar {
    
    private double Fuel; 
    private int mph;
    
   public MyCar( int initialFuel )
   {
      Fuel = initialFuel; // initializes initial fuel
   } 
   
   public void setFuelLevel(double F )
   {
      Fuel = F ; // Allows user to set how much fuel they have in gallons and converts it into total miles
   }
   
   public void setSpeed(int S)
   {
      mph = S; // Allows User to set the speed of the car
   } 
   
   public double getFuelLevel()
   {
       return Fuel; // Car gets up to 20 miles per gallon of fuel
   }
  
   public int getSpeed()
   {
       return mph;
   }
   
   public double FuelConsumption(double M) // M for miles traveled
   {
       double FuelLeft = getFuelLevel();
       
       return FuelLeft - M;
   }
   
   public void CarDetails()
   {
       System.out.printf("Your car has a fuel level of %5.2f miles!\n", getFuelLevel());
       System.out.printf("Your current speed is %d mph\n", mph);
   }
   
}
