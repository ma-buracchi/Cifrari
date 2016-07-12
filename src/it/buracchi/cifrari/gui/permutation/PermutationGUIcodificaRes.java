package it.buracchi.cifrari.gui.permutation;

import it.buracchi.cifrari.hill.Permutation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class PermutationGUIcodificaRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public PermutationGUIcodificaRes(int m, String p, String msg) {
		setTitle("PERMUTATION CIPHER");
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
		
		Permutation perm = new Permutation(m,p,msg);
		
		JTextArea textPane = new JTextArea();
		textPane.setBounds(10, 36, 414, 214);
		textPane.setLineWrap(true);
		textPane.setText(perm.coding());
		contentPane.add(textPane);
	}

}
