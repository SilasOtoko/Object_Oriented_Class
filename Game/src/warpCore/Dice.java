package warpCore;

public class Dice {
	private int sides;
		public int getSides(){return sides;}
		public void setSides(int value){sides = value;}
		
	//methods
		//constructor
		public Dice()
		{
			setSides(6);
		}
		public Dice(int startSides)
		{
			setSides(startSides);
		}
		
		//roll method
		/* this method takes no parameters
		 * and returns a single random integer in the range of 1 to size
		 */
		public int roll()
		{
			int n = (int)(Math.random()* getSides() + 1);
			return n;
		}
		
		@Override
		public String toString()
		{
			return getSides() + " sided dice";
		}
		
		public boolean equals(Dice other)
		{
			if(other.sides == getSides())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
}
