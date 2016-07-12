package it.buracchi.cifrari.gui.oneTimePad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OneTimePadGUIcif extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public OneTimePadGUIcif() {
		setTitle("ONE-TIME PAD CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 205);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		JButton btnNewButton = new JButton("Cifrare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				dispose();
				OneTimePadGUIcifRes otp = new OneTimePadGUIcifRes(msg);
				otp.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 227, 414, 23);
		contentPane.add(btnNewButton);
	}

}
