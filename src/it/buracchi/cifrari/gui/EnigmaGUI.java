/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.enigma.Enigma;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;

public class EnigmaGUI {

	private JPanel contentPane;
	private JTextField txtPlugboard;
	JScrollPane scrollPane = new JScrollPane();
	boolean enabled = true;
	JTextArea txtrInserireMessaggioDa = new JTextArea();
	JPanel panel = new JPanel();
	JComboBox<String> choice = new JComboBox<String>();
	JComboBox<String> choice_1 = new JComboBox<String>();
	JComboBox<String> choice_2 = new JComboBox<String>();
	JComboBox<String> choice_3 = new JComboBox<String>();
	JComboBox<String> choice_4 = new JComboBox<String>();
	JComboBox<String> choice_5 = new JComboBox<String>();
	JButton buttonCifDecif = new JButton("Cifrare/Decifrare");
	JButton btnNewButton_2 = new JButton("Torna al menu");
	private final JSplitPane splitPane = new JSplitPane();
	private final JButton btnIndietro = new JButton("Indietro");
	private final JLabel lblNonSiPu = new JLabel("Non si pu\u00F2 inserire due volte lo stesso rotore");
	private final JRadioButton rdbtnReflectorB = new JRadioButton("Reflector B");
	private final JSplitPane splitPane_1 = new JSplitPane();
	private final JRadioButton rdbtnReflectorC = new JRadioButton("Reflector C");

	/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 383, 286);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 388, 0 };
		gbl_contentPane.rowHeights = new int[] { 168, 0, 0, 0, 0, 30, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		txtrInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtrInserireMessaggioDa.setText("");
			}
		});
		scrollPane.setViewportView(txtrInserireMessaggioDa);
		txtrInserireMessaggioDa.setLineWrap(true);
		txtrInserireMessaggioDa
				.setText("Inserire messaggio da cifrare/decifrare");
		txtrInserireMessaggioDa.setRows(1);

		txtPlugboard = new JTextField();
		txtPlugboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPlugboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (enabled) {
					enabled = false;
					txtPlugboard.setText("abcdefghijklmnopqrstuvwxyz");
				}
			}
		});
		txtPlugboard.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlugboard.setText("Inserire la configurazione della plugboard");
		GridBagConstraints gbc_txtPlugboard = new GridBagConstraints();
		gbc_txtPlugboard.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugboard.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlugboard.gridx = 0;
		gbc_txtPlugboard.gridy = 1;
		contentPane.add(txtPlugboard, gbc_txtPlugboard);
		txtPlugboard.setColumns(10);
		
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.fill = GridBagConstraints.BOTH;
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_1.gridx = 0;
		gbc_splitPane_1.gridy = 2;
		splitPane_1.setEnabled(false);
		splitPane_1.setResizeWeight(0.5);
		contentPane.add(splitPane_1, gbc_splitPane_1);
		rdbtnReflectorB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (rdbtnReflectorC.isSelected()){
					rdbtnReflectorC.setSelected(false);
				}
			}
		});
		rdbtnReflectorB.setHorizontalAlignment(SwingConstants.CENTER);
		
		splitPane_1.setLeftComponent(rdbtnReflectorB);
		rdbtnReflectorC.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (rdbtnReflectorB.isSelected()){
					rdbtnReflectorB.setSelected(false);
				}
			}
		});
		
		rdbtnReflectorC.setHorizontalAlignment(SwingConstants.CENTER);
		
		splitPane_1.setRightComponent(rdbtnReflectorC);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(2, 3, 0, 0));
		
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (choice.getSelectedItem().equals(choice_1.getSelectedItem())
						|| choice.getSelectedItem().equals(choice_2.getSelectedItem())) {
					panel.setVisible(false);
					splitPane.setVisible(true);
				}
			}
		});
		choice.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Rotore veloce", "I", "II", "III", "IV", "V" }));
		panel.add(choice);
		
		choice_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (choice_1.getSelectedItem().equals(choice.getSelectedItem())
						|| choice_1.getSelectedItem().equals(choice_2.getSelectedItem())) {
					panel.setVisible(false);
					splitPane.setVisible(true);
				}
			}
		});
		choice_1.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Rotore medio", "I", "II", "III", "IV", "V" }));
		panel.add(choice_1);

		choice_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (choice_2.getSelectedItem().equals(choice.getSelectedItem())
						|| choice_2.getSelectedItem().equals(choice_1.getSelectedItem())) {
					panel.setVisible(false);
					splitPane.setVisible(true);
				}
			}
		});
		choice_2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Rotore lento", "I", "II", "III", "IV", "V" }));
		panel.add(choice_2);

		
		choice_3.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Posizione partenza", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25" }));
		panel.add(choice_3);

		
		choice_4.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Posizione partenza", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25" }));
		panel.add(choice_4);

		
		choice_5.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Posizione partenza", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25" }));
		panel.add(choice_5);

		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.reload();
			}
		});

		
		buttonCifDecif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = txtrInserireMessaggioDa.getText()
						.replaceAll("[^A-Za-z]", "").toLowerCase();
				String r1 = (String) choice.getSelectedItem();
				String r2 = (String) choice_1.getSelectedItem();
				String r3 = (String) choice_2.getSelectedItem();
				String plug = txtPlugboard.getText();
				int p1 = Integer.parseInt((String) choice_3.getSelectedItem());
				int p2 = Integer.parseInt((String) choice_4.getSelectedItem());
				int p3 = Integer.parseInt((String) choice_5.getSelectedItem());
				String ref = "B";
				if(rdbtnReflectorC.isSelected()){
					ref = "C";
				}
				Enigma enigma = new Enigma(r1, p1, r2, p2, r3, p3, plug, ref);
				txtrInserireMessaggioDa.setText(enigma.code(msg));
			}
		});
		
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 4;
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(0.8);
		contentPane.add(splitPane, gbc_splitPane);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choice.setSelectedIndex(0);
				choice_1.setSelectedIndex(0);
				choice_2.setSelectedIndex(0);
				splitPane.setVisible(false);
				panel.setVisible(true);				
			}
		});
		
		splitPane.setRightComponent(btnIndietro);
		lblNonSiPu.setHorizontalAlignment(SwingConstants.CENTER);
		
		splitPane.setLeftComponent(lblNonSiPu);
		splitPane.setVisible(false);
		
		buttonCifDecif.setActionCommand("");
		GridBagConstraints gbc_buttonCifDecif = new GridBagConstraints();
		gbc_buttonCifDecif.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonCifDecif.insets = new Insets(0, 0, 5, 0);
		gbc_buttonCifDecif.gridx = 0;
		gbc_buttonCifDecif.gridy = 5;
		contentPane.add(buttonCifDecif, gbc_buttonCifDecif);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 6;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
	}

	public JPanel getPanel() {
		return contentPane;
	}
}
