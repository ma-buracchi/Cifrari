package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.other.Farfallino;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class FarfaGUIdecifRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FarfaGUIdecifRes(String msg) {
		setTitle("FARFALLINO CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMessaggioCodificato = new JLabel("Messaggio decifrato");
		lblMessaggioCodificato.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioCodificato.setBounds(10, 11, 414, 14);
		contentPane.add(lblMessaggioCodificato);
		
		Farfallino f = new Farfallino(msg);
		
		JTextArea textPane = new JTextArea();
		textPane.setBounds(10, 36, 414, 214);
		textPane.setLineWrap(true);
		textPane.setText(f.decoding());
		contentPane.add(textPane);
	}
}
