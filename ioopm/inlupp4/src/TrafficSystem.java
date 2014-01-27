import java.io.*;
import java.util.Properties;
import java.util.Scanner;
/**
 * 
 * @author linus & david
 *
 * Defines the roads and signals that is included in the system.
 * Gathers statistics. 
 */
public class TrafficSystem {

	/**
	 *  Attributes that describes different parts in the system.
	 */
	private Lane  r0;
	private Lane  r1;
	private Lane  r2;
	private Light s1;
	private Light s2;

	/**
	 *  Miscellaneous attributes for simulationparameters (car intensity, time...)
	 *  Miscellaneous attributes for statistics gathering.
	 */
	private int time = 0;
	private int intense;
	private int cars = 0;	
	private int carsOut = 0;
	private int t = 0;
	int max;
	/**
	 * Creates a standard TrafficSystem.
	 */
	public TrafficSystem() {

		r0 = new Lane(10);
		r1 = new Lane(6);
		r2 = new Lane(6);
		s1 = new Light(10,6);
		s2 = new Light(10,6);
		intense = 2;
	}
	/**
	 * Creates a TrafficSystem from either standard input or a properties-file.
	 * @param n is a integer that is either 1 or 2 depending if you want to use standard in or a properties-file.
	 * @throws IOException 
	 */
	public TrafficSystem(int n) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Ankomstintensitet: ");
			intense = sc.nextInt();
			System.out.print("Period: ");
			int period = sc.nextInt();
			System.out.print("Grönperiod 1: ");
			int green1 = sc.nextInt();
			System.out.print("Grönperiod 2: ");
			int green2 = sc.nextInt();
			System.out.print("Väglängd 1: ");
			int v0 = sc.nextInt();
			System.out.print("Väglängd 2: ");
			int v1 = sc.nextInt();
			System.out.print("Väglängd 3: ");
			int v2 = sc.nextInt();
			r0 = new Lane(v0);
			r1 = new Lane(v1);
			r2 = new Lane(v2);
			s1 = new Light(period,green1);
			s2 = new Light(period,green2);
		
		// L�ser in parametrar f�r simuleringen
		// Metoden kan l�sa fr�n terminalf�nster, dialogrutor
		// eller fr�n en parameterfil. Det sista alternativet
		// �r att f�redra vid uttestning av programmet eftersom
		// man inte d� beh�ver mata in v�rdena vid varje k�rning.
		// Standardklassen Properties �r anv�ndbar f�r detta. 
	}
	/**
	 * Creates a trafficsystem based on the data from a properties file.
	 * @param prop is the searchpath for the properties file.
	 * @throws IOException 
	 */
	public TrafficSystem (String prop) throws IOException {	
		InputStream d = new FileInputStream(prop);
		Properties p = new Properties();
		p.load(d);
		r0 = new Lane(Integer.parseInt(p.getProperty("r0")));
		r1 = new Lane(Integer.parseInt(p.getProperty("r1")));
		r2 = new Lane(Integer.parseInt(p.getProperty("r2")));
		s1 = new Light(Integer.parseInt(p.getProperty("period")),Integer.parseInt(p.getProperty("green1")));
		s2 = new Light(Integer.parseInt(p.getProperty("period")),Integer.parseInt(p.getProperty("green2")));
		intense = Integer.parseInt(p.getProperty("intense"));
	}
	/**
	 * Steps the trafficsystem one step forward.
	 */
	public void step() {
		if (s1.isGreen()) {
			if (r1.firstCar() != null){
				carsOut++;
				t += time-r1.firstCar().getbornTime();
				if(time-r1.firstCar().getbornTime() > max){
					max = time-r1.firstCar().getbornTime();
				}
			}

			r1.getFirst();
			r1.step();
		}else {
			r1.step();
		}
		if (s2.isGreen()){
			if (r2.firstCar() != null) { 
				carsOut++; 
				t += time-r2.firstCar().getbornTime();
				if(time-r2.firstCar().getbornTime() > max){
					max = time-r2.firstCar().getbornTime();
				}
			}
			r2.getFirst();
			r2.step();
		}else{
			r2.step();
		}

		if(r0.firstCar()!=null){
			Car car = r0.getFirst();
			if(car.getdestination() == 1 && r1.lastFree()){
				try {r1.putLast(car);}
				catch (Lane.OverflowException e){}

			}
			if(car.getdestination() == 2 && r2.lastFree()){
				try {r2.putLast(car);}
				catch (Lane.OverflowException e){}
			}
		}
		r0.step();




		if(Math.random()*intense < 1){
			Car c = new Car(time,(int)(Math.random()*2)+1);
			try {r0.putLast(c); cars++;}
			catch (Lane.OverflowException e){}
		}

		s1.step();
		s2.step();
		time++;


		// Stega systemet ett tidssteg m h a komponenternas step-metoder
		// Skapa bilar, l�gg in och ta ur p� de olika Lane-kompenenterna
	}

	/**
	 * Prints current statistics from the trafficsystem.
	 */
	public void printStatistics() {
		System.out.println("Tid: " + time);
		System.out.println("Antal bilar in: " + cars);
		System.out.println("Antal bilar ut: " + carsOut);
		if (max >0) {
			System.out.println("Max tid för en bil: " + max);
		} else System.out.println("Max tid för en bil: Ingen bil har kört igenom.");

		try {System.out.println("Snittid: " + (t/carsOut));} 
		catch (ArithmeticException e) { System.out.println("Snittid: Inga bilar ute än." );}




		// Skriv statistiken samlad s� h�r l�ngt
	}
	/**
	 * Prints a graphical representation of the trafficsituation.
	 */
	public void print() {
		System.out.println();
		if(s1.isGreen()){
			System.out.print("G");}
		else{System.out.print("R");}
		System.out.print(r1 + "|");
		System.out.println(r0 + " <-");
		if(s2.isGreen()){
			System.out.print("G");}
		else{System.out.print("R");}
		System.out.println(r2 + "|" + " <-");

		// Skriv ut en grafisk representation av k�situationen
		// med hj�lp av klassernas toString-metoder
	}

	public static void main(String[] args) throws IOException{

		TrafficSystem tS = new TrafficSystem("prop.txt");
		int x = 0;
		while (x < 100) {
			tS.step();
			tS.print();
			x++;
			tS.printStatistics();
		}

	}

}
