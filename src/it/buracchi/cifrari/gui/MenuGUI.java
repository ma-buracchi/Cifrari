/*
 *  Created on: July 14, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class MenuGUI {

	private static JFrame frmCifrari;
	private static JPanel menu;
	
	/**
	 * Launch the application.
	 * @param args rappresenta gli input
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCifrari = new JFrame();
					frmCifrari.setTitle("Cifrari by Marco Buracchi");
					frmCifrari.setBounds(100, 100, 700, 550);
					frmCifrari.setLocationRelativeTo(null);
					frmCifrari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					menu = new JPanel();
					menu.setLayout(new GridLayout(0, 2, 0, 0));
					
					JButton btnPolibioCipher = new JButton("Polibio cipher");
					menu.add(btnPolibioCipher);
					btnPolibioCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							PolibioGUI poli = new PolibioGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(poli.getPanel());			
						}
					});
					
					JButton btnShiftCipher = new JButton("Shift cipher");
					menu.add(btnShiftCipher);
					btnShiftCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							ShiftGUI shift = new ShiftGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(shift.getPanel());			
						}
					});
					
					JButton btnSubstitutionCipher = new JButton("Substitution cipher");
					menu.add(btnSubstitutionCipher);
					btnSubstitutionCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							SubstitutionGUI sub = new SubstitutionGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(sub.getPanel());
						}
					});
					
					JButton btnAffineCipher = new JButton("Affine cipher");
					menu.add(btnAffineCipher);
					btnAffineCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							AffineGUI aff = new AffineGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(aff.getPanel());
						}
					});
					
					JButton btnVigenere = new JButton("Vigenere cipher");
					menu.add(btnVigenere);
					btnVigenere.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							VigenereGUI vig = new VigenereGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(vig.getPanel());
						}
					});
					
					JButton btnHill = new JButton("Hill cipher");
					menu.add(btnHill);
					btnHill.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							HillGUI hill = new HillGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(hill.getPanel());
						}
					});
					
					JButton btnPermutationCipher = new JButton("Permutation cipher");
					menu.add(btnPermutationCipher);
					btnPermutationCipher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							PermutationGUI perm = new PermutationGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(perm.getPanel());
						}
					});
					
					JButton btnOnetimePad = new JButton("One-Time Pad cipher");
					menu.add(btnOnetimePad);
					btnOnetimePad.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OneTimePadGUI otp = new OneTimePadGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(otp.getPanel());
						}
					});
					
					JButton btnEnigma = new JButton("Enigma cipher");
					menu.add(btnEnigma);
					btnEnigma.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							EnigmaGUI enigma = new EnigmaGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(enigma.getPanel());
						}
					});
					
					frmCifrari.setContentPane(menu);
					
					JButton btnInfo = new JButton("Info");
					btnInfo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							InfoGUI info = new InfoGUI();
							frmCifrari.getContentPane().setVisible(false);
							frmCifrari.setContentPane(info.getPanel());
						}
					});
					menu.add(btnInfo);
					frmCifrari.setVisible(true);
				}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void reload(){
		frmCifrari.getContentPane().setVisible(false);
		frmCifrari.setContentPane(menu);
		menu.setVisible(true);
	}
}


