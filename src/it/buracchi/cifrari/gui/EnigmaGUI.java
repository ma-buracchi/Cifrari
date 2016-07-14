/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.enigma.Enigma;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class EnigmaGUI {

	private JPanel contentPane;
	private String[] rotor = {"I","II","III","IV","V"};

	/**
	 * Create the frame.
	 */
	
	public EnigmaGUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Choice choice = new Choice();
		choice.setBounds(10, 170, 130, 20);
		choice.add("Posizione partenza");
		for(int j = 0; j < 26; j++){
			choice.add(""+j);
		}
		contentPane.setLayout(null);
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(294, 170, 130, 20);
		choice_1.add("Posizione partenza");
		for(int j = 0; j < 26; j++){
			choice_1.add(""+j);
		}
		contentPane.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(153, 170, 130, 20);
		choice_2.add("Posizione partenza");
		for(int j = 0; j < 26; j++){
			choice_2.add(""+j);
		}
		contentPane.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(10, 140, 130, 20);
		choice_3.add("Rotore veloce");
		for(int i = 0; i < rotor.length; i++){
			choice_3.add(rotor[i]);
		}
		contentPane.add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(153, 140, 130, 20);
		choice_4.add("Rotore medio");
		for(int i = 0; i < rotor.length; i++){
			choice_4.add(rotor[i]);
		}
		contentPane.add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(294, 140, 130, 20);
		choice_5.add("Rotore lento");
		for(int i = 0; i < rotor.length; i++){
			choice_5.add(rotor[i]);
		}
		contentPane.add(choice_5);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 119);
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		JButton btnTornaAlMenu = new JButton("Torna al menu");
		btnTornaAlMenu.setBounds(10, 230, 414, 20);
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		contentPane.add(btnTornaAlMenu);
		
		JButton btnCifraredecifrare = new JButton("Cifrare/Decifrare");
		btnCifraredecifrare.setBounds(10, 200, 414, 20);
		btnCifraredecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String r1 = choice_3.getSelectedItem();
				String r2 = choice_4.getSelectedItem();
				String r3 = choice_5.getSelectedItem();
				int p1 = Integer.parseInt(choice.getSelectedItem());
				int p2 = Integer.parseInt(choice_1.getSelectedItem());
				int p3 = Integer.parseInt(choice_2.getSelectedItem());
				Enigma enigma = new Enigma(r1,p1,r2,p2,r3,p3);
				txtpnInserireIlMessaggio.setText(enigma.code(msg));
			}
		});
		contentPane.add(btnCifraredecifrare);
	}
	
	public JPanel getPanel(){
		return contentPane;
	}

}
