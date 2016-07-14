/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.vigenere.Vigenere;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VigenereGUI {

	private JPanel contentPane;
	private JTextField txtInserireLaChiave;
	private JButton btnDecifrare;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	
	public VigenereGUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		txtInserireLaChiave = new JTextField();
		txtInserireLaChiave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserireLaChiave.setText("");
			}
		});
		txtInserireLaChiave.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLaChiave.setText("Inserire la chiave");
		txtInserireLaChiave.setBounds(10, 170, 414, 20);
		contentPane.add(txtInserireLaChiave);
		txtInserireLaChiave.setColumns(10);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare/decifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 149);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		JButton btnCodifica = new JButton("Cifrare");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String key = txtInserireLaChiave.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				Vigenere vgn = new Vigenere(msg,key);
				txtpnInserireIlMessaggio.setText(vgn.coding());
			}
		});
		btnCodifica.setBounds(10, 200, 202, 20);
		contentPane.add(btnCodifica);
		
		btnDecifrare = new JButton("Decifrare");
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String key = txtInserireLaChiave.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				Vigenere vgn = new Vigenere(msg,key);
				txtpnInserireIlMessaggio.setText(vgn.decoding());
			}
		});
		btnDecifrare.setBounds(222, 200, 202, 20);
		contentPane.add(btnDecifrare);
		
		btnNewButton = new JButton("Torna al menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		btnNewButton.setBounds(10, 230, 414, 20);
		contentPane.add(btnNewButton);
	}
	
	public JPanel getPanel(){
		return contentPane;
	}

}
