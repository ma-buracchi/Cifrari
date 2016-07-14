/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.other.Farfallino;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarfaGUI {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FarfaGUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireMessaggioDa = new JTextArea();
		txtpnInserireMessaggioDa.setBounds(10, 10, 409, 178);
		contentPane.add(txtpnInserireMessaggioDa);
		txtpnInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtpnInserireMessaggioDa.setText("");
			}
		});
		txtpnInserireMessaggioDa.setLineWrap(true);
		txtpnInserireMessaggioDa.setText("Inserire messaggio da cifrare/decifrare");
		
		JButton btnNewButton = new JButton("Cifra");
		btnNewButton.setBounds(10, 193, 197, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				Farfallino f = new Farfallino(msg);
				txtpnInserireMessaggioDa.setText(f.coding());
			}
		});
		
		JButton btnNewButton_1 = new JButton("Decifra");
		btnNewButton_1.setBounds(212, 193, 207, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = txtpnInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				Farfallino f = new Farfallino(msg);
				txtpnInserireMessaggioDa.setText(f.decoding());
			}
		});
		
		JButton btnNewButton_2 = new JButton("Torna al menu");
		btnNewButton_2.setBounds(10, 221, 409, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
	}
	
	public JPanel getPanel(){
		return contentPane;
	}
}
