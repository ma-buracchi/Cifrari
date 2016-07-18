/*
 *  Created on: July 16, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class InfoGUI {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InfoGUI() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 400, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 388, 0 };
		gbl_contentPane.rowHeights = new int[] { 211, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		JTextArea txtrInserireMessaggio = new JTextArea();
		txtrInserireMessaggio.setWrapStyleWord(true);
		txtrInserireMessaggio.setEditable(false);
		scrollPane.setViewportView(txtrInserireMessaggio);
		txtrInserireMessaggio.setLineWrap(true);
		txtrInserireMessaggio
				.setText("Cifrari 2.5.2\r\nCreated by Marco Buracchi\r\n\r\nImplementazioni di alcuni dei pi\u00F9 famosi cifrari a chiave condivisa\r\n\r\n1) Shift cipher:\r\n- Ogni lettera del messaggio da cifrare/decifrare verr\u00E0 spostata in avanti/indietro del numero di posizioni desiderato (3 \u00E8 il valore con il quale \u00E8 impostato lo storico cifrario di Giulio Cesare)\r\n\r\n2) Substitution cipher:\r\n- Ogni lettera del messaggio da cifrare/decifrare verr\u00E0 sostituita con la corrispondente lettera nella permutazione indicata\r\n\r\n3) Affine cipher:\r\n- Ogni lettera (x) del messaggio da cifrare/decifrare verr\u00E0 cifrata come c(x) = (ax + b) mod 26 utilizzando i coefficienti selezionati\r\n\r\n4) Vigenere:\r\n- Ogni lettera del messaggio da cifrare/decifrare verr\u00E0 cifrata utilizzando la chiave inserita, secondo il cifrario di Vigenere\r\n\r\n5) Hill:\r\n- Il messaggio da cifrare/decifrare verr\u00E0 cifrato secondo il cifrario di Hill utilizzando le matrici selezionate dall'utente. Possono essere create ed utilizzate nuove matrici (solo di interi) che possono essere salvate nella cartella Key.\r\n\r\n6) Permutation cipher:\r\n- Ogni blocco del messaggio di grandezza m (max 10, selezionata dall'utente) verr\u00E0 cifrato utilizzando la permutazione di interi (da 0 a m-1) inserita.\r\n\r\n7) One-Time Pad:\r\n- In caso di cifratura, il messaggio verr\u00E0 cifrato secondo il cifrario One-Time Pad e verr\u00E0 fornita la relativa chiave di decifratura\r\n- In caso di decifratura, il messaggio verr\u00E0 decifrato secondo il cifrario One-Time Pad, utilizzando la chiave inserita\r\n\r\n8) ENIGMA:\r\n- Il messaggio da cifrare/decifrare verr\u00E0 cifrato/decifrato secondo il cifrario ENIGMA utilizzando la configurazione dei rotori selezionata dall'utente.\r\n\r\n9) ?????????\r\n\r\n");
		txtrInserireMessaggio.setRows(1);

		JButton btnMenu = new JButton("Torna al menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 1;
		contentPane.add(btnMenu, gbc_btnMenu);
	}

	public JPanel getPanel() {
		return contentPane;
	}
}
