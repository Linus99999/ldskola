
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Arrays;



	
	
 class MyFrame extends JFrame implements ActionListener{
	private GridBagConstraints c = new GridBagConstraints();
	
	int x;
	int i;
	int u = 0;
	double finalresultat;
	
	JTextField[] textFieldNamn = new JTextField[100];
	JTextField[] textFieldPris = new JTextField[100];
	JTextField[] textFieldEnhet = new JTextField[100];
	JTextField[] textFieldAntal = new JTextField[100];
	
	JButton[] buttonPlus = new JButton[100];
	JButton[] buttonMinus = new JButton[100];
	
	JLabel utskrift = new JLabel();
	
	//int[] knappar = new int[100];
	
	
	
	/*int[] prisarray = new int[100];
	
	String[] enhetsarray = new String[100];
	*/
	
	public MyFrame(){
		//super();
		setVisible(true);
		setLayout(new GridBagLayout());
		setLocationRelativeTo(null);
		c.gridx = 0;
		c.gridy = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*while (u<100){
			textField1[u] = null;
			textField2[u] = null;
			u++;
		}*/
		init();
	}
				
	private  void init(){
		JButton mainButton = new JButton("Add another row");
		JButton resultat = new JButton("Resultat");
		mainButton.setActionCommand("new row");
		mainButton.addActionListener(this);
		resultat.setActionCommand("resultat");
		resultat.addActionListener(this);
		
		add(mainButton, c);
		
		c.gridx++;
		
		add(resultat);
		c.gridy++;
		c.gridx--;
		pack();
		
	}
	private void addButton(){
		c.gridx = c.gridx +10;
		buttonPlus[i] = new JButton("+");
		buttonMinus[i] = new JButton("-");
		
		add(buttonPlus[i],c);
		
		buttonPlus[i].setActionCommand(""+i);
		buttonPlus[i].addActionListener(this);
		
		c.gridx++;
		add(buttonMinus[i],c);
		buttonMinus[i].setActionCommand("minus"+i);
		buttonMinus[i].addActionListener(this);
		
		c.gridx =c.gridx -11;
		
		c.gridy++;
		i++;
		
		pack();
	}
	
	private void addNewLabel(){
		JLabel namn = new JLabel("Namn:");
		JLabel pris = new JLabel("Pris:");
		JLabel enhet = new JLabel("Enhet:");
		JLabel antal = new JLabel("Antal");
	
		add(namn,c);
		c.gridx = c.gridx +2;
		add(pris,c);
		c.gridx = c.gridx +2;
		add(enhet,c);
		c.gridx = c.gridx +2;
		add (antal,c);
		c.gridx = c.gridx -6;
		pack();
	}
	private void addNewTextField(){
		
		
		textFieldNamn[i] = new JTextField(6);
		textFieldNamn[i].setText("Jonny");
		c.gridx++;
		add(textFieldNamn[i],c);
	
		textFieldPris[i] = new JTextField(6);
		textFieldPris[i].setText("1");
		
		c.gridx = c.gridx +2;
		add(textFieldPris[i],c);
		c.gridx = c.gridx +2;
		
		textFieldEnhet[i] = new JTextField(6);
		textFieldEnhet[i].setText("Kg");
		add(textFieldEnhet[i],c);
		c.gridx = c.gridx + 2;
		textFieldAntal[i] = new JTextField(3);
		textFieldAntal[i].setText("0");
		add(textFieldAntal[i],c);
		c.gridx = c.gridx -7;
		pack();
		
	
	}
	
	private void removeResultat(){
		remove(utskrift);
	}
	private void addNewOutput(Double s){
		
		int gridYtemp = c.gridy;
		int gridXtemp = c.gridx;
		
		
		c.gridy = 0;
		 c.gridx = 0;
		 c.gridx =c.gridx +3 ;
		 utskrift.setText(s + "");
		 add(utskrift,c);
		  
		 c.gridx = gridXtemp;
		 c.gridy = gridYtemp;
		 x++;
		 pack();
		 
		 if(x==0){ 
		 removeResultat();
		
		 pack();
		}else{
			removeResultat();
			
			c.gridy = 0;
			c.gridx = 0;
			c.gridx =c.gridx +3 ;
			 
			utskrift.setText(s + "");
			add(utskrift,c);
			pack();
			c.gridx = gridXtemp;
			c.gridy = gridYtemp;
			
			
			
		}
		 
	}
	
	private double computeResult(){
		int count = 0;
		finalresultat = 0;
		while (textFieldPris[count] != null){
		JTextField Antal = textFieldAntal[count];
		JTextField pris = textFieldPris[count];
		finalresultat += (Double.parseDouble(pris.getText())*Double.parseDouble(Antal.getText()));
		count++;
	}
		return finalresultat;
		
	}
				
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("new row")){
			
			addNewLabel();
			addNewTextField();
			addButton();
			
		}else if(e.getActionCommand().equals("resultat")){
		
			
				double resultat = computeResult();
				addNewOutput(resultat);
				
			
			
	}else if(e.getActionCommand().equals("")){
		double resultat = computeResult();
		addNewOutput(resultat);
	}
	}
	//("plus".substring(0,4))
	
	public static void main(String [] args){
		
		new MyFrame();
	}
				
}
