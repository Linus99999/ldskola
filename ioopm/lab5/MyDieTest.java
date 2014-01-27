import java.util.Scanner;


public class MyDieTest {

    
    public static boolean equals(Die tarning1, Die tarning2) {
	return (tarning1.roll() == tarning2.roll());
	    }
    
    public static void main(String [] args) {
	int antal;	
	Scanner scan = new Scanner(System.in);
	System.out.print("Number of sides: ");
	antal = scan.nextInt();
	Die Dice = new Die(antal);

	int index = 1;
	
	while(index <= 10){
	    System.out.println("kast " + index + ":" + Dice.roll());
	    index++;  
	}
	// 5
	// Die die = new Die();
	 System.out.println(Dice.get());
	// 6
	Die dies = new Die(-12);
	// 7
	Die d = new Die();
	d.roll();
	System.out.println(d);
	// 8
	Die Dice1 = new Die(antal);
	
	System.out.println(equals(Dice,Dice1));


	PairOfDices Pair = new PairOfDices(antal);
	Pair.roll();
	System.out.println(Pair);
	

	System.out.println("pair get: " + Pair.get1());
	System.out.println("pair get: " + Pair.get2());
    }


}


// Fråga 5: value är bara initierad, men har inte fått något // värde än, så det bli 0 helatiden.

// Fråga 7: Die@4f9dfbff , 