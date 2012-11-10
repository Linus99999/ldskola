import java.util.Scanner;

public class Die {
  private int numberOfSides;
  private int value;

  public Die() { 
      numberOfSides = 6; 
  }

  public Die(int _numberOfSides) { 
      if(_numberOfSides > 0 && _numberOfSides < 100){
      numberOfSides = _numberOfSides; 
      }else {
	  System.out.println("Vad är de för en konstig tärning?");
      }
  }

    public int roll() {
      return value =  (int) (Math.random()*numberOfSides) + 1;
  }
    
    public int get() { 
      return roll(); 
  }
    public String toString() {
      return "Die(" + value + ")";
  }
    public boolean equals(Die tarning) {
	
    }


  public static void main(String [] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Number of sides: ");
      Die d = new Die(sc.nextInt());
      System.out.println("Alea iacta est: " + d.roll());
  } 
}
