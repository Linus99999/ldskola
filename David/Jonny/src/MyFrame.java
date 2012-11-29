
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




	
	
 class MyFrame extends JFrame implements ActionListener{
	private GridBagConstraints c = new GridBagConstraints();
	
	public MyFrame(){
		super();
		setVisible(true);
		setLayout(new GridBagLayout());
		setLocationRelativeTo(null);
		c.gridx = 0;
		c.gridy = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		JTextField textField1 = new JTextField(6);
		JTextField textField2 = new JTextField(6);
		c.gridx++;
		add(textField1,c);
		c.gridx = c.gridx +2;
		add(textField2,c);
		c.gridx = c.gridx -3;
		pack();
		c.gridy++;
	}
	
	private void addNewOutput(String s){
		 JLabel utskrift = new JLabel();
		 c.gridy = c.gridy +2;
		 add(utskrift,c);
		 utskrift.setText(s);
		 pack();
		 
		 
	}
				
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("new button")){
			
			addNewLabel();
			addNewTextField();
		}else if(e.getActionCommand().equals("resultat")){
		
			addNewOutput("Resultat:");
			
	}
	}
	
	
	public static void main(String [] args){
		new MyFrame();
	}
				
}
