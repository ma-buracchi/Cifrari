package it.buracchi.cifrari.gui.substitution;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SubstitutionGUIcodifica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireLaPermutazione;

	/**
	 * Create the frame.
	 */
	public SubstitutionGUIcodifica() {
		setTitle("SUBSTITUTION CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtpnInserireIlMessaggio = new JTextArea();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 177);
		txtpnInserireIlMessaggio.setLineWrap(true);
		contentPane.add(txtpnInserireIlMessaggio);
		
		txtInserireLaPermutazione = new JTextField();
		txtInserireLaPermutazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserireLaPermutazione.setText("");
			}
		});
		txtInserireLaPermutazione.setBounds(10, 199, 414, 20);
		txtInserireLaPermutazione.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLaPermutazione.setText("Inserire la permutazione dell'alfabeto che si vuole utilizzare");
		contentPane.add(txtInserireLaPermutazione);
		txtInserireLaPermutazione.setColumns(10);
		
		JButton btnCifrare = new JButton("Cifrare");
		btnCifrare.setBounds(10, 230, 414, 20);
		btnCifrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replaceAll("[^A-Za-z]", "").toLowerCase();
				String perm = txtInserireLaPermutazione.getText();
				SubstitutionGUIcodificaRes nw = new SubstitutionGUIcodificaRes(perm,msg);
				dispose();
				nw.setVisible(true);
			}
		});
		contentPane.add(btnCifrare);

	}

}
