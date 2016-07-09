package it.buracchi.cifrari.gui.permutation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PermutationGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCodifica = new JButton("Codifica");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PermutationGUIcodifica anw = new PermutationGUIcodifica();
				anw.setVisible(true);
			}
		});
		contentPane.add(btnCodifica);
		
		JButton btnDecodifica = new JButton("Decodifica");
		btnDecodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PermutationGUIdecodifica anw = new PermutationGUIdecodifica();
				anw.setVisible(true);
			}
		});
		contentPane.add(btnDecodifica);
	}
}
