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
}
