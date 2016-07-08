package it.buracchi.cifrari.gui.vigenere;

import it.buracchi.cifrari.vigenere.Vigenere;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class VigenereGUIdecodificaRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public VigenereGUIdecodificaRes(String m, String k) {
		setTitle("VIGENERE CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIlMessaggioCodificiato = new JLabel("Messaggio decifrato");
		lblIlMessaggioCodificiato.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlMessaggioCodificiato.setBounds(10, 11, 414, 14);
		contentPane.add(lblIlMessaggioCodificiato);
		
		Vigenere vgn = new Vigenere(m,k);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 214);
		textPane.setText(vgn.decoding());
		contentPane.add(textPane);
	}

}
