import java.util.Scanner;


public class MyDieTest {

    
    
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
	Die die = new Die();
	System.out.println(die.get());
	// 6
	Die dies = new Die(-12);
	// 7
	Die d = new Die();
	System.out.println(d);
	// 8
	

	

    }


}


// Fråga 5: value är bara initierad, men har inte fått något // värde än, så det bli 0 helatiden.

// Fråga 7: Die@4f9dfbff , 