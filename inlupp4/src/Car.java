/**
 * 
 * Represents a class of cars with a borntime and a destination variable. The destination variable represents the way the car is going to go.
 * 
 */
public class Car {
	
	private int bornTime;
	private int destination; // 1 f�r rakt fram, 2 f�r v�nstersv�ng
/**
 * Construct a car with borntime and default destination = 1.
 * @param temp_borntime The time when the car is created.
 */
	public Car(int temp_borntime){
		bornTime = temp_borntime;
		destination = 1;
		
	}
/**
 * Construct a car.
 * @param temp_borntime The time when the car is created.
 * @param temp_destination Decides which way the car is going, 1 for straight forward and 2 for a left turn.
 */
	public Car(int temp_borntime, int temp_destination){
		bornTime = temp_borntime;
		destination = temp_destination;
		
	}
/**
 * 
 * @return Returns an int of the cars borntime.
 */
	public int getbornTime(){
		
		return bornTime;
	}
	/**
	 * 
	 * @return Returns an int of the cars destination variable.
	 */
	public int getdestination(){
		
		return destination;
	}
	

	    
	public String toString() {
		return "Car: \nbornTime=" + bornTime + " \ndest =" + destination;
		
		
	}
	
	public static void main (String [] args){
		
		Car b = new Car(2);
		System.out.println(b);
		System.out.println(b.getbornTime());
		System.out.println(b.getdestination());
		
	}

}


int max;
if(time-borntime > max){
	max = time - borntime;
}

}
