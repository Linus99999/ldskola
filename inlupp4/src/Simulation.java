import java.io.IOException;
import java.util.Scanner;
public class Simulation {


	public static void main(String [] args) throws IOException {
		TrafficSystem tS;
		// Skapar ett TrafficSystem
		// Utf�r stegningen, anropar utskriftsmetoder
		Scanner sc = new Scanner(System.in);
		System.out.print("Skriv 1 om du vill ha ett standard trafiksystem. 2 om du vill lägga in egna värden. 3 om du vill lägga in egna värden från en fil.");
		if (sc.nextInt() == 1) { 
			 tS = new TrafficSystem(); 
		}
		else if (sc.nextInt() == 2) {
			tS = new TrafficSystem(1);
		} 
		else {
			System.out.print("Ange sökväg till filen: ");
			tS = new TrafficSystem(sc.nextLine());

		}
		System.out.print("Hur många steg vill du simulera?");
		int x = 0;
		while (x < sc.nextInt()) {
			tS.step();
			tS.print();
			x++;

		}
		tS.printStatistics();
	}
}
