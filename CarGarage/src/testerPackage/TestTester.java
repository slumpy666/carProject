package testerPackage;
import classPackage.Garage;

import java.util.Scanner;

import classPackage.Car;

public class TestTester {
	
    static Scanner scanner = new Scanner(System.in);
    static int numSpaces;

    public static void main(String[] args) {
        System.out.println("Welcome to the Car and Garage program");
        System.out.println("Enter the number of parking spaces you would like to have in the garage.");
        System.out.println("The number should be between 1 and 10 inclusive.");
    	
        numSpaces = scanner.nextInt();
        // create a garage with a size of 3
        Garage garage = new Garage(numSpaces);
        
        printOptions();
        
        boolean quit = false;
        while (!quit) {
            String input = scanner.next();
            switch(input) {
                case "a":
                    refuelCar();
                    break;
                case "b":
                    driveCar();
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

	private static void driveCar() {
		// TODO Auto-generated method stub
		Testing();
	}

	private static void refuelCar() {
		// TODO Auto-generated method stub
		
	}

	private static void printOptions() {
        System.out.println("A) Refuel a car");
        System.out.println("B) Get a Car to drive");
        System.out.println("C) Add a Car");
        System.out.println("Q) Quit");
        System.out.println("Please select one of the above choices.");
    } 
    private static Car Testing() {
		
    {
        Garage garage = new Garage(numSpaces);
        // create some cars to add to the garage
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        
        // try adding the cars to the garage
        System.out.println("Adding car1 to the garage: " + garage.addCar(car1)); // true
        System.out.println("Adding car2 to the garage: " + garage.addCar(car2)); // true
        System.out.println("Adding car3 to the garage: " + garage.addCar(car3)); // true
        System.out.println("Adding car4 to the garage: " + garage.addCar(car4)); // false, garage is full
        
        // try getting a car from the garage
        System.out.println("Getting car at index 1: " + garage.getCar(1)); // car2
        System.out.println("Getting car at index 2: " + garage.getCar(2));
        System.out.println("Getting car at index 2: " + garage.getCar(3));// null
        
        // try refueling a car in the garage
        System.out.println("Refueling car at index 0: " + garage.refuelCar(car1)); // true
        System.out.println("Refueling car at index 2: " + garage.refuelCar(car3)); // true
        System.out.println("Refueling car at index 3: " + garage.refuelCar(car4)); // false, car not in garage
       
        // check the size of the garage
        System.out.println("Garage size: " + garage.getGarageSize()); // 
        return null;
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