import java.util.Scanner;
public class Name {
    
    public static void main (String [] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Name 1: ");
	String Name1 = scan.nextLine();
	System.out.println("Name 2: ");
	String Name2 = scan.nextLine();
	if (Name1.compareTo(Name2) < 0) {
	    System.out.println(Name1);
	    System.out.println(Name2);
	} else {
	    System.out.println(Name2);
	    System.out.println(Name1);
	}
    }
}