package classPackage;

/**
 * @author Jorge Torre
 *
 */

public class Garage {
    private int size;
    private Car[] parking;
    private int numCars;

    public Garage(int size) {
        this.size = size;
        this.parking = new Car[size];
        this.numCars = 0;
    }
    
    public int getGarageSize() {
        return size;
    }

    public boolean addCar(Car car) {
        if (numCars >= size) {
            return false;
        }
        parking[numCars++] = car;
        return true;
    }

    public Car getCar(int index) {
        if (index < 0 || index >= numCars) {
            return null;
        }
        Car car = parking[index];
        parking[index] = null;
        numCars--;
        return car;
    }

    public boolean refuelCar(Car car) {
        if (car == null || car.getFuelLevel() == car.getFuelLevel()) {
            return false;
        }
        car.setFuelLevel(car.getFuelLevel());
        return true;
    }
}
