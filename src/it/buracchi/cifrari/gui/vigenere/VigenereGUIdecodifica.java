package it.buracchi.cifrari.gui.vigenere;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VigenereGUIdecodifica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireLaChiave;

	/**
	 * Create the frame.
	 */
	
	public VigenereGUIdecodifica() {
		setTitle("VIGENERE CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInserireLaChiave = new JTextField();
		txtInserireLaChiave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserireLaChiave.setText("");
			}
		});
		txtInserireLaChiave.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLaChiave.setText("Inserire la chiave");
		txtInserireLaChiave.setBounds(10, 196, 414, 20);
		contentPane.add(txtInserireLaChiave);
		txtInserireLaChiave.setColumns(10);
		
		JTextPane txtpnInserireIlMessaggio = new JTextPane();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da decifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 174);
		contentPane.add(txtpnInserireIlMessaggio);
		
		JButton btnCodifica = new JButton("Decodifica");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replace(" ", "");
				String key = txtInserireLaChiave.getText();
				VigenereGUIdecodificaRes vgn = new VigenereGUIdecodificaRes(msg,key);
				vgn.setVisible(true);
			}
		});
		btnCodifica.setBounds(10, 227, 414, 23);
		contentPane.add(btnCodifica);
	}

}
