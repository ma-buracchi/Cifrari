/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.substitution.Shift;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShiftGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public ShiftGUI() {
		setTitle("SHIFT CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare/decifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 149);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		Choice choice = new Choice();
		choice.setBounds(10, 170, 414, 20);
		choice.add("Selezionare il numero di posizioni di shifting");
		for(int i = 1; i < 26; i++){
			choice.add(""+i);
		}
		contentPane.add(choice);
		
		JButton btnCifrare = new JButton("Cifrare");
		btnCifrare.setBounds(10, 200, 202, 20);
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int shift = choice.getSelectedIndex();
				Shift nw = new Shift(msg,shift);
				txtpnInserireIlMessaggio.setText(nw.coding());
			}
		});
		contentPane.add(btnCifrare);
		
		JButton btnDecifrare = new JButton("Decifrare");
		btnDecifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText();
				int shift = choice.getSelectedIndex();
				Shift nw = new Shift(msg,shift);
				txtpnInserireIlMessaggio.setText(nw.decoding());
			}
		});
		btnDecifrare.setBounds(222, 200, 202, 20);
		contentPane.add(btnDecifrare);
		
		JButton btnNewButton = new JButton("Torna al menu");
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
