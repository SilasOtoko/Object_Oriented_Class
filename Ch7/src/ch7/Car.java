package ch7;

public class Car {
	//class variables
	private String model;
		public String getModel(){return model;}
		public void setModel(String value){model = value;}
	private int miles;
		public int getMiles(){return miles;}
		public void setMiles(int value)
		{
			if(value >= 0){
				miles = value;
			}
			else
			{
				System.err.println("invalid miles");
				System.err.println("miles set to 0");
				miles = 0;
			}
		}
	private double gallons;
		public double getGallons(){return gallons;}
		public void setGallons(double value)
		{
			if(value >= 0)
			{
				gallons = value;
			}
			else
			{
				System.err.println("invalid gallons");
				System.err.println("gallons set to 0");
				gallons = 0;
			}
		}
		
		//methods
		
		//constructor
		public Car(String startModel, int startMiles, double startGallons)
		{
			setModel(startModel);
			setMiles(startMiles);
			setGallons(startGallons);
			System.out.println(computeMPG());
		}
		
		public Car(String startModel)
		{
			setModel(startModel);
			setMiles(0);
			setGallons(0.0);
		}
		
		public Car()
		{
			setModel("unknown");
			setMiles(0);
			setGallons(0.0);
		}
		
		public double computeMPG()
		{
			if(getGallons() > 0)
			{
				return getMiles() / getGallons();
			}else
			{
				return 0;
			}
		}
		
		@Override
		public String toString()
		{
			return "model = " + model + ", miles = " + miles + ", gallons = " + gallons;
		}
		
		public boolean equals(Car other)
		{	
			if(getModel().equals(other.getModel()) && getMiles() == other.getMiles() && getGallons() == other.getGallons())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
}
