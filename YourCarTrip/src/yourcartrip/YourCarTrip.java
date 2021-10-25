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

import java.util.Scanner;

public class YourCarTrip {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MyCar NewCar = new MyCar(0); // Makes a new car with initial fuel levels of 0

        System.out.print("Are you going on a trip? Enter 1 for yes and 0 for no.");
        int trip = input.nextInt();

        double LegDistance, miles = 0, time = 0;
        int counter = 0, leg = 1;

        if (trip == 1) {

            System.out.print("How many gallons of gas do you have in your car? ");
            NewCar.setFuelLevel(input.nextDouble() * 20); // Car is assumed to get 20 miles per gallon
            System.out.print("How many legs are there to this trip? ");
            counter = input.nextInt();

        }
        for(int i = counter; i > 0; i--)
        {
            
            NewCar.CarDetails();        // Displays the current details of the car 

            System.out.printf("\nEnter Leg %d's distance:", leg);
            LegDistance = input.nextDouble();

            System.out.print("How fast do you want to go for this leg of the trip?");
            NewCar.setSpeed(input.nextInt());

            miles = LegDistance + miles;
            time = Math.round((LegDistance / NewCar.getSpeed()) * 100.0) / 100.0 * 60 + time;     // Rounds the time spent on the leg to 2 decimal places and adds to current time for each consecutive leg

            System.out.printf("You still have %5.2f miles before you run out of gas\n", NewCar.FuelConsumption(LegDistance)); //Determines how much milage (fuel) was consumed in the prior leg

            NewCar.setFuelLevel(NewCar.FuelConsumption(LegDistance));   // Sets the new fuel level for the car based on how much milage was covered
            leg++;
        }

        System.out.printf("You traveled about %5.2f miles in about %5.2f minutes.\n", miles, time);     // Displays the milage traveled and how long it took in minutes
        if (miles > NewCar.getFuelLevel()) {
            System.out.println("You will need more gas for the return trip!");
        } else if (miles == 0) {                    
            System.out.println("You didn't go anywhere!");
        } else {
            System.out.println("You should be good on gas!");
        }
    }

}
