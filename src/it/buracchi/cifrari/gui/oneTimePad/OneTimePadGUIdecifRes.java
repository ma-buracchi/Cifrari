package it.buracchi.cifrari.gui.oneTimePad;

import it.buracchi.cifrari.onetimepad.OneTimePad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class OneTimePadGUIdecifRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OneTimePadGUIdecifRes(String msg, String key) {
		setTitle("ONE-TIME PAD CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMessaggioDecifrato = new JLabel("Messaggio decifrato:");
		lblMessaggioDecifrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioDecifrato.setBounds(10, 11, 414, 14);
		contentPane.add(lblMessaggioDecifrato);
		
		OneTimePad otp = new OneTimePad(msg,key);
		
		JTextArea textPane = new JTextArea();
		textPane.setBounds(10, 36, 414, 214);
		textPane.setLineWrap(true);
		textPane.setText(otp.decoding());
		contentPane.add(textPane);
	}

}
