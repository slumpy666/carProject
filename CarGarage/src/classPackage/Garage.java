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
        for (int i = 0; i < size; i++) {
            if (parking[i] == null) {
                parking[i] = car;
                numCars++;
                return true;
            }
        }
        return false; // this should never happen, but just in case
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
    public Car callCar(int index) {
        if (index < 0 || index >= numCars) {
            return null;
        }
        Car car = parking[index];
        parking[index] = null;
        return car;
    }
    public int getNumCars() {
        return numCars;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Garage:\n");
        for (int i = 0; i < numCars; i++) {
            Car car = parking[i];
            sb.append("  Space ").append(i+1).append(": ").append(car.toString()).append("\n");
        }
        return sb.toString();
    }
    public void setCar(int index, Car car) {
        if (index < 0 || index >= numCars) {
            return;
        }
        parking[index] = car;
    }

}
