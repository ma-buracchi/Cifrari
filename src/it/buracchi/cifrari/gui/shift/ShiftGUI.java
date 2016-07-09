package it.buracchi.cifrari.gui.shift;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShiftGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private JButton btnCodifica = new JButton("Codifica");
	private JButton btnDecodifica = new JButton("Decodifica");

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
		
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShiftGUIcodifica nw = new ShiftGUIcodifica();
				dispose();
				nw.setVisible(true);
			}
		});
		panel.add(btnCodifica);
		
		btnDecodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShiftGUIdecodifica nw = new ShiftGUIdecodifica();
				dispose();
				nw.setVisible(true);
			}
		});
		panel.add(btnDecodifica);
	}
}
