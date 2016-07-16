/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.hill.Permutation;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class PermutationGUI {

	private JPanel contentPane;
	private JTextField txtPermutazione;
	private JTextField txtLunghezzaDeiBlocchi;

		/**
	 * Create the frame.
	 */
	public PermutationGUI() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 400, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{388, 0};
		gbl_contentPane.rowHeights = new int[]{211, 0, 0, 0, 0};
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
		
		JTextArea txtrInserireMessaggio = new JTextArea();
		txtrInserireMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtrInserireMessaggio.setText("");
			}
		});
		scrollPane.setViewportView(txtrInserireMessaggio);
		txtrInserireMessaggio.setLineWrap(true);
		txtrInserireMessaggio.setText("Inserire messaggio da cifrare/decifrare");
		txtrInserireMessaggio.setRows(1);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_1.fill = GridBagConstraints.BOTH;
		gbc_splitPane_1.gridx = 0;
		gbc_splitPane_1.gridy = 1;
		contentPane.add(splitPane_1, gbc_splitPane_1);
		
		txtPermutazione = new JTextField();
		txtPermutazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtPermutazione.setText("");
			}
		});
		txtPermutazione.setText("Permutazione di interi (0..m-1)");
		txtPermutazione.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_1.setRightComponent(txtPermutazione);
		txtPermutazione.setColumns(10);
		
		txtLunghezzaDeiBlocchi = new JTextField();
		txtLunghezzaDeiBlocchi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtLunghezzaDeiBlocchi.setText("");
			}
		});
		txtLunghezzaDeiBlocchi.setHorizontalAlignment(SwingConstants.CENTER);
		txtLunghezzaDeiBlocchi.setText("Lunghezza dei blocchi m (max 10)");
		splitPane_1.setLeftComponent(txtLunghezzaDeiBlocchi);
		txtLunghezzaDeiBlocchi.setColumns(10);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 2;
		contentPane.add(splitPane, gbc_splitPane);
		
		JButton btnCifrare = new JButton("Cifrare");
		splitPane.setLeftComponent(btnCifrare);
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtrInserireMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int m = Integer.parseInt(txtLunghezzaDeiBlocchi.getText());
				String perm = txtPermutazione.getText();
				Permutation pe = new Permutation(m,perm,msg);
				txtrInserireMessaggio.setText(pe.coding());	
			}
		});
		
		JButton btnDecifrare = new JButton("Decifrare");
		splitPane.setRightComponent(btnDecifrare);
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtrInserireMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int m = Integer.parseInt(txtLunghezzaDeiBlocchi.getText());
				String perm = txtPermutazione.getText();
				Permutation pe = new Permutation(m,perm,msg);
				txtrInserireMessaggio.setText(pe.decoding());	
			}
		});
		
		JButton btnMenu = new JButton("Torna al menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 3;
		contentPane.add(btnMenu, gbc_btnMenu);
	}
	
	public JPanel getPanel(){
		return contentPane;
	}
}
