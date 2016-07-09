package it.buracchi.cifrari.gui.substitution;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubstitutionGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public SubstitutionGUI() {
		setTitle("SUBSTITUTION CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCodifica = new JButton("Codifica");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubstitutionGUIcodifica nw = new SubstitutionGUIcodifica();
				dispose();
				nw.setVisible(true);
			}
		});
		panel.add(btnCodifica);
		
		JButton btnDecodifica = new JButton("Decodifica");
		btnDecodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubstitutionGUIdecodifica nw = new SubstitutionGUIdecodifica();
				panel.setVisible(false);
				nw.setVisible(true);
			}
		});
		panel.add(btnDecodifica);
	}
}
