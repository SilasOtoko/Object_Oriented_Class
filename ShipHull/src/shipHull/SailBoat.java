package shipHull;

public class SailBoat {
	private double hullSpeed;
	private String boatName;
		public String getBoatName(){return boatName;}
		public void setBoatName(String value){boatName = value;}
	private double length;
		public double getLength(){return length;}
		public void setLength(double value)
		{
			if(value >= 0)
			{
				length = value;
			}
			else
			{
				System.err.println("invalid length");
				System.err.println("length set to 0");
				length = 0;
			}
		}
	
	
	
		public SailBoat(String name, double feet)
		{
			setBoatName(name);
			setLength(feet);
			System.out.println(calculateHullSpeed());
		}
		
		public double calculateHullSpeed()
		{
			if(getLength() > 0)
			{
				return hullSpeed = 3.14 * (Math.sqrt(getLength()));
			}
			else
			{
				return 0;
			}
		}
		
		@Override
		public String toString()
		{
			return getBoatName() + "\n Hull size: " + getLength() + "ft.\n Hull Speed: " + hullSpeed;
		}
		
		public boolean equals(SailBoat other)
		{
			if(getBoatName().equals(other.getBoatName()) && getLength() == other.getLength())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
}
