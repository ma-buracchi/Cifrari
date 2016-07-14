/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import it.buracchi.cifrari.hill.Permutation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PermutationGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireLunghezzaDei;
	private JTextField txtInserirePermutazioneInteri;
	private JButton btnTornaAlMenu;
	private JButton btnDecifra;

	/**
	 * Create the frame.
	 */
	
	public PermutationGUI() {
		setTitle("PERMUTATION CIPHER");
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
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 149);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		txtInserireLunghezzaDei = new JTextField();
		txtInserireLunghezzaDei.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserireLunghezzaDei.setText("");
			}
		});
		txtInserireLunghezzaDei.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLunghezzaDei.setText("Lunghezza dei blocchi (max 10)");
		txtInserireLunghezzaDei.setBounds(10, 170, 200, 20);
		contentPane.add(txtInserireLunghezzaDei);
		txtInserireLunghezzaDei.setColumns(10);
		
		txtInserirePermutazioneInteri = new JTextField();
		txtInserirePermutazioneInteri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserirePermutazioneInteri.setText("");
			}
		});
		txtInserirePermutazioneInteri.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserirePermutazioneInteri.setText("Inserire permutazione interi");
		txtInserirePermutazioneInteri.setColumns(10);
		txtInserirePermutazioneInteri.setBounds(224, 170, 200, 20);
		contentPane.add(txtInserirePermutazioneInteri);
		
		JButton btnCodifica = new JButton("Cifrare");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				int m = Integer.parseInt(txtInserireLunghezzaDei.getText());
				String perm = txtInserirePermutazioneInteri.getText();
				Permutation pe = new Permutation(m,perm,msg);
				txtpnInserireIlMessaggio.setText(pe.coding());				
			}
		});
		btnCodifica.setBounds(10, 200, 202, 20);
		contentPane.add(btnCodifica);
		
		btnTornaAlMenu = new JButton("Torna al menu");
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI.main(null);
				dispose();
			}
		});
		btnTornaAlMenu.setBounds(10, 230, 414, 20);
		contentPane.add(btnTornaAlMenu);
		
		btnDecifra = new JButton("Decifrare");
		btnDecifra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText();
				int m = Integer.parseInt(txtInserireLunghezzaDei.getText());
				String perm = txtInserirePermutazioneInteri.getText();
				Permutation pe = new Permutation(m,perm,msg);
				txtpnInserireIlMessaggio.setText(pe.decoding());
			}
		});
		btnDecifra.setBounds(222, 200, 202, 20);
		contentPane.add(btnDecifra);
	}

}
