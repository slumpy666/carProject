/**
 * 
 */
package testerPackage;
import java.util.Scanner;
import classPackage.Garage;
import classPackage.Car;

/**
 * @author Jorge Torre
 *
 */
public class GarageTester {
	static Scanner scanner = new Scanner(System.in);
    static Car[] cars;
    static int numSpaces;
	public static void main(String[] args) {
	    	
	        System.out.println("Welcome to the Car and Garage program");
	        System.out.println("Enter the number of parking spaces you would like to have in the garage.");
	        System.out.println("The number should be between 1 and 10 inclusive.");
	        
	        numSpaces = scanner.nextInt();
	        
	        // Initialize the cars array with the specified number of spaces
	        // Print the initial list of options
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
	                    addCar();
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
		private static void addCar() {
		// TODO Auto-generated method stub
	        Garage garage = new Garage(numSpaces);
	        boolean result = garage.addCar(null);
	        System.out.println("Adding car1 to garage: " + result); // Should print true
		
	}
		private static void driveCar() {
		// TODO Auto-generated method stub
		
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
		
}