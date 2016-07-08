package it.buracchi.cifrari.gui.oneTimePad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OneTimePadGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OneTimePadGUI() {
		setTitle("ONE-TIME PAD CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCifrare = new JButton("Cifrare");
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OneTimePadGUIcif otp = new OneTimePadGUIcif();
				otp.setVisible(true);
			}
		});
		contentPane.add(btnCifrare);
		
		JButton btnDecifrare = new JButton("Decifrare");
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OneTimePadGUIdecif otp = new OneTimePadGUIdecif();
				otp.setVisible(true);
			}
		});
		contentPane.add(btnDecifrare);
	}

}
