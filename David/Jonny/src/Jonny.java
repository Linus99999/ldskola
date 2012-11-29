
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
    
    
public class Jonny extends JApplet implements ActionListener{
	  	
		int n = 1;
		int x;
	
		private JLabel etiketten = new JLabel("Vad heter du?");
	  	private JTextField inmatningsfältet = new JTextField(6);
	  	
	  	private JLabel utskriften = new JLabel();
	  	private JButton knappen1 = new JButton("Kör!");
	  	private JButton knappen2 = new JButton("Lägg till en knapp");
	  	//private JButton knappen3 = new JButton("Kör!");
	  	
	  	
	  public void init(){
		  
		  knappen1.addActionListener(this);
		  knappen2.addActionListener(this);
		  System.out.println("1");
		  //knappen3.addActionListener(this);
		  Container cp = getContentPane();
		  cp.setLayout(new FlowLayout());
		  cp.add(etiketten);
		  cp.add(inmatningsfältet);
		  cp.add(knappen1);
		  cp.add(knappen2);
		  //cp.add(knappen3);
		  cp.add(utskriften);
		  System.out.println("2");
		  
		  while (n<=x){
			  System.out.println("w1");
			  JButton knappen4 = new JButton("Kör!");
			  knappen4.addActionListener(this);
			  cp.add(knappen4);
			  n++;
		  }
		  
		  
		  
	  }
	  
	  	/*public void createNewField() {
		JButton knappen4 = new JButton("Ny!");
		Container cp = getContentPane();
		cp.add(knappen4);
		System.out.println("c1");
			
	  }*/

	  
	  public void actionPerformed(ActionEvent event){
		  JButton vilken = (JButton)event.getSource();
		  if (vilken == knappen1){
			  String namnet = inmatningsfältet.getText();
			  utskriften.setText("Hej, " + namnet + "!");
		  }else if(vilken == knappen2){
			  //createNewField();
			  x++;
			  init();
			  //utskriften.setText("Hej, knappen2!");
		  }else {
			  
			  
			  //utskriften.setText("Va tusan?");
		  }
		  
		  
		  
	  }
	  
	 
}
