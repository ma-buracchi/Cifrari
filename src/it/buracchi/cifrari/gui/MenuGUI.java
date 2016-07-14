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

public class MenuGUI {

	private JFrame frmCifrari;
	private JButton btnHill;
	private JButton btnVigenere;
	private JButton btnEnigma;
	private JButton btnShiftCipher;
	private JButton btnSubstituionCipher;
	private JButton btnAffineCipher;
	private JButton btnPermutationCipher;
	private JButton btnOnetimePad;
	private JLabel lblSelezionareIlCifrario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI window = new MenuGUI();
					window.frmCifrari.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCifrari = new JFrame();
		frmCifrari.setTitle("Cifrari");
		frmCifrari.setBounds(100, 100, 450, 300);
		frmCifrari.setLocationRelativeTo(null);
		frmCifrari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCifrari.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		lblSelezionareIlCifrario = new JLabel("Selezionare il cifrario che si vuole utilizzare");
		lblSelezionareIlCifrario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmCifrari.dispose();
				FarfaGUIcif farfa = new FarfaGUIcif();
				farfa.setVisible(true);
			}
		});
		lblSelezionareIlCifrario.setHorizontalAlignment(SwingConstants.CENTER);
		frmCifrari.getContentPane().add(lblSelezionareIlCifrario);
		
		btnHill = new JButton("Hill cipher");
		btnHill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCifrari.dispose();
				HillGUI hill = new HillGUI();
				hill.setVisible(true);
			}
		});
		
		btnShiftCipher = new JButton("Shift cipher");
		btnShiftCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCifrari.dispose();
				ShiftGUI sg = new ShiftGUI();
				sg.setVisible(true);
			}
		});
		frmCifrari.getContentPane().add(btnShiftCipher);
		
		btnSubstituionCipher = new JButton("Substitution cipher");
		btnSubstituionCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCifrari.dispose();
				SubstitutionGUI sub = new SubstitutionGUI();
				sub.setVisible(true);
			}
		});
		frmCifrari.getContentPane().add(btnSubstituionCipher);
		
		btnAffineCipher = new JButton("Affine cipher");
		btnAffineCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCifrari.dispose();
				AffineGUI aff = new AffineGUI();
				aff.setVisible(true);
			}
		});
		frmCifrari.getContentPane().add(btnAffineCipher);
		
		btnVigenere = new JButton("Vigenere cipher");
		btnVigenere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCifrari.dispose();
				VigenereGUI vig = new VigenereGUI();
				vig.setVisible(true);
			}
		});
		frmCifrari.getContentPane().add(btnVigenere);
		frmCifrari.getContentPane().add(btnHill);
		
		btnPermutationCipher = new JButton("Permutation cipher");
		btnPermutationCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCifrari.dispose();
				PermutationGUI perm = new PermutationGUI();
				perm.setVisible(true);
			}
		});
		frmCifrari.getContentPane().add(btnPermutationCipher);
		
		btnEnigma = new JButton("Enigma cipher");
		btnEnigma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCifrari.dispose();
				EnigmaGUI eng = new EnigmaGUI();
				eng.setVisible(true);
			}
		});
		
		btnOnetimePad = new JButton("One-Time Pad cipher");
		btnOnetimePad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCifrari.dispose();
				OneTimePadGUI otp = new OneTimePadGUI();
				otp.setVisible(true);
			}
		});
		frmCifrari.getContentPane().add(btnOnetimePad);
		frmCifrari.getContentPane().add(btnEnigma);
	}
}


