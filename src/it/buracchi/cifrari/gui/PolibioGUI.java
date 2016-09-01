/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.substitution.Polibio;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class PolibioGUI {

	private JPanel contentPane;
	private JTextField txtInserireLeSei;
	private JTextField txtInserireLaPermutazione;

		/**
	 * Create the frame.
	 */
	public PolibioGUI() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 400, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{388, 0};
		gbl_contentPane.rowHeights = new int[]{207, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JTextArea txtrInserireMessaggio = new JTextArea();
		txtrInserireMessaggio.addMouseListener(new MouseAdapter() {
//			@Override
			public void mousePressed(MouseEvent e) {
				txtrInserireMessaggio.setText("");
			}
		});
		scrollPane.setViewportView(txtrInserireMessaggio);
		txtrInserireMessaggio.setLineWrap(true);
		txtrInserireMessaggio.setText("Inserire messaggio da cifrare/decifrare");
		txtrInserireMessaggio.setRows(1);
		
		JButton btnMenu = new JButton("Torna al menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		
		txtInserireLeSei = new JTextField();
		txtInserireLeSei.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLeSei.setText("Inserire le sei lettere da usare per creare la tabella");
		GridBagConstraints gbc_txtInserireLeSei = new GridBagConstraints();
		gbc_txtInserireLeSei.insets = new Insets(0, 0, 5, 0);
		gbc_txtInserireLeSei.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInserireLeSei.gridx = 0;
		gbc_txtInserireLeSei.gridy = 1;
		contentPane.add(txtInserireLeSei, gbc_txtInserireLeSei);
		txtInserireLeSei.setColumns(10);
		txtInserireLeSei.addMouseListener(new MouseAdapter() {
//			@Override
			public void mousePressed(MouseEvent e) {
				txtInserireLeSei.setText("");
			}
		});
		
		txtInserireLaPermutazione = new JTextField();
		txtInserireLaPermutazione.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLaPermutazione.setText("Inserire la permutazione per comporre la tabella");
		GridBagConstraints gbc_txtInserireLaPermutazione = new GridBagConstraints();
		gbc_txtInserireLaPermutazione.insets = new Insets(0, 0, 5, 0);
		gbc_txtInserireLaPermutazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInserireLaPermutazione.gridx = 0;
		gbc_txtInserireLaPermutazione.gridy = 2;
		contentPane.add(txtInserireLaPermutazione, gbc_txtInserireLaPermutazione);
		txtInserireLaPermutazione.setColumns(10);
		txtInserireLaPermutazione.addMouseListener(new MouseAdapter() {
//			@Override
			public void mousePressed(MouseEvent e) {
				txtInserireLaPermutazione.setText("");
			}
		});
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setEnabled(false);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 3;
		contentPane.add(splitPane, gbc_splitPane);
		
		JButton btnCifrare = new JButton("Cifrare");
		splitPane.setLeftComponent(btnCifrare);
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtrInserireMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String head = txtInserireLeSei.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String perm = txtInserireLaPermutazione.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				
				Polibio poli = new Polibio(msg,head,perm);
				txtrInserireMessaggio.setText(poli.coding());
			}
		});
		
		JButton btnDecifrare = new JButton("Decifrare");
		splitPane.setRightComponent(btnDecifrare);
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtrInserireMessaggio.getText();
				String head = txtInserireLeSei.getText();
				String perm = txtInserireLaPermutazione.getText();
				
				Polibio poli = new Polibio(msg,head,perm);
				txtrInserireMessaggio.setText(poli.decoding());
			}
		});
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 4;
		contentPane.add(btnMenu, gbc_btnMenu);
	}
	
	public JPanel getPanel(){
		return contentPane;
	}
}
