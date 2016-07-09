package it.buracchi.cifrari.gui.affine;

import it.buracchi.cifrari.substitution.Affine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class AffineGUIcodificaRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public AffineGUIcodificaRes(String m, int ca, int cb) {
		setTitle("AFFINE CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIlMessaggioCodificiato = new JLabel("Messaggio cifrato");
		lblIlMessaggioCodificiato.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlMessaggioCodificiato.setBounds(10, 11, 414, 14);
		contentPane.add(lblIlMessaggioCodificiato);
		
		Affine aff = new Affine(m,ca,cb);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 214);
		textPane.setText(aff.coding());
		contentPane.add(textPane);		
	}

}
