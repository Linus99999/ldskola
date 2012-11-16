
public class Light {

	private int period;
	private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
	private int green; // Signalen grön när time<green 		period typ 30 sek green typ 15 sek...
    
	public Light(int period, int green) {
		this.period = period;
		this.green = green;
		
	}

	public void step() { 
		if (time == period){
			time = 0;			
		}else {
			time++;
		}
    }

    public boolean isGreen()   {
    	//return (time<green)? True : False; 
    	if(time<green){
    		return true;}
    	else{
    		return false;}
    	
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



