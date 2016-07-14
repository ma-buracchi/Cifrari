/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.other.Farfallino;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarfaGUIcif extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FarfaGUIcif() {
		setTitle("FARFALLINO CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireMessaggioDa = new JTextArea();
		txtpnInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtpnInserireMessaggioDa.setText("");
			}
		});
		txtpnInserireMessaggioDa.setBounds(10, 11, 414, 179);
		txtpnInserireMessaggioDa.setLineWrap(true);
		txtpnInserireMessaggioDa.setText("Inserire messaggio da cifrare/decifrare");
		contentPane.add(txtpnInserireMessaggioDa);
		
		JButton btnNewButton = new JButton("Cifra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				Farfallino f = new Farfallino(msg);
				txtpnInserireMessaggioDa.setText(f.coding());
			}
		});
		btnNewButton.setBounds(10, 200, 202, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decifra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = txtpnInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				Farfallino f = new Farfallino(msg);
				txtpnInserireMessaggioDa.setText(f.decoding());
			}
		});
		btnNewButton_1.setBounds(222, 200, 202, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Torna al menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.main(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 230, 414, 20);
		contentPane.add(btnNewButton_2);
	}
}
