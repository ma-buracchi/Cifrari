/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.onetimepad.OneTimePad;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OneTimePadGUI {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public OneTimePadGUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare/decifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 84);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		JTextArea txtrInserireLaChiave = new JTextArea();
		txtrInserireLaChiave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtrInserireLaChiave.setText("");
			}
		});
		txtrInserireLaChiave.setText("Inserire la chiave (in caso di cifratura verrà generata automaticamente)");
		txtrInserireLaChiave.setBounds(10, 105, 414, 84);
		txtrInserireLaChiave.setLineWrap(true);
		contentPane.add(txtrInserireLaChiave);
		
		JButton btnNewButton = new JButton("Cifrare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				OneTimePad otp = new OneTimePad(msg);
				txtpnInserireIlMessaggio.setText(otp.coding());
				txtrInserireLaChiave.setText(otp.printKey());
			}
		});
		btnNewButton.setBounds(10, 200, 202, 20);
		contentPane.add(btnNewButton);
		
		JButton btnTornaAlMenu = new JButton("Torna al menu");
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		btnTornaAlMenu.setBounds(10, 230, 414, 20);
		contentPane.add(btnTornaAlMenu);
		
		JButton btnNewButton_1 = new JButton("Decifrare");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText();
				String key = txtrInserireLaChiave.getText();
				OneTimePad otp = new OneTimePad(msg,key);
				txtpnInserireIlMessaggio.setText(otp.decoding());
			}
		});
		btnNewButton_1.setBounds(222, 200, 202, 20);
		contentPane.add(btnNewButton_1);
	}
	
	public JPanel getPanel(){
		return contentPane;
	}
}
