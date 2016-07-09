package it.buracchi.cifrari.gui.shift;

import it.buracchi.cifrari.substitution.Shift;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ShiftGUIcodificaRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ShiftGUIcodificaRes(String m, int s) {
		setTitle("SHIFT CIPHER");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblIlMessaggioCodificato = new JLabel("Messaggio codificato");
		lblIlMessaggioCodificato.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIlMessaggioCodificato, BorderLayout.NORTH);
		
		Shift gc = new Shift(m, s);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(gc.coding());
		contentPane.add(textPane, BorderLayout.CENTER);
	}

}
