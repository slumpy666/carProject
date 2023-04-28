package testerPackage;
import classPackage.Garage;
import classPackage.Car;

public class TestTester {

    public static void main(String[] args) {
        // create a garage with a size of 3
        Garage garage = new Garage(3);
        
        // create some cars to add to the garage
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        
        // try adding the cars to the garage
        System.out.println("Adding car1 to the garage: " + garage.addCar(car1)); // true
        System.out.println("Adding car2 to the garage: " + garage.addCar(car2)); // true
        System.out.println("Adding car3 to the garage: " + garage.addCar(car3)); // true
        System.out.println("Adding car4 to the garage: " + garage.addCar(car4)); // false, garage is full
        
        // try getting a car from the garage
        System.out.println("Getting car at index 1: " + garage.getCar(1)); // car2
        System.out.println("Getting car at index 3: " + garage.getCar(3)); // null
        
        // try refueling a car in the garage
        System.out.println("Refueling car at index 0: " + garage.refuelCar(car1)); // true
        System.out.println("Refueling car at index 2: " + garage.refuelCar(car3)); // true
        System.out.println("Refueling car at index 3: " + garage.refuelCar(car4)); // false, car not in garage
        
        // check the size of the garage
        System.out.println("Garage size: " + garage.getGarageSize()); // 3
    }
}