package it.buracchi.cifrari.gui.substitution;

import it.buracchi.cifrari.substitution.Substitution;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class SubstitutionGUIcodificaRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public SubstitutionGUIcodificaRes(String p, String m) {
		setTitle("SUBSTITUTION CIPHER");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblIlMessaggioCodificato = new JLabel("Messaggio codificato");
		lblIlMessaggioCodificato.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIlMessaggioCodificato, BorderLayout.NORTH);
		
		Substitution sub = new Substitution(p, m);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(sub.coding());
		contentPane.add(textPane, BorderLayout.CENTER);
	}

}
