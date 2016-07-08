package it.buracchi.cifrari.gui.enigma;

import it.buracchi.cifrari.enigma.Enigma;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class EnigmaGUIres extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EnigmaGUIres(String m, String r1, int p1, String r2, int p2, String r3, int p3) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMessaggioCifratodecifrato = new JLabel("Messaggio cifrato/decifrato");
		lblMessaggioCifratodecifrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioCifratodecifrato.setBounds(10, 11, 414, 14);
		contentPane.add(lblMessaggioCifratodecifrato);
		
		Enigma en = new Enigma(r1,p1,r2,p2,r3,p3);
		
		String res = "";
		
		for (int i = 0; i < m.length(); i++) {
			char text = m.charAt(i);
			char temp = en.code(text);
			res = res + temp;
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 214);
		textPane.setText(res);
		contentPane.add(textPane);
	}

}
