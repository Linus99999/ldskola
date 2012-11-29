

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
    
    
public class Jonny extends JApplet implements ActionListener {
	  	
		int n = 1;
		int x;
	  	//private JButton knappen3 = new JButton("Kör!");
		  JLabel etiketten = new JLabel("Vad heter du?");
		  JTextField inmatningsfältet = new JTextField(6);
		  	
		  JLabel utskriften = new JLabel();
		  JButton knappen1 = new JButton("Kör1!");
		  JButton knappen2 = new JButton("Lägg till en knapp");
	  	
		
	  public void createNewWindow(){
		
		  
		  knappen1.addActionListener(this);
		  knappen2.addActionListener(this);
		  JFrame cp = new JFrame("simple GUI");
		  cp.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		  
		  cp.getContentPane();
		  
		  cp.setLayout(new FlowLayout());
		  cp.add(etiketten);
		  cp.add(inmatningsfältet);
		  cp.add(knappen1);
		  cp.add(knappen2);
		  //cp.add(knappen3);
		  cp.add(utskriften);
		  	cp.setLocationRelativeTo(null);
		  
		  cp.pack();
		  cp.setVisible(true);
		  
		 /* while (n<=x){
			  System.out.println("w1");
			  JButton knappen4 = new JButton("Kör!");
			  knappen4.addActionListener(this);
			  cp.add(knappen4);
			  n++;
			  cp.pack();
		  }*/
		  
		  
		  
	  }
	  
	  	public void createNewField() {
	  		
		JButton knappen4 = new JButton("Ny!");
		
		JFrame cp;
		cp.add(knappen4);
		//knappen4.setVisible(true);
		System.out.println("c1");
			
	  }

	  
	  public void actionPerformed(ActionEvent event){
		  JButton vilken = (JButton)event.getSource();
		  if (vilken == knappen1){
			  String namnet = inmatningsfältet.getText();
			  utskriften.setText("Hej, " + namnet + "!");
		  }else if(vilken == knappen2){
			  createNewField();
			  //x++;
			  //init();
			  //utskriften.setText("Hej, knappen2!");
		  }else {
			  
			  
			  //utskriften.setText("Va tusan?");
		  }
		  
		  
		  
	  }
	  
	 
}
