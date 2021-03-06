package warpCore;

public class WarpCore {

	public static void main(String[] args) {
		Input input = new Input();
		Dice dice = new Dice();
		int turns = 0;
		int d1, d2, d3;
		d1 = d2 = d3 = 0;
		boolean r1, r2, r3;
		r1 = r2 = r3 = true;
		String choice = null;
		
		while(turns < 3){
			//roll the three dice
			if(r1)
			{
				d1 = dice.roll();
			}
			if(r2)
			{
				d2 = dice.roll();
			}
			if(r3)
			{
				d3 = dice.roll();
			}
			System.out.println("a b c");
			System.out.println(d1 + " " + d2 + " " + d3);
			turns++;
			
			if(turns < 3)
			{
				//decide what to keep
				choice = input.getString("Enter letters to keep ");
				r1 = r2 = r3 = false;
				choice.toLowerCase();
				if(choice.indexOf('a') == -1)
				{
					r1 = true;
				}
				if(choice.indexOf('b') == -1)
				{
					r2 = true;
				}
				if(choice.indexOf('c') == -1)
				{
					r3 = true;
				}
				
				//did we win?
				if(d1 == d2 && d2 == d3)
				{
					System.out.println("you win!");
				}
			}
		}
	}
}
