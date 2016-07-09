package it.buracchi.cifrari.gui.affine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AffineGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public AffineGUI() {
		setTitle("AFFINE CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCodifica = new JButton("Codifica");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AffineGUIcodifica anw = new AffineGUIcodifica();
				anw.setVisible(true);
			}
		});
		contentPane.add(btnCodifica);
		
		JButton btnDecodifica = new JButton("Decodifica");
		btnDecodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AffineGUIdecodifica anw = new AffineGUIdecodifica();
				anw.setVisible(true);
			}
		});
		contentPane.add(btnDecodifica);
	}
}
