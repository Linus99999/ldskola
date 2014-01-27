import java.util.Scanner;

public class PairOfDice{

     public static void main(String [] args) {
	int antal;	
	Scanner scan = new Scanner(System.in);
	System.out.print("Number of sides: ");
	antal = scan.nextInt();
	Die Dice = new Die(antal);
	Die Dice2 = new Die(antal);
	System.out.println("slag ifrån tärning1:" + Dice.roll());
	System.out.println("slag ifrån tärning2:" + Dice2.roll());
	System.out.println(Dice);
	System.out.println(Dice2);
     }




}