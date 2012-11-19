/**
 * 
 * @author linus & david
 * Represents a Car-lane
 */
public class Lane {
/**
 * Declares an expection.
 */
	public static class OverflowException extends RuntimeException {

		
		// Undantag som kastas n�r det inte gick att l�gga 
		// in en ny bil p� v�gen
		
		}
/**
 * The lane represented as a Car-array.
 */
	private Car[] theLane;
/**
 * Creates a new lane.
 * @param n represents the number of cars it can fit.
 */
	public Lane(int n) {
		// Konstruerar ett Lane-objekt med plats f�r n fordon
		theLane = new Car[n];
	}
/**
 * Moves all cars one step ahead if it doesn't have anything infront of it.
 */
	public void step() {
		int x = 1;
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
/**
 * Sets the car in front of the lane to null.
 * @return the car at the front of the lane.
 */
	public Car getFirst() {
		Car temp = theLane[0];
		theLane[0] = null;
		return temp;
		// Returnera och tag bort bilen som st�r f�rst
	}
/**
 * 
 * @return the Car at the front of lane.
 */
	public Car firstCar() {
		return theLane[0];
		// Returnera bilen som st�r f�rst utan att ta bort den
	}

/**
 * 
 * @return whether or not the last position in the lane is empty or not.
 */
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
/**
 * Puts c in the last position of the lane.
 * @param c a Car.
 * @throws OverflowException if the lane already has a car at the last position.
 */
	public void putLast(Car c) throws OverflowException {
		
		
	if(theLane[theLane.length -1] != null){
		throw new OverflowException();
		
	}
	theLane[theLane.length-1] = c;
		
	
	}
	// St�ll en bil p� sista platsen p� v�gen
			// (om det g�r).
	

	public String toString() {
		String s = "";
		int x = 0;
		while (x < theLane.length) {
			if (theLane[x] == null) { 
			s = s + "-";
			x++;
			}
			else {
			s = s  + theLane[x].getdestination();
			x++;
			}
		}
		return s;
	}

	public static void main(String [] args) {
		Lane l = new Lane(3);
		System.out.println("hej");
		System.out.println(l);
		System.out.println(l.lastFree());
	}
}
