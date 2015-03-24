package warpCore;

import java.util.Scanner;

public class Input {
	private Scanner scan;
	
	//constructor
	public Input()
	{
		scan = new Scanner(System.in);
	}
	
	//public int getInt - gets an Integer
	public int getInt(String prompt)
	{
		System.out.println(prompt);
		while(!scan.hasNextInt())
		{
			String garbage = scan.nextLine();
			System.err.println("Not an integer");
			System.err.print(prompt);
		}
		return scan.nextInt();
	}
	
	//public double getDouble - gets an double
		public double getDouble(String prompt)
		{
			System.out.println(prompt);
			while(!scan.hasNextInt())
			{
				String garbage = scan.nextLine();
				System.err.println("Not an integer");
				System.err.print(prompt);
			}
			return scan.nextDouble();
		}
		
		public String getString(String prompt)
		{
			System.out.print(prompt);
			return scan.next();
		}
}
