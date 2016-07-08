package it.buracchi.cifrari.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarfaGUIdecif extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FarfaGUIdecif() {
		setTitle("FARFALLINO CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnInserireMessaggioDa = new JTextPane();
		txtpnInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtpnInserireMessaggioDa.setText("");
			}
		});
		txtpnInserireMessaggioDa.setBounds(5, 5, 424, 211);
		txtpnInserireMessaggioDa.setText("Inserire messaggio da decifrare");
		contentPane.add(txtpnInserireMessaggioDa);
		
		JButton btnNewButton = new JButton("Decodifica");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String msg = txtpnInserireMessaggioDa.getText().replace(" ", "");
				FarfaGUIdecifRes fres = new FarfaGUIdecifRes(msg);
				fres.setVisible(true);
			}
		});
		btnNewButton.setBounds(5, 227, 419, 23);
		contentPane.add(btnNewButton);
	}
}
