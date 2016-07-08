package it.buracchi.cifrari.gui.oneTimePad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OneTimePadGUIdecif extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireChiave;

	/**
	 * Create the frame.
	 */
	
	public OneTimePadGUIdecif() {
		setTitle("ONE-TIME PAD CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInserireChiave = new JTextField();
		txtInserireChiave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtInserireChiave.setText("");
			}
		});
		txtInserireChiave.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireChiave.setText("Inserire chiave");
		txtInserireChiave.setBounds(10, 196, 414, 20);
		contentPane.add(txtInserireChiave);
		txtInserireChiave.setColumns(10);
		
		JTextPane txtpnInserireMessaggioDa = new JTextPane();
		txtpnInserireMessaggioDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtpnInserireMessaggioDa.setText("");
			}
		});
		txtpnInserireMessaggioDa.setText("Inserire messaggio da decifrare");
		txtpnInserireMessaggioDa.setBounds(10, 11, 414, 174);
		contentPane.add(txtpnInserireMessaggioDa);
		
		JButton btnDecifra = new JButton("Decifra");
		btnDecifra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireMessaggioDa.getText().replace(" ", "");
				String key = txtInserireChiave.getText();
				dispose();
				OneTimePadGUIdecifRes otp = new OneTimePadGUIdecifRes(msg,key);
				otp.setVisible(true);
			}
		});
		btnDecifra.setBounds(10, 227, 414, 23);
		contentPane.add(btnDecifra);
	}

}
