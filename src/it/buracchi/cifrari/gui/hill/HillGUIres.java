package it.buracchi.cifrari.gui.hill;

import it.buracchi.cifrari.hill.Hill;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class HillGUIres extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public HillGUIres(int m, String k, String msg) {
		setTitle("HILL CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIlMessaggioCifratodecifrato = new JLabel("Messaggio cifrato/decifrato");
		lblIlMessaggioCifratodecifrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlMessaggioCifratodecifrato.setBounds(10, 11, 414, 14);
		contentPane.add(lblIlMessaggioCifratodecifrato);
		
		Hill h = new Hill(m,k,msg);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 214);
		textPane.setText(h.coding());
		contentPane.add(textPane);
	}

}
