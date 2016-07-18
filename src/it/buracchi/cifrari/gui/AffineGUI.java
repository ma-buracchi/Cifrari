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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class AffineGUI {

	private JPanel contentPane;
	private String[] ch = {"Scegliere coefficiente a","1","3","5","7","9","11","15","17","19","21","23","25"};
	private JTextField txtCoefficienteB;
	/**
	 * Create the frame.
	 */
	public AffineGUI() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 437, 345);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{388, 0};
		gbl_contentPane.rowHeights = new int[] {211, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0};
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
			//@Override
			public void mousePressed(MouseEvent e) {
				txtrInserireMessaggioDa.setText("");
			}
		});
		scrollPane.setViewportView(txtrInserireMessaggioDa);
		txtrInserireMessaggioDa.setLineWrap(true);
		txtrInserireMessaggioDa.setText("Inserire messaggio da cifrare/decifrare");
		txtrInserireMessaggioDa.setRows(1);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_splitPane_1.gridx = 0;
		gbc_splitPane_1.gridy = 1;
		contentPane.add(splitPane_1, gbc_splitPane_1);
		
		txtCoefficienteB = new JTextField();
		txtCoefficienteB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtCoefficienteB.setText("");
			}
		});
		txtCoefficienteB.setText("Coefficiente b");
		txtCoefficienteB.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_1.setRightComponent(txtCoefficienteB);
		txtCoefficienteB.setColumns(10);
		
		Choice choice = new Choice();
		splitPane_1.setLeftComponent(choice);
		for(int i = 0; i < ch.length; i++){
			choice.add(ch[i]);
		}
		
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
				String msg = txtrInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int a = Integer.parseInt(choice.getSelectedItem());
				int b = Integer.parseInt(txtCoefficienteB.getText());
				Affine aff = new Affine(msg,a,b);
				txtrInserireMessaggioDa.setText(aff.coding());
			}
		});
		
		JButton btnDecifrare = new JButton("Decifrare");
		splitPane.setRightComponent(btnDecifrare);
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtrInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int a = Integer.parseInt(choice.getSelectedItem());
				int b = Integer.parseInt(txtCoefficienteB.getText());
				Affine aff = new Affine(msg,a,b);
				txtrInserireMessaggioDa.setText(aff.decoding());
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
