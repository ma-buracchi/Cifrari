package it.buracchi.cifrari.gui.oneTimePad;

import it.buracchi.cifrari.onetimepad.OneTimePad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class OneTimePadGUIcifRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OneTimePadGUIcifRes(String msg) {
		setTitle("ONE-TIME PAD CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OneTimePad otp = new OneTimePad(msg);
		
		JLabel lblIlMessaggioCifrato = new JLabel("Il messaggio cifrato \u00E8:");
		lblIlMessaggioCifrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlMessaggioCifrato.setBounds(10, 11, 414, 14);
		contentPane.add(lblIlMessaggioCifrato);
		
		JLabel lblLaChiaveDi = new JLabel("La relativa chiave di decifratura \u00E8:");
		lblLaChiaveDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaChiaveDi.setBounds(10, 133, 414, 20);
		contentPane.add(lblLaChiaveDi);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 86);
		textPane.setText(otp.coding());
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 164, 414, 86);
		textPane_1.setText(otp.printKey());
		contentPane.add(textPane_1);
	}
}
