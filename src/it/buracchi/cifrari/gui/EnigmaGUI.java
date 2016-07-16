/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.enigma.Enigma;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Button;

public class EnigmaGUI {

	private JPanel contentPane;
	private String[] rotor = {"I","II","III","IV","V"};

		/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 400, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{388, 0};
		gbl_contentPane.rowHeights = new int[]{168, 0, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JTextArea txtrInserireMessaggioDa = new JTextArea();
		txtrInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtrInserireMessaggioDa.setText("");
			}
		});
		scrollPane.setViewportView(txtrInserireMessaggioDa);
		txtrInserireMessaggioDa.setLineWrap(true);
		txtrInserireMessaggioDa.setText("Inserire messaggio da cifrare/decifrare");
		txtrInserireMessaggioDa.setRows(1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(2, 3, 0, 0));
		
		Choice choice = new Choice();
		choice.add("Rotore veloce");
		panel.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.add("Rotore medio");
		panel.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.add("Rotore lento");
		panel.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.add("Posizione partenza");
		panel.add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.add("Posizione partenza");
		panel.add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.add("Posizione partenza");
		panel.add(choice_5);
		
		for(int i = 0; i < rotor.length; i++){
			choice.add(rotor[i]);
			choice_1.add(rotor[i]);
			choice_2.add(rotor[i]);
		}
		
		for(int j = 0; j < 26; j++){
			choice_3.add(""+j);
			choice_4.add(""+j);
			choice_5.add(""+j);
		}
		
		JButton btnNewButton_2 = new JButton("Torna al menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		
		Button button = new Button("Cifra/Decifra");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = txtrInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String r1 = choice.getSelectedItem();
				String r2 = choice_1.getSelectedItem();
				String r3 = choice_2.getSelectedItem();
				int p1 = Integer.parseInt(choice_3.getSelectedItem());
				int p2 = Integer.parseInt(choice_4.getSelectedItem());
				int p3 = Integer.parseInt(choice_5.getSelectedItem());
				Enigma enigma = new Enigma(r1,p1,r2,p2,r3,p3);
				txtrInserireMessaggioDa.setText(enigma.code(msg));
			}
		});
		button.setActionCommand("");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 2;
		contentPane.add(button, gbc_button);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
	}
	
	public JPanel getPanel(){
		return contentPane;
	}
}
