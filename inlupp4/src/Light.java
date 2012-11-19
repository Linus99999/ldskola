/**
 * 
 * @author linus & david
 * Represents a trafficlight.
 */
public class Light {

/**
 * Attributes that represents when and how often the trafficlight should switch from red to green and keep it green. 
 */
	private int period;
	private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
	private int green; // Signalen gr�n n�r time<green 		period typ 30 sek green typ 15 sek...
    
/**
 * Sets the Light-attributes
 * @param period
 * @param green
 */
	public Light(int period, int green) {
		this.period = period;
		this.green = green;
		
	}
/**
 * Steps the time forward, resets if it equal to period.
 */
	public void step() { 
		if (time == period){
			time = 0;			
		}
		else {
			time++;
		}
    }
/**
 * 
 * @return whether or not the light is green.
 */
    public boolean isGreen()   {
    	//return (time<green)? True : False; 
    	return (time<green);
	// Returnerar true om time<green, annars false
    }

    public String  toString()  {
    	return "Light: period = " + this.period + ", \n time = "+ this.time + ", \n green = " + this.green + "\n" + isGreen() +"\n" ;
    }

	
    public static void main(String [] args){
    	
    	Light l = new Light(10,6);
    	l.step();
    	System.out.print(l);
    	l.step();
    	System.out.print(l);
    	l.step();l.step();l.step();l.step();
    	System.out.print(l);
    	l.step();l.step();l.step();l.step();
    	System.out.print(l);
    	l.step();
    	System.out.print(l);
    	
    }
}



