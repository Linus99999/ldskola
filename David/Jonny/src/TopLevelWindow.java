import java.util.Scanner;
 import java.awt.*; 
 import javax.swing.*; 
 
 // Create a simple GUI window
 public class TopLevelWindow {
 
    private static void createWindow(int n) {
    	if (n==1){
    		n = 1;
    	}else{
    		n = 0;
    	}
    	int x = 0;
       //Create and set up the window. 
       JFrame frame = new JFrame("Simple GUI");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
       JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER); 
       textLabel.setPreferredSize(new Dimension(300, 100)); 
       frame.getContentPane().add(textLabel, BorderLayout.CENTER); 
 
       //Display the window. 
       frame.setLocationRelativeTo(null); 
       frame.pack();
       frame.setVisible(true);
       
       while (n<=x){
			  System.out.println("w1");
			  JLabel knappen4 = new JLabel("The new one!");
			  frame.add(knappen4);
			  n++;
			  frame.pack();
			  frame.setLocationRelativeTo(null);
			  frame.setVisible(true);
		  }
    }
    
    	/*public static void createNewLabel(){
    		createWindow();
    		JLabel textlabel1 = new JLabel("this one is new");
    		
    	}*/
 
    public static void main(String[] args) {
 
       createWindow(1);
       Scanner sc = new Scanner(System.in);
       int bla = sc.nextInt();
       if (bla == 2){
    	   createWindow(2);   
       }else {
    	   System.out.println("HEJ!");
       }
 
    }
 } 