
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
    
    
public class Jonny extends JApplet implements ActionListener{
	  	private JLabel etiketten = new JLabel("Vad heter du?");
	  	private JTextField inmatningsf�ltet = new JTextField(6);
	  	
	  	private JLabel utskriften = new JLabel();
	  	private JButton knappen1 = new JButton("K�r!");
	  	private JButton knappen2 = new JButton("K�r!");
	  	private JButton knappen3 = new JButton("K�r!");
	  	
	  	
	  public void init(){
		  knappen1.addActionListener(this);
		  knappen2.addActionListener(this);
		  knappen3.addActionListener(this);
		  Container cp = getContentPane();
		  cp.setLayout(new FlowLayout());
		  cp.add(etiketten);
		  cp.add(inmatningsf�ltet);
		  cp.add(knappen1);
		  cp.add(knappen2);
		  cp.add(knappen3);
		  cp.add(utskriften);
		  
	  }

	  
	  public void actionPerformed(ActionEvent event){
		  JButton vilken = (JButton)event.getSource();
		  if (vilken == knappen1){
			  String namnet = inmatningsf�ltet.getText();
			  utskriften.setText("Hej, " + namnet + "!");
		  }else if(vilken == knappen2){
			  utskriften.setText("Hej, knappen2!");
		  }else {
			  utskriften.setText("Va tusan?");
		  }
		  
		  
		  
	  }
}
//Kanske