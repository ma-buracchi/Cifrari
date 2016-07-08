package it.buracchi.cifrari.gui.enigma;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.Choice;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnigmaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] rotor = {"I","II","III","IV","V"};

	/**
	 * Create the frame.
	 */
	
	public EnigmaGUI() {
		setTitle("ENIGMA CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(10, 203, 130, 20);
		choice.add("Partenza rotore veloce");
		for(int j = 0; j < 26; j++){
			choice.add(""+j);
		}
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(294, 203, 130, 20);
		choice_1.add("Partenza rotore medio");
		for(int j = 0; j < 26; j++){
			choice_1.add(""+j);
		}
		contentPane.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(153, 203, 130, 20);
		choice_2.add("Partenza rotore lento");
		for(int j = 0; j < 26; j++){
			choice_2.add(""+j);
		}
		contentPane.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(10, 177, 130, 20);
		choice_3.add("Rotore veloce");
		for(int i = 0; i < rotor.length; i++){
			choice_3.add(rotor[i]);
		}
		contentPane.add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(153, 177, 130, 20);
		choice_4.add("Rotore medio");
		for(int i = 0; i < rotor.length; i++){
			choice_4.add(rotor[i]);
		}
		contentPane.add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(294, 177, 130, 20);
		choice_5.add("Rotore lento");
		for(int i = 0; i < rotor.length; i++){
			choice_5.add(rotor[i]);
		}
		contentPane.add(choice_5);
		
		JTextPane txtpnInserireIlMessaggio = new JTextPane();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 160);
		contentPane.add(txtpnInserireIlMessaggio);
		
		Button button = new Button("Cifrare/Decifrare");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String msg = txtpnInserireIlMessaggio.getText().replace(" ", "");
				String r1 = choice_3.getSelectedItem();
				String r2 = choice_4.getSelectedItem();
				String r3 = choice_5.getSelectedItem();
				int p1 = Integer.parseInt(choice.getSelectedItem());
				int p2 = Integer.parseInt(choice_1.getSelectedItem());
				int p3 = Integer.parseInt(choice_2.getSelectedItem());
				EnigmaGUIres enigma = new EnigmaGUIres(msg,r1,p1,r2,p2,r3,p3);
				enigma.setVisible(true);
			}
		});
		button.setBounds(10, 229, 414, 22);
		contentPane.add(button);
	}

}
