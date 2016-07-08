package it.buracchi.cifrari.gui.hill;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
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

	/**
	 * Create the frame.
	 */
	
	public HillGUI() {
		setTitle("HILL CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnInserireMessaggioDa = new JTextPane();
		txtpnInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireMessaggioDa.setText("");
			}
		});
		txtpnInserireMessaggioDa.setText("Inserire messaggio da cifrare/decifrare");
		txtpnInserireMessaggioDa.setBounds(10, 11, 414, 174);
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
		txtInserireChiave.setBounds(10, 196, 200, 20);
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
		textField.setBounds(224, 196, 200, 20);
		contentPane.add(textField);
		
		JButton btnCodificadecodifica = new JButton("Codifica/decodifica");
		btnCodificadecodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m = Integer.parseInt(txtInserireChiave.getText());
				String msg = txtpnInserireMessaggioDa.getText().replace(" ", "");
				String k = textField.getText();
				dispose();
				HillGUIres hill = new HillGUIres(m,k,msg);
				hill.setVisible(true);
			}
		});
		btnCodificadecodifica.setBounds(10, 227, 414, 23);
		contentPane.add(btnCodificadecodifica);
	}

}
