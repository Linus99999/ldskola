
public class Lane {

	 public static class OverflowException extends RuntimeException {
	        // Undantag som kastas n�r det inte gick att l�gga 
	        // in en ny bil p� v�gen
	    }

	    private Car[] theLane;

	    public Lane(int n) {
		// Konstruerar ett Lane-objekt med plats f�r n fordon
	    theLane = new Car[n];
	    }

	    public void step() {
	    	x = 1;
	    	while (x < theLane.length) {
	    		if (theLane[x-1] == null && theLane[x] != null) { 
	    			theLane[x-1] = theLane[x];
	    			theLane[x] = null;
	    			x++;
	    		}
	    		else { 
	    			x++;
	    	}
	    }
		// Stega fram alla fordon (utom det p� plats 0) ett steg 
	        // (om det g�r). (Fordonet p� plats 0 tas bort utifr�n 
		// mm h a metoden nedan.)
	    }

	    public Car getFirst() {
	    	Car temp = theLane[0];
	    		theLane[0] = null;
	    		return temp;
		// Returnera och tag bort bilen som st�r f�rst
	    }

	    public Car firstCar() {
	    	return theLane[0];
		// Returnera bilen som st�r f�rst utan att ta bort den
	    }


	    public boolean lastFree() {
	    	if (theLane[theLane.length-1] == null) 
	    	{ 
	    		return true;
	    	}
	    	else {
	    		return false; 
	    	}
	    }
		// Returnera true om sista platsen ledig, annars false

	    public void putLast(Car c) throws OverflowException {
	    	theLane[theLane.length] = c;
		// St�ll en bil p� sista platsen p� v�gen
		// (om det g�r).
	    }

	    public String toString() {
	    	return ""+theLane.length;
	    }

	
	public static void main(String [] args) {
	Lane l = new Lane(3);
	System.out.println(l);
	System.out.println(l.lastFree());
}
}