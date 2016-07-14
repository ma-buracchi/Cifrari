/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.hill.Hill;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HillGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireChiave;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	
	public HillGUI() {
		setTitle("HILL CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireMessaggioDa = new JTextArea();
		txtpnInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireMessaggioDa.setText("");
			}
		});
		txtpnInserireMessaggioDa.setText("Inserire messaggio da cifrare/decifrare");
		txtpnInserireMessaggioDa.setBounds(10, 11, 414, 149);
		txtpnInserireMessaggioDa.setLineWrap(true);
		contentPane.add(txtpnInserireMessaggioDa);
		
		txtInserireChiave = new JTextField();
		txtInserireChiave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserireChiave.setText("");
			}
		});
		txtInserireChiave.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireChiave.setText("Inserire dimensione blocchi");
		txtInserireChiave.setBounds(10, 170, 200, 20);
		contentPane.add(txtInserireChiave);
		txtInserireChiave.setColumns(10);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setText("Inserire chiave");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(224, 170, 200, 20);
		contentPane.add(textField);
		
		JButton btnCodificadecodifica = new JButton("Cifra/Decifra");
		btnCodificadecodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m = Integer.parseInt(txtInserireChiave.getText());
				String msg = txtpnInserireMessaggioDa.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String k = textField.getText();
				Hill hill = new Hill(m,k,msg);
				txtpnInserireMessaggioDa.setText(hill.coding());
			}
		});
		btnCodificadecodifica.setBounds(10, 200, 414, 20);
		contentPane.add(btnCodificadecodifica);
		
		btnNewButton = new JButton("Torna al menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 230, 414, 20);
		contentPane.add(btnNewButton);
	}

}
