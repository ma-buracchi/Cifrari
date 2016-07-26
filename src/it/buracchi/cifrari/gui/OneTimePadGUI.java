/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.onetimepad.OneTimePad;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class OneTimePadGUI {

	private JPanel contentPane;

		/**
	 * Create the frame.
	 */
	public OneTimePadGUI() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 400, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{388, 0};
		gbl_contentPane.rowHeights = new int[]{211, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.5);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		JTextArea txtrInserireLaChiave = new JTextArea();
		txtrInserireLaChiave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtrInserireLaChiave.setText("");
			}
		});
		txtrInserireLaChiave.setLineWrap(true);
		txtrInserireLaChiave.setText("Inserire la chiave (in caso di cifratura verr\u00E0 generata automaticamente)");
		scrollPane_1.setViewportView(txtrInserireLaChiave);
		
		JButton btnMenu = new JButton("Torna al menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setEnabled(false);
		splitPane_1.setResizeWeight(0.5);
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_1.fill = GridBagConstraints.BOTH;
		gbc_splitPane_1.gridx = 0;
		gbc_splitPane_1.gridy = 1;
		contentPane.add(splitPane_1, gbc_splitPane_1);
		
		JButton btnCifrare = new JButton("Cifrare");
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtrInserireMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				OneTimePad otp = new OneTimePad(msg);
				txtrInserireMessaggio.setText(otp.coding());
				txtrInserireLaChiave.setText(otp.printKey());
			}
		});
		splitPane_1.setLeftComponent(btnCifrare);
		
		JButton btnDecifrare = new JButton("Decifrare");
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtrInserireMessaggio.getText();
				String key = txtrInserireLaChiave.getText();
				OneTimePad otp = new OneTimePad(msg,key);
				txtrInserireMessaggio.setText(otp.decoding());
			}
		});
		splitPane_1.setRightComponent(btnDecifrare);
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 2;
		contentPane.add(btnMenu, gbc_btnMenu);
	}
	
	public JPanel getPanel(){
		return contentPane;
	}
}
