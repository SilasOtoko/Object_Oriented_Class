package warpCore;

public class WarpCore {

	public static void main(String[] args) {
		Input input = new Input();
		Dice d = new Dice();
		Dice coin = new Dice(2);
		System.out.println(d.toString());
		System.out.println(coin.toString());
		int newDie = input.getInt("enter sides: ");
		Dice nd = new Dice(newDie);
		System.out.println(nd.toString());
	}
}
