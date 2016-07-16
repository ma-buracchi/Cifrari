/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.hill.Hill;
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

public class HillGUI {

	private JPanel contentPane;
	private JTextField txtInserireChiave;
	private JTextField txtInserireDimensioneBlocchi;

		/**
	 * Create the frame.
	 */
	public HillGUI() {
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
		
		txtInserireChiave = new JTextField();
		txtInserireChiave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtInserireChiave.setText("");
			}
		});
		txtInserireChiave.setText("Inserire chiave");
		txtInserireChiave.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_1.setRightComponent(txtInserireChiave);
		txtInserireChiave.setColumns(10);
		
		txtInserireDimensioneBlocchi = new JTextField();
		txtInserireDimensioneBlocchi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtInserireDimensioneBlocchi.setText("");
			}
		});
		txtInserireDimensioneBlocchi.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireDimensioneBlocchi.setText("Inserire dimensione blocchi");
		splitPane_1.setLeftComponent(txtInserireDimensioneBlocchi);
		txtInserireDimensioneBlocchi.setColumns(10);
		
		JButton btnMenu = new JButton("Torna al menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		
		JButton btnCifraredecifrare = new JButton("Cifrare/Decifrare");
		btnCifraredecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m = Integer.parseInt(txtInserireDimensioneBlocchi.getText());
				String msg = txtrInserireMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String k = txtInserireChiave.getText();
				Hill hill = new Hill(m,k,msg);
				txtrInserireMessaggio.setText(hill.coding());
			}
		});
		GridBagConstraints gbc_btnCifraredecifrare = new GridBagConstraints();
		gbc_btnCifraredecifrare.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCifraredecifrare.insets = new Insets(0, 0, 5, 0);
		gbc_btnCifraredecifrare.gridx = 0;
		gbc_btnCifraredecifrare.gridy = 2;
		contentPane.add(btnCifraredecifrare, gbc_btnCifraredecifrare);
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
