import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author linus & david
 *
 * Starts a Trafficsimulation based in your inputs.
 */
public class Simulation {

	public static void main(String [] args) throws IOException {
		TrafficSystem tS = null;
		// Skapar ett TrafficSystem
		// Utf�r stegningen, anropar utskriftsmetoder
		Scanner sc = new Scanner(System.in);
		System.out.print("1 om du vill ha ett standard trafiksystem.\n2 om du vill lägga in egna värden.\n3 om du vill lägga in egna värden från en properties-fil.\n4 om du vill skapa en properties-fil.");
		int type = sc.nextInt();
		if (type == 1) { 
			tS = new TrafficSystem(); 
		}
		else if (type == 2) {
			tS = new TrafficSystem(1);
		} 
		else if (type == 3) {
			System.out.print("Ange sökväg till filen: ");
			String props = sc.next();
			tS = new TrafficSystem(props);
		}
		else { new Props(); return; }
		System.out.print("Hur många steg vill du simulera? ");
		int x = 0;
		int steps = sc.nextInt();
		while (x < steps) {
			tS.step();
			tS.print();
			x++;

		}
		tS.printStatistics();
	}
}
