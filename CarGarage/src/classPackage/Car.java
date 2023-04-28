package classPackage;

import java.util.Random;


public class Car
{
	private String Make;
	private String Model;
	private int Year;
	private double FuelTankSize;
	private double FuelEconomy;
	private double OptimalSpeed;
	private double Odometer;
	private double TripOdometer;
	private String Color;
	private double FuelLevel;
	
	
	public final String getMake()
	{
		return Make;
	}
	public final void setMake(String value)
	{
		Make = value;
	}
	public final String getModel()
	{
		return Model;
	}
	public final void setModel(String value)
	{
		Model = value;
	}
	public final int getYear()
	{
		return Year;
	}
	public final void setYear(int value)
	{
		Year = value;
	}
	public final double getFuelTankSize()
	{
		return FuelTankSize;
	}
	public final void setFuelTankSize(double value)
	{
		FuelTankSize = value;
	}
	public final double getFuelEconomy()
	{
		return FuelEconomy;
	}
	public final void setFuelEconomy(double value)
	{
		FuelEconomy = value;
	}
	public final double getOptimalSpeed()
	{
		return OptimalSpeed;
	}
	public final void setOptimalSpeed(double value)
	{
		OptimalSpeed = value;
	}
	public final double getOdometer()
	{
		return Odometer;
	}
	public final void setOdometer(double value)
	{
		Odometer = value;
	}
	public final double getTripOdometer()
	{
		return TripOdometer;
	}
	public final void setTripOdometer(double value)
	{
		TripOdometer = value;
	}
	public final String getColor()
	{
		return Color;
	}
	public final void setColor(String value)
	{
		Color = value;
	}
	public final double getFuelLevel()
	{
		return FuelLevel;
	}
	public final void setFuelLevel(double value)
	{
		FuelLevel = value;
	}
	

	public Car()
	{
		String[][] makesAndModels = {
	            {"Honda", "Civic", "Accord", "CR-V", "Pilot"},
	            {"Toyota", "Corolla", "Camry", "RAV4", "Highlander"},
	            {"Ford", "Focus", "Fusion", "Escape", "Explorer"},
	            {"Chevrolet", "Cruze", "Malibu", "Equinox", "Tahoe"},
	            {"Nissan", "Sentra", "Altima", "Rogue", "Pathfinder"}
	        };
        String[] colors = {"Black", "White", "Red", "Blue", "Silver"};
        
        Random rand = new Random();
        
        String[] makeAndModels = makesAndModels[rand.nextInt(makesAndModels.length)];
        setMake(makeAndModels[0]);
        setModel(makeAndModels[rand.nextInt(makeAndModels.length - 1) + 1]);
        setYear(rand.nextInt(102) + 1920);
        double fuelTankSize = 8.0 + rand.nextDouble() * (34.99 - 8.0);
        setFuelTankSize(Double.parseDouble(String.format("%.2f", fuelTankSize))); 
        double fuelEconomy = 15.0 + rand.nextDouble() * (54.99 - 15.0);
        setFuelEconomy(Double.parseDouble(String.format("%.2f", fuelEconomy)));
        double optimalSpeed = 45.0 + rand.nextDouble() * (64.99 - 45.0); 
        setOptimalSpeed(Double.parseDouble(String.format("%.2f", optimalSpeed)));
        setOdometer(rand.nextDouble() * 5.99);
		setTripOdometer(0);
		setColor(colors[rand.nextInt(colors.length)]);
		double fuelLevel = 8.0 + rand.nextDouble() * (fuelTankSize - 8.0);
		setFuelLevel(Double.parseDouble(String.format("%.2f", fuelLevel)));
	}
	public Car(String color, String make, String model,  int year, double tanksize, double fueleconomy, double optimalspeed)
	{   		
		setColor(color);
		setMake(make);
		setModel(model);
		setYear(year);
		setFuelTankSize(tanksize);
		setFuelEconomy(fueleconomy);
		setOptimalSpeed(optimalspeed);
		setTripOdometer(0);	
		setFuelLevel(21);
	}
	
	
	 public final double addFuelToTank(double fuelQuantity)
	 {
				double tankCapacity = FuelTankSize - FuelLevel;
				double returnValue = 0;

				if ((FuelLevel + fuelQuantity) > FuelTankSize)
				{
					FuelLevel = FuelLevel + tankCapacity;
					returnValue = fuelQuantity - tankCapacity;
				}
				else if ((FuelLevel + fuelQuantity) < FuelTankSize)
				{
					FuelLevel = FuelLevel + fuelQuantity;
					returnValue = FuelLevel - FuelTankSize;
				}
				else
				{
					FuelLevel = FuelLevel + fuelQuantity;
					returnValue = 0;
				}

				return returnValue;
	 }
	
	
	@Override
	public String toString() {
	    return "Make: " + getMake() + ", Model: " + getModel() + ", Year: " + getYear() + ", Fuel Level: " + getFuelLevel() + "/" + getFuelTankSize() + ", Fuel Economy: " + getFuelEconomy() + ", Optimal Speed: " + getOptimalSpeed();
	}

	public final boolean equals(Car car) {
	    if (getMake() != null && getYear() != 0 && getModel() != null && car.getMake() != null && car.getYear() != 0 && car.getModel() != null) {
	        return (getMake().equals(car.getMake()) && getYear() == car.getYear() && getModel().equals(car.getModel())) ? true : false;
	    }
	    return false;
	}

	public final boolean driveCar() {
	    double distance = 60;
	    setFuelLevel(distance / getFuelEconomy());
	    return getFuelLevel() <= 0 ? false : true;
	}

	public final void clearTripOdometer() {
	    setTripOdometer(0);
	}
	
 public final void setUpTrip(double speed, double distance)
 {

			OptimalSpeed = speed;
			FuelLevel = distance / FuelEconomy;

 }

}

