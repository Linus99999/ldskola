import java.util.Scanner;

public class PairOfDices {
	private Die	Dice1, Dice2;

	public PairOfDices() {
		setDice1(new Die());
		setDice2(new Die());
	}
	public PairOfDices(int antal) {
		setDice1(new Die(antal));
		setDice2(new Die(antal));
	}
	public String toString() {
		return "Die 1 = " + Dice1 + " | Die 2 = " + Dice2;
	}
	public Die getDice1() {
		return Dice1;
	}
	public void setDice1(Die dice1) {
		this.Dice1 = dice1;
	}
	public Die getDice2() {
		return Dice2;
	}
	public void setDice2(Die dice2) {
		this.Dice2 = dice2;
	}
	public int roll() {
		return Dice1.roll() + Dice2.roll();
	}
	public int get1() {
		return getDice1().get();
	}
	public int get2() {
		return getDice2().get();
	}

	public static void main(String [] args) {
		int antal;	
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of sides: ");
		antal = scan.nextInt();
		PairOfDices Pair = new PairOfDices(antal);
		Pair.roll();
		System.out.println(Pair);
		System.out.println("pair get1: " + Pair.get1());
		System.out.println("pair get2: " + Pair.get2());
	}
}