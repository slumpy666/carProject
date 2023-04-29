package testerPackage;
import classPackage.Garage;

import java.util.InputMismatchException;
import java.util.Scanner;

import classPackage.Car;

public class TestTester {
	
    static Scanner scanner = new Scanner(System.in);
    static int numSpaces;

    public static void main(String[] args) {
        System.out.println("Welcome to the Car and Garage program");
        System.out.println("Enter the number of parking spaces you would like to have in the garage.");
        System.out.println("The number should be between 1 and 10 inclusive.");

        int numSpaces = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                numSpaces = scanner.nextInt();
                if (numSpaces >= 1 && numSpaces <= 10) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume the invalid input to prevent an infinite loop
            }
        }

        // create a garage with a size of 3
        Garage garage = new Garage(numSpaces);
        
        printOptions();
        
        boolean quit = false;
        while (!quit) {
            String input = scanner.next();
            switch(input) {
                case "a":
                    refuelCar(garage);
                    break;
                case "b":
                    driveCar(garage);
                    break;
                case "c":
                    addCar(garage);
                    break;
                case "q":
                    quit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
            
            if (!quit) {
                // Print the list of options after each action (except quitting)
                printOptions();
            }
        }
    }
    
	private static void printOptions() {
        System.out.println("A) Refuel a car");
        System.out.println("B) Get a Car to drive");
        System.out.println("C) Add a Car");
        System.out.println("Q) Quit");
        System.out.println("Please select one of the above choices.");
    } 
    
    private static void addCar(Garage garage) {
        Car newCar = buildCar();
        boolean success = garage.addCar(newCar);
        if (success) {
            System.out.println("New car added: " + newCar.toString());
        } else {
            System.out.println("Failed to add new car: garage is full.");
        }
        System.out.println("Current cars in garage: " + garage.getNumCars());
        System.out.println(garage.toString());
    }

    private static void driveCar(Garage garage) {
        if (garage.getNumCars() == 0) {
            System.out.println("There are no cars in the garage to drive.");
            return;
        }

        int carNumber = 0;
        System.out.println(garage.toString());
        System.out.println("Which car would you like to drive?");
        do {
        	System.out.println("Please enter the parking space number of the car you want to drive (1-" + garage.getNumCars() + "):");
            while(!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            carNumber = scanner.nextInt();
        } while (carNumber < 1 || carNumber > garage.getNumCars());

        Car currentCar = garage.callCar(carNumber - 1);
        if (currentCar == null) {
            System.out.println("There is no car in that space!");
            return;
        }

        System.out.printf("Space %d: %s%n", carNumber, currentCar.toString());

        // Get the index of the car in the garage
        int index = carNumber - 1;

        double distance = 0.0;
        System.out.println("How far would you like to drive?");
        do {
            System.out.println("Please enter a distance greater than zero.");
            while(!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
            distance = scanner.nextDouble();
        } while (distance <= 0.0);

        double speed = 0.0;
        System.out.println("How fast would you like to drive?");
        do {
            System.out.println("Please enter an amount greater than zero.");
            while(!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
            speed = scanner.nextDouble();
        } while (speed <= 0.0);

        currentCar.setUpTrip(speed, distance);
        boolean didNotRunOutOfFuel = currentCar.driveCar();
        if (didNotRunOutOfFuel) {
            System.out.printf("The car has been driven for %.2f km. It now has %.2f liters of fuel.%n",
                    distance, currentCar.getFuelLevel());
            // Return the car to its rightful index in the garage
            garage.returnCar(index, currentCar);
        } else {
            System.out.printf("The car did not have enough fuel to complete the drive. It drove for %.2f km.%n",
                    currentCar.getOdometer());
            // Remove the car from the garage since it has run out of fuel
            garage.getCar(index);
        }

        System.out.println(garage.toString());
    }

	private static void refuelCar(Garage garage) {
	    if (garage.getNumCars() == 0) {
	        System.out.println("There are no cars in the garage to refuel.");
	        return;
	    }
	    
	    int carNumber = 0;
	    double fuelOverage = 0.0;
	    double fuelAmount = 0.0;
	    Car currentCar = null;
        System.out.println(garage.toString());
	    System.out.println("Which car would you like to add fuel to?");
	    do {
	        do {
	            if(scanner.hasNextLine()) {
	                scanner.nextLine();
	            }
	            System.out.println("Please enter the car's parking space number for your selection");
	        } while(!scanner.hasNextInt());
	        carNumber = scanner.nextInt();
	    } while (carNumber < 1 || carNumber > garage.getNumCars());

	    currentCar = garage.callCar(carNumber - 1);
	    if (currentCar == null) {
	        System.out.println("There is no car in that space!");
	        System.out.printf("Please create a Car for that space.%n");
	        currentCar = buildCar();
	        garage.setCar(carNumber - 1, currentCar);
	    }
	    String carInfo = currentCar.toString();
	    System.out.printf("Space %d: %s%n", carNumber, carInfo);

	    System.out.println("How much fuel would you like to add?");
	    do {
	        do {
	            if(scanner.hasNextLine()) {
	                scanner.nextLine();
	            }
	            System.out.println("Please enter an amount greater than zero.");
	        } while(!scanner.hasNextDouble());
	        fuelAmount = scanner.nextDouble();
	    } while (fuelAmount <= 0.0);

	    fuelOverage = currentCar.addFuelToTank(fuelAmount);
	    if(fuelOverage > 0.0) {
	        System.out.printf("The tank is full and you have %.2f gallons left in the can.\n", fuelOverage);
	    } else if(fuelOverage < 0.0) {
	        System.out.printf("The tank is not full and can take %.2f more gallons of fuel.\n", -fuelOverage);
	    } else {
	        System.out.println("The tank is now full.");
	    }
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
			createOrRandom = scanner.next().toLowerCase();
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
				scanner.nextLine();
				System.out.println("Please enter a date between 1920 and 2021.");
				}while(!scanner.hasNextInt());
				year = scanner.nextInt();
			} while (year < 1920 || year > 2021);
			scanner.nextLine();
//		make = null;
			System.out.println("Please enter the Make of the car.");
			make = scanner.nextLine();
//			model = null;
			System.out.println("Please enter the Model of the car.");
			model = scanner.nextLine();
//			color = null;
			System.out.println("Please enter the color of the car.");
			color = scanner.nextLine();
			tankSize = 0.0;
			System.out.println("Input the size of the car's fuel tank.");
			do
			{
				System.out.println("Please enter a value between 8.0 and 34.99.");
				if(scanner.hasNextDouble())
					tankSize = scanner.nextDouble();
				else
				{
					while(!scanner.hasNextDouble())
					{
						scanner.nextLine();
						System.out.println("Please enter a value between 8.0 and 34.99.");
					}
					tankSize = scanner.nextDouble();
				}
			} while (tankSize < 8 || tankSize > 34.99);
			optimalSpeed = 0.0;
			System.out.println("Input the car's optimal driving speed for best mileage.");
			do
			{
				do
				{
					if(scanner.hasNextLine())
						scanner.nextLine();
					System.out.println("Please enter a value between 45.0 and 64.99.");
				}while(!scanner.hasNextDouble());
				optimalSpeed = scanner.nextDouble();
			} while (optimalSpeed < 45.00 || optimalSpeed > 64.99);
			fuelEconomy = 0.0;
			System.out.println("Input the car's fuel economy.");
			do
			{
				do
				{
					if(scanner.hasNextLine())
						scanner.nextLine();
					System.out.println("Please enter a value between 15.0 and 54.99.");
				}while(!scanner.hasNextDouble());
				fuelEconomy = scanner.nextDouble();
			} while (fuelEconomy < 15.00 || fuelEconomy > 54.99);
			currentCar = new Car(color,make,model,year,fuelEconomy,tankSize,optimalSpeed);
		}
		return currentCar;
	}


}