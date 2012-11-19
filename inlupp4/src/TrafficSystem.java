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
    private int intense = 0;

    public TrafficSystem() {

    	r0 = new Lane(10);
    	r1 = new Lane(6);
    	r2 = new Lane(6);
    	s1 = new Light(10,6);
    	s2 = new Light(10,6);

    }

    public readParameters() {
    	
    	
	// L�ser in parametrar f�r simuleringen
	// Metoden kan l�sa fr�n terminalf�nster, dialogrutor
	// eller fr�n en parameterfil. Det sista alternativet
	// �r att f�redra vid uttestning av programmet eftersom
	// man inte d� beh�ver mata in v�rdena vid varje k�rning.
        // Standardklassen Properties �r anv�ndbar f�r detta. 
    }

    public void step() {
    	if (s1.isGreen()) {
    		r1.getFirst();
    		r1.step();
    	}
    	if (s2.isGreen()){
    		r2.getFirst();
    		r2.step();
    	}

    	if(r0.firstCar()!=null){
    		Car car = r0.getFirst();
    		if(car.getdest() == 1 && r1.lastFree()){
    			try {r1.putLast(car);}
    			catch (Lane.OverflowException e){}
    			
    		}
    		if(car.getdest() == 2 && r2.lastFree()){
    			try {r2.putLast(car);}
    			catch (Lane.OverflowException e){}
    		}
    	}
    	r0.step();
    	
    		
    		
    	
    	if(Math.random()*intense < 1){
    		Car c = new Car(time,(int)(Math.random()*2)+1);
    		try {r0.putLast(c);}
			catch (Lane.OverflowException e){}
    	}

    	s1.step();
    	s2.step();
    	time++;
    

	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, l�gg in och ta ur p� de olika Lane-kompenenterna
    }
    
    
    public void printStatistics() {
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
    	
    	TrafficSystem tS = new TrafficSystem();
    	int x = 0;
    	while (x < 30) {
    	tS.step();
    	tS.print();
    	x++;
    	}
    	
    }
	
}
