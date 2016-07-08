package it.buracchi.cifrari.gui.affine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AffineGUIcodifica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireParametrob;
	private String[] ch = {"1","3","5","7","9","11","15","17","19","21","23","25"};

		/**
	 * Create the frame.
	 */
	public AffineGUIcodifica() {
			setTitle("AFFINE CIPHER");
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
		txtpnInserireMessaggioDa.setText("Inserire messaggio da cifrare");
		txtpnInserireMessaggioDa.setBounds(10, 11, 414, 163);
		contentPane.add(txtpnInserireMessaggioDa);
		
		Choice choice = new Choice();
		choice.add("Coefficiente a (coprimo con 26)");
		for(int i = 0; i < ch.length; i++){
			choice.add(ch[i]);
		}
		choice.setBounds(10, 180, 200, 20);
		contentPane.add(choice);
		
		txtInserireParametrob = new JTextField();
		txtInserireParametrob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserireParametrob.setText("");
			}
		});
		txtInserireParametrob.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireParametrob.setText("Coefficiente b");
		txtInserireParametrob.setBounds(224, 180, 200, 20);
		contentPane.add(txtInserireParametrob);
		txtInserireParametrob.setColumns(10);
		
		JButton btnCodifica = new JButton("Codifica");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireMessaggioDa.getText().replace(" ", "");
				int a = Integer.parseInt(choice.getSelectedItem());
				int b = Integer.parseInt(txtInserireParametrob.getText());
				AffineGUIcodificaRes afnw = new AffineGUIcodificaRes(msg,a,b);
				dispose();
				afnw.setVisible(true);
			}
		});
		btnCodifica.setBounds(10, 206, 414, 44);
		contentPane.add(btnCodifica);
	}
}
