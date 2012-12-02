
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
	
	JTextField[] textField1 = new JTextField[100];
	JTextField[] textField2 = new JTextField[100];
	
	
	
	/*int[] prisarray = new int[100];
	
	String[] enhetsarray = new String[100];
	*/
	
	public MyFrame(){
		super();
		setVisible(true);
		setLayout(new GridBagLayout());
		setLocationRelativeTo(null);
		c.gridx = 0;
		c.gridy = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (u<100){
			textField1[u] = null;
			textField2[u] = null;
			u++;
		}
		addNewButton();
	}
				
	private  void addNewButton(){
		JButton mainButton = new JButton("Add another button");
		JButton resultat = new JButton("Resultat");
		mainButton.setActionCommand("new button");
		mainButton.addActionListener(this);
		add(mainButton, c);
		
		c.gridx++;
		resultat.setActionCommand("resultat");
		resultat.addActionListener(this);
		add(resultat);
		c.gridy++;
		c.gridx--;
		pack();
		
	}
	private void addNewLabel(){
		JLabel pris = new JLabel("Pris:");
		JLabel enhet = new JLabel("Enhet:");
		add(pris,c);
		c.gridx = c.gridx +2;
		add(enhet,c);
		c.gridx = c.gridx -2;
		pack();
	}
	private void addNewTextField(){
		
		textField1[i] = new JTextField(6);
		textField1[i].setText("1");
		c.gridx++;
		add(textField1[i],c);
		c.gridx = c.gridx +2;
		
		textField2[i] = new JTextField(6);
		textField2[i].setText("1");
		add(textField2[i],c);
		c.gridx = c.gridx -3;
		pack();
		c.gridy++;
	}
	
	private void addNewOutput(Double s){
		 JLabel utskrift = new JLabel();
		 c.gridy = c.gridy +2;
		 add(utskrift,c);
		 
		 utskrift.setText(s + "");
		 pack();
		 
		 
	}
	
	private double computeResult(){
		int count = 0;
		while (textField1[count] != null){
		JTextField pris = textField1[count];
		finalresultat += Double.parseDouble(pris.getText());
		count++;
	}
		return finalresultat;
		
	}
				
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("new button")){
			
			addNewLabel();
			addNewTextField();
			
		}else if(e.getActionCommand().equals("resultat")){
		
			if(x==0){
				double resultat = computeResult();
				addNewOutput(resultat);
				x++;
			} //computeResult();
			
	}
	}
	
	
	public static void main(String [] args){
		
		new MyFrame();
	}
				
}
