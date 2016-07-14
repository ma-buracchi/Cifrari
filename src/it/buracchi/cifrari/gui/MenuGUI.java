/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MenuGUI {

	private static JFrame frmCifrari;
	private static JButton btnHill;
	private static JButton btnVigenere;
	private static JButton btnEnigma;
	private static JButton btnShiftCipher;
	private static JButton btnSubstitutionCipher;
	private static JButton btnAffineCipher;
	private static JButton btnPermutationCipher;
	private static JButton btnOnetimePad;
	private static JLabel lblSelezionareIlCifrario;
	private static JPanel menu;
	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCifrari = new JFrame();
					frmCifrari.setTitle("Cifrari");
					frmCifrari.setBounds(100, 100, 450, 300);
					frmCifrari.setLocationRelativeTo(null);
					frmCifrari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					menu = new JPanel();
					menu.setLayout(new GridLayout(0, 1, 0, 0));
					
					lblSelezionareIlCifrario = new JLabel("Selezionare il cifrario che si vuole utilizzare");
					menu.add(lblSelezionareIlCifrario);
					lblSelezionareIlCifrario.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							FarfaGUI farfa = new FarfaGUI();
							contentPane = farfa.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					lblSelezionareIlCifrario.setHorizontalAlignment(SwingConstants.CENTER);
					
					btnShiftCipher = new JButton("Shift cipher");
					menu.add(btnShiftCipher);
					btnShiftCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							ShiftGUI shift = new ShiftGUI();
							contentPane = shift.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);				
						}
					});
					
					btnSubstitutionCipher = new JButton("Substitution cipher");
					menu.add(btnSubstitutionCipher);
					btnSubstitutionCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							SubstitutionGUI sub = new SubstitutionGUI();
							contentPane = sub.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					
					btnAffineCipher = new JButton("Affine cipher");
					menu.add(btnAffineCipher);
					btnAffineCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							AffineGUI aff = new AffineGUI();
							contentPane = aff.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					
					btnVigenere = new JButton("Vigenere cipher");
					menu.add(btnVigenere);
					btnVigenere.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							VigenereGUI vig = new VigenereGUI();
							contentPane = vig.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					
					btnHill = new JButton("Hill cipher");
					menu.add(btnHill);
					btnHill.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							HillGUI hill = new HillGUI();
							contentPane = hill.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					
					btnPermutationCipher = new JButton("Permutation cipher");
					menu.add(btnPermutationCipher);
					btnPermutationCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							PermutationGUI perm = new PermutationGUI();
							contentPane = perm.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					
					btnOnetimePad = new JButton("One-Time Pad cipher");
					menu.add(btnOnetimePad);
					btnOnetimePad.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OneTimePadGUI otp = new OneTimePadGUI();
							contentPane = otp.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					
					btnEnigma = new JButton("Enigma cipher");
					menu.add(btnEnigma);
					btnEnigma.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							EnigmaGUI enigma = new EnigmaGUI();
							contentPane = enigma.getPanel();
							frmCifrari.setContentPane(contentPane);
							contentPane.setVisible(true);
						}
					});
					frmCifrari.setContentPane(menu);
					frmCifrari.setVisible(true);
				}
				
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void reload(){
		frmCifrari.setContentPane(menu);
		menu.setVisible(true);
		contentPane.setVisible(false);
	}
}


