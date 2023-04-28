/**
 * 
 */
package testerPackage;

import java.util.Scanner;
import classPackage.Car;

/**
 * @author Larry Shannon
 *
 */
public class CarTester
{
	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * @param args
	 * Algorithm
	 * START
	 * DECLARE VARIABLES
	 * REPEAT
	 *   DISPLAY greeting
	 *   CALL parking object method to display information on available cars
	 *   PROMPT user to see if they would like to add another car
	 *   REPEAT
	 *     DISPLAY "Please enter 'y' or 'n'"
	 *     GET user input and store into yesOrNo variable
	 *   UNTIL yesOrNo equals 'y' OR yesOrNo equals 'n'
	 *   IF yesOrNo equals 'y' THEN
	 *     PROMPT user to see if they want to enter car data or use random data
	 *     IF the user chooses to enter the data THEN
	 *       PROMPT user for year of vehicle
	 *       REPEAT
	 *         DISPLAY "Please enter a year between 1920 and 2021"
	 *         GET user input and store into year variable
	 *       UNTIL year is a valid number between 1920 and 2021
	 *       PROMPT user for Make of car
	 *       GET user input and store into make variable
	 *       PROMPT user for Model of car
	 *       GET user input and store into model variable
	 *       PROMPT user for color of car
	 *       GET user input and store into color variable
	 *       PROMPT user for fuel tank size
	 *       REPEAT 
	 *         DISPLAY "Enter a value between 8.0 and 34.99"
	 *         GET user input and store into fuelTankSize
	 *       UNTIL fuelTankSize is a valid number between 8.0 and 34.99
	 *       PROMPT user for vehicl's optimal speed
	 *       REPEAT 
	 *         DISPLAY "Enter a value between 45.0 and 64.99"
	 *         GET user input and store into optimalSpeed
	 *       UNTIL optimalSpeed is a valid number between 45.0 and 64.99
	 *       PROMPT user for fuel economy
	 *       REPEAT 
	 *         DISPLAY "Enter a value between 15.0 and 54.99"
	 *         GET user input and store into fuelEconomy
	 *       UNTIL fuelEconomy is a valid number between 15.0 and 54.99
	 *       CREATE NEW Car(year,make,model,color,tankSize,optimalSpeed,fuelEconomy) and store into currentCar variable
	 *     ELSE
	 *       CREATE NEW Car() and store into current car
	 *     END IF
	 *     IF currentCar is not NULL THEN  
	 *       Call parkingSpace object's parkCar(currentCar) to store the new care into the parkingSpace's object
	 *       IF there is no room for the car THEN
	 *         DISPLAY "Parking is full"
	 *       END IF
	 *     END IF
	 *     CALL parkingSpace's displayCars() method to display the available cars
	 *   END IF
	 *   PROMPT user to see if they would like to add fuel to one of the cars.
	 *   REPEAT
	 *     DISPLAY "Please enter 'y' or 'n'"
	 *     GET user input and store into yesOrNo variable
	 *   UNTIL yesOrNo equals 'y' OR yesOrNo equals 'n'
	 *   IF yesOrNo equals 'y' THEN
	 *     PROMPT user for the car's parking space number
	 *     REPEAT 
	 *       DISPLAY "Enter a value between 1 and 2"
	 *       GET user input and store into spaceNumber variable
	 *     UNTIL spaceNumber is a valid number between 1 and 2 AND there is a car there
	 *     PROMPT user for the amount of fuel to add
	 *     REPEAT 
	 *       DISPLAY "Enter a value greater than 0"
	 *       GET user input and store into fuel
	 *     UNTIL fuel is a valid number greater than 0
	 *     CALL the parkingSpace's method addFuel(carNumber,fuel) to refuel the car and STORE the amount of fuel left over or needed into overFlow
	 *     IF overFlow is less than zero THEN
	 *       DISPLAY "the car will hold an additional " + (- overFlow) + " gallons of fuel"
	 *     ELSE
	 *       IF overFlow is greater than zero THEN
	 *         DISPLAY "The tank is full with " + overFlow + " gallons left in the can"
	 *       ELSE
	 *         DISPLAY "The tank is full"
	 *       END IF
	 *     END IF
	 *   END IF
	 *   PROMPT "Which car would you like to drive."
	 *   REPEAT 
	 *     DISPLAY "Enter a value between 1 and 2"
	 *     GET user input and store into spaceNumber variable
	 *   UNTIL spaceNumber is a valid number between 1 and 2 AND there is a car there
	 *   CALL parkingSpace's getCar(spaceNumber) TO retrieve the car and remove it from the parkingSpace. 
	 *   STORE the retrieved car into currentCar variable
	 *   PROMPT user for the distance to drive
	 *   REPEAT 
	 *     DISPLAY "Enter a value greater than 0"
	 *     GET user input and store into distance variable
	 *   UNTIL distance is a valid number greater than 0
	 *   PROMPT user for the speed to drive
	 *   REPEAT 
	 *     DISPLAY "Enter a value greater than 0"
	 *     GET user input and store into speed variable
	 *   UNTIL speed is a valid number greater than 0
	 *   CALL currentCar's setUpTrip(speed,distance) method to set up the drive
	 *   CALL currentCar's drive() method that drives the car and returns true if the car completed the drive and false if the car ran out of fuel.
	 *   STORE returned value into madeItBack variable
	 *   IF madItBack is equal to true THEN
	 *     STORE currentCar back into parkingSpace by CALLING paringSpace's parkCar(currentCar) method
	 *     DISPLAY currentCar's state values
	 *   ELSE
	 *     DISPLAY "The car ran out of fuel"
	 *     DISPLAY currentCar's state values
	 *   END IF
	 *   PROMPT user to see if they would like to repeat the program.
	 *   REPEAT
	 *     DISPLAY "Please enter 'y' or 'n'"
	 *     GET user input and store into yesOrNo variable
	 *   UNTIL yesOrNo equals 'n' OR yesOrNo equals 'y'
	 * UNTIL yesOrNo equals 'n'
	 * DISPLAY "Good-bye!"
	 * STOP
	 *   
	 */
	public static void main(String[] args)
	{
		int carNumber = 0;
		double fuelOverage = 0.0;
		double fuelAmount = 0.0;
		double distance = 0.0;
		double speed = 0.0;
		boolean didNotRunOutOfFuel = true;
		Car currentCar = null;
		Car[] parkingSpaces = new Car[2];
		String carInfo = null;
		String yesOrNo = "y";
		parkingSpaces[0] = new Car();
		parkingSpaces[1] = parkingSpaces[0];
		do
		{
			System.out.println("Here are the current cars.");
			System.out.printf("Space 1: %s%n", parkingSpaces[0]);
			System.out.printf("Space 2: %s%n", parkingSpaces[1]);
			while(parkingSpaces[0] == null || parkingSpaces[1] == null)
			{
				System.out.println("Please add a car.");
				currentCar = buildCar();
				if(parkingSpaces[0] == null)
					parkingSpaces[0] = currentCar;
				else
					parkingSpaces[1] = currentCar;
			}
			System.out.println("Here are the current cars.");
			System.out.printf("Space 1: %s%n", parkingSpaces[0]);
			System.out.printf("Space 2: %s%n", parkingSpaces[1]);
			if(parkingSpaces[0].equals(parkingSpaces[1]))
				if(parkingSpaces[0].equals((Object)parkingSpaces[1]))
				{
					System.out.println("Car in space 1 is the same Car object as the Car in space 2. ");
					parkingSpaces[1] = null;
					System.out.println("The duyplicate reference is removed.");
					System.out.println("Here are the current cars.");
					System.out.printf("Space 1: %s%n", parkingSpaces[0]);
					System.out.printf("Space 2: %s%n", parkingSpaces[1]);
				}
				else
					System.out.println("Car in space 1 is the same as the Car in space 2.\n However, they are not the same Car object. ");
			else
				System.out.println("THe cars are not the same.");
			System.out.println("Would you like to add fuel to one of the cars?");
			do
			{
				System.out.println("Please enter \"y\" for yes or \"n\" for no.");
				yesOrNo = keyboard.next().toLowerCase();
			} while (!yesOrNo.equals("y") && !yesOrNo.equals("n"));
			if (yesOrNo.equals("y"))
			{
				System.out.println("Which car would you like to add fuel to?");
					do
					{
						do
						{
							if(keyboard.hasNextLine())
								keyboard.nextLine();
							System.out.println("Please enter the car's parking space number for your selection");
						}while(!keyboard.hasNextInt());
						carNumber = keyboard.nextInt();
					} while (carNumber < 1 || carNumber > 2);
					if(parkingSpaces[carNumber - 1] == null)
					{
						System.out.println("THere is no car in that space!");
						System.out.printf("Please create a Car for that space.%n");
						parkingSpaces[carNumber - 1] = buildCar();
					}
					currentCar = parkingSpaces[carNumber - 1];
					carInfo = currentCar.toString();
					System.out.printf("Space %d: %s%n",carNumber, carInfo);

				System.out.println("How much fuel would you like to add?");
				do
				{
					do
					{
						if(keyboard.hasNextLine())
							keyboard.nextLine();
						System.out.println("Please enter an amount greater than zero.");
					}while(!keyboard.hasNextDouble());
					fuelAmount = keyboard.nextDouble();
				} while (fuelAmount <= 0.0);
				fuelOverage = currentCar.addFuelToTank( fuelAmount);
				if(fuelOverage > 0.0)
					System.out.printf("The tank is full and you have %.2f gallons left in the can.\n",fuelOverage);
				else
					if(fuelOverage < 0.0)
					System.out.printf("The tank is not full and can take %.2f more gallons of fuel.\n",-fuelOverage);
					else
						System.out.println("The tank is now full.");
			}
			System.out.println("Which car would you like to drive?");
				do
				{
					do
					{
						if(keyboard.hasNextLine())
							keyboard.nextLine();
						System.out.println("Please enter the car's parking space number for your selection");
					}while(!keyboard.hasNextInt());
					carNumber = keyboard.nextInt();
				} while (carNumber < 1 || carNumber > 2);
				if(parkingSpaces[carNumber - 1] == null)
				{
					System.out.println("THere is no car in that space!");
					System.out.printf("Please create a Car for that space.");
					parkingSpaces[carNumber - 1] = buildCar();
				}
				currentCar = parkingSpaces[carNumber - 1];
				parkingSpaces[carNumber - 1] = null;
				carInfo = currentCar.toString();
			System.out.println("How far would you like to drive?");
			do
			{
				do
				{
					if(keyboard.hasNextLine())
						keyboard.nextLine();
					System.out.println("Please enter an amount greater than zero.");
				}while(!keyboard.hasNextDouble());
				distance = keyboard.nextDouble();
			} while (distance < 0.0);
			System.out.println("How fast would you like to drive?");
			do
			{
				do
				{
					if(keyboard.hasNextLine())
						keyboard.nextLine();
					System.out.println("Please enter an amount greater than zero.");
				}while(!keyboard.hasNextDouble());
				speed = keyboard.nextDouble();
			} while (speed < 0.0);
			currentCar.setUpTrip(speed, distance);
			didNotRunOutOfFuel = currentCar.driveCar();
			if(didNotRunOutOfFuel)
			{
				parkingSpaces[carNumber - 1] = currentCar;
				carInfo = String.format("You drove the %s, %s, %s %.2f miles and returned it to its parking space.", currentCar.getYear(), currentCar.getMake(), currentCar.getModel(), distance);
				System.out.println(carInfo);
			}
			else
			{
				System.out.printf("The %s ran out of fuel.\nIt is parked somewhere on the side of the road.\n",currentCar.getModel());
			}
			
			currentCar = null;
			System.out.println("Would you like to repeat this program?");
			do
			{
				System.out.println("Please enter \"y\" for yes or \"n\" for no.");
				yesOrNo = keyboard.next().toLowerCase();
			} while (!yesOrNo.equals("y") && !yesOrNo.equals("n"));
		} while (yesOrNo.equals("y"));
	}

	private static Car buildCar()
	{
		Car currentCar = null;
		String createOrRandom = "r";
		int year = 0;
		String make = null;
		String model = null;
		String color = null;
		double tankSize = 0.0;
		double optimalSpeed = 0.0;
		double fuelEconomy = 0.0;
		System.out.println("Would you like to input the data yourself or create a random car?");
		do
		{
			System.out.println("Please enter \"c\" for create yourself or \"r\" for random car.");
			createOrRandom = keyboard.next().toLowerCase();
		} while (!createOrRandom.equals("c") && !createOrRandom.equals("r"));
		if(createOrRandom.equals("r"))
			currentCar = new Car();
		else
		{
//			year = 0;
			System.out.println("Input the year of the car?");
			do
			{
				do
				{
				keyboard.nextLine();
				System.out.println("Please enter a date between 1920 and 2021.");
				}while(!keyboard.hasNextInt());
				year = keyboard.nextInt();
			} while (year < 1920 || year > 2021);
			keyboard.nextLine();
//		make = null;
			System.out.println("Please enter the Make of the car.");
			make = keyboard.nextLine();
//			model = null;
			System.out.println("Please enter the Model of the car.");
			model = keyboard.nextLine();
//			color = null;
			System.out.println("Please enter the color of the car.");
			color = keyboard.nextLine();
			tankSize = 0.0;
			System.out.println("Input the size of the car's fuel tank.");
			do
			{
				System.out.println("Please enter a value between 8.0 and 34.99.");
				if(keyboard.hasNextDouble())
					tankSize = keyboard.nextDouble();
				else
				{
					while(!keyboard.hasNextDouble())
					{
						keyboard.nextLine();
						System.out.println("Please enter a value between 8.0 and 34.99.");
					}
					tankSize = keyboard.nextDouble();
				}
			} while (tankSize < 8 || tankSize > 34.99);
			optimalSpeed = 0.0;
			System.out.println("Input the car's optimal driving speed for best mileage.");
			do
			{
				do
				{
					if(keyboard.hasNextLine())
						keyboard.nextLine();
					System.out.println("Please enter a value between 45.0 and 64.99.");
				}while(!keyboard.hasNextDouble());
				optimalSpeed = keyboard.nextDouble();
			} while (optimalSpeed < 45.00 || optimalSpeed > 64.99);
			fuelEconomy = 0.0;
			System.out.println("Input the car's fuel economy.");
			do
			{
				do
				{
					if(keyboard.hasNextLine())
						keyboard.nextLine();
					System.out.println("Please enter a value between 15.0 and 54.99.");
				}while(!keyboard.hasNextDouble());
				fuelEconomy = keyboard.nextDouble();
			} while (fuelEconomy < 15.00 || fuelEconomy > 54.99);
			currentCar = new Car(color,make,model,year,fuelEconomy,tankSize,optimalSpeed);
		}

		return currentCar;
	}


}
