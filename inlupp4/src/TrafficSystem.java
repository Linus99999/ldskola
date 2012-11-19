import java.util.Scanner;
public class TrafficSystem {

	// Definierar de v�gar och signaler som ing�r i det 
	// system som skall studeras.
	// Samlar statistik

	// Attribut som beskriver best�ndsdelarna i systemet
	private Lane  r0;
	private Lane  r1;
	private Lane  r2;
	private Light s1;
	private Light s2;

	// Diverse attribut f�r simuleringsparametrar (ankomstintensiteter,
	// destinationer...)

	// Diverse attribut f�r statistiksamling


	private int time = 0;
	private int intense;
	private int cars = 0;	
	private int carsOut = 0;
	private int t = 0;
	public TrafficSystem() {

		r0 = new Lane(10);
		r1 = new Lane(6);
		r2 = new Lane(6);
		s1 = new Light(10,6);
		s2 = new Light(10,6);
		intense = 2;
	}

	public TrafficSystem(int n) {
		if (n == 1) {
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
				
				
		}
		else {
			
		}
				// L�ser in parametrar f�r simuleringen
				// Metoden kan l�sa fr�n terminalf�nster, dialogrutor
				// eller fr�n en parameterfil. Det sista alternativet
				// �r att f�redra vid uttestning av programmet eftersom
				// man inte d� beh�ver mata in v�rdena vid varje k�rning.
				// Standardklassen Properties �r anv�ndbar f�r detta. 
	}

	public void step() {
		if (s1.isGreen()) {
			if (r1.firstCar() != null){
				carsOut++;
				t += time-r1.firstCar().getbornTime();
			}
			r1.getFirst();
			r1.step();
		}
		if (s2.isGreen()){
			if (r2.firstCar() != null) { 
				carsOut++; 
				t += time-r2.firstCar().getbornTime();
			}
			r2.getFirst();
			r2.step();
		}

		if(r0.firstCar()!=null){
			Car car = r0.getFirst();
			if(car.getdest() == 1 && r1.lastFree()){
				try {r1.putLast(car); cars++;}
				catch (Lane.OverflowException e){}

			}
			if(car.getdest() == 2 && r2.lastFree()){
				try {r2.putLast(car); cars++;}
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


	public void printStatistics() {
		System.out.println("Tid: " + time);
		System.out.println("Antal bilar in: " + cars);
		System.out.println("Antal bilar ut: " + carsOut);
		try {System.out.println("Snittid: " + (t/carsOut));} 
		catch (ArithmeticException e) { System.out.println("Snittid: Inga bilar ute än." );}
		
		// Skriv statistiken samlad s� h�r l�ngt
	}

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

	public static void main(String[] args){

		TrafficSystem tS = new TrafficSystem(1);
		int x = 0;
		while (x < 100) {
			tS.step();
			tS.print();
			x++;
			tS.printStatistics();
		}

	}

}
