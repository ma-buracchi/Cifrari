/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.substitution.Substitution;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SubstitutionGUI {

	private JPanel contentPane;
	private JTextField txtInserireLaPermutazione;

	/**
	 * Create the frame.
	 */
	public SubstitutionGUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare/decifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 149);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		txtInserireLaPermutazione = new JTextField();
		txtInserireLaPermutazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtInserireLaPermutazione.setText("");
			}
		});
		txtInserireLaPermutazione.setBounds(10, 170, 414, 20);
		txtInserireLaPermutazione.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLaPermutazione.setText("Inserire la permutazione dell'alfabeto che si vuole utilizzare");
		contentPane.add(txtInserireLaPermutazione);
		txtInserireLaPermutazione.setColumns(10);
		
		JButton btnCifrare = new JButton("Cifrare");
		btnCifrare.setBounds(10, 200, 202, 20);
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String perm = txtInserireLaPermutazione.getText();
				Substitution nw = new Substitution(perm,msg);
				txtpnInserireIlMessaggio.setText(nw.coding());
			}
		});
		contentPane.add(btnCifrare);
		
		JButton btnTornaAlMenu = new JButton("Torna al menu");
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		btnTornaAlMenu.setBounds(10, 230, 414, 20);
		contentPane.add(btnTornaAlMenu);
		
		JButton btnDecifrare = new JButton("Decifrare");
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText();
				String perm = txtInserireLaPermutazione.getText();
				Substitution nw = new Substitution(perm,msg);
				txtpnInserireIlMessaggio.setText(nw.decoding());
			}
		});
		btnDecifrare.setBounds(222, 200, 202, 20);
		contentPane.add(btnDecifrare);

	}
	
	public JPanel getPanel(){
		return contentPane;
	}

}
