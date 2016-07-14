/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.substitution.Affine;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Choice;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AffineGUI {

	private JPanel contentPane;
	private JTextField txtInserireParametrob;
	private String[] ch = {"1","3","5","7","9","11","15","17","19","21","23","25"};

		/**
	 * Create the frame.
	 */
	public AffineGUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireMessaggioDa = new JTextArea();
		txtpnInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtpnInserireMessaggioDa.setText("");
			}
		});
		txtpnInserireMessaggioDa.setText("Inserire messaggio da cifrare/decifrare");
		txtpnInserireMessaggioDa.setBounds(10, 11, 414, 148);
		txtpnInserireMessaggioDa.setLineWrap(true);
		contentPane.add(txtpnInserireMessaggioDa);
		
		Choice choice = new Choice();
		choice.add("Coefficiente a (coprimo con 26)");
		for(int i = 0; i < ch.length; i++){
			choice.add(ch[i]);
		}
		choice.setBounds(10, 170, 202, 20);
		contentPane.add(choice);
		
		txtInserireParametrob = new JTextField();
		txtInserireParametrob.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtInserireParametrob.setText("");
			}
		});
		txtInserireParametrob.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireParametrob.setText("Coefficiente b");
		txtInserireParametrob.setBounds(222, 170, 202, 20);
		contentPane.add(txtInserireParametrob);
		txtInserireParametrob.setColumns(10);
		
		JButton btnCodifica = new JButton("Cifra");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int a = Integer.parseInt(choice.getSelectedItem());
				int b = Integer.parseInt(txtInserireParametrob.getText());
				Affine aff = new Affine(msg,a,b);
				txtpnInserireMessaggioDa.setText(aff.coding());
			}
		});
		btnCodifica.setBounds(10, 200, 202, 20);
		contentPane.add(btnCodifica);
		
		JButton btnDecifra = new JButton("Decifra");
		btnDecifra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = txtpnInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int a = Integer.parseInt(choice.getSelectedItem());
				int b = Integer.parseInt(txtInserireParametrob.getText());
				Affine aff = new Affine(msg,a,b);
				txtpnInserireMessaggioDa.setText(aff.decoding());
			}
		});
		btnDecifra.setBounds(222, 200, 202, 20);
		contentPane.add(btnDecifra);
		
		JButton btnNewButton = new JButton("Torna al menu");
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
