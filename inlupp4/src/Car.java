
public class Car {
	
	private int bornTime;
	private int dest; // 1 för rakt fram, 2 för vänstersväng
	
	public Car(int temp_borntime){
		bornTime = temp_borntime;
		dest = 1;
		
	}

	public Car(int temp_borntime, int temp_dest){
		bornTime = temp_borntime;
		dest = temp_dest;
		
	}
	
	public int getbornTime(){
		
		return bornTime;
	}
	
	public int getdest(){
		
		return dest;
	}
	
	
	    
	public String toString() {
		return "Car: \nbornTime=" + this.bornTime + " \ndest =" + this.dest;
		
		
	}
	
	public static void main (String [] args){
		
		Car b = new Car(2);
		System.out.println(b);
		System.out.println(b.getbornTime());
		System.out.println(b.getdest());
		
	}

}
