package it.buracchi.cifrari.gui.permutation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PermutationGUIcodifica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireLunghezzaDei;
	private JTextField txtInserirePermutazioneInteri;

	/**
	 * Create the frame.
	 */
	
	public PermutationGUIcodifica() {
		setTitle("PERMUTATION CIPHER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnInserireIlMessaggio = new JTextPane();
		txtpnInserireIlMessaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnInserireIlMessaggio.setText("");
			}
		});
		txtpnInserireIlMessaggio.setText("Inserire il messaggio da cifrare");
		txtpnInserireIlMessaggio.setBounds(10, 11, 414, 174);
		contentPane.add(txtpnInserireIlMessaggio);
		
		txtInserireLunghezzaDei = new JTextField();
		txtInserireLunghezzaDei.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserireLunghezzaDei.setText("");
			}
		});
		txtInserireLunghezzaDei.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireLunghezzaDei.setText("Lunghezza dei blocchi (max 10)");
		txtInserireLunghezzaDei.setBounds(10, 196, 200, 20);
		contentPane.add(txtInserireLunghezzaDei);
		txtInserireLunghezzaDei.setColumns(10);
		
		txtInserirePermutazioneInteri = new JTextField();
		txtInserirePermutazioneInteri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtInserirePermutazioneInteri.setText("");
			}
		});
		txtInserirePermutazioneInteri.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserirePermutazioneInteri.setText("Inserire permutazione interi");
		txtInserirePermutazioneInteri.setColumns(10);
		txtInserirePermutazioneInteri.setBounds(224, 196, 200, 20);
		contentPane.add(txtInserirePermutazioneInteri);
		
		JButton btnCodifica = new JButton("Codifica");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txtpnInserireIlMessaggio.getText().replace(" ", "");
				int m = Integer.parseInt(txtInserireLunghezzaDei.getText());
				String perm = txtInserirePermutazioneInteri.getText();
				PermutationGUIcodificaRes penw = new PermutationGUIcodificaRes(m,perm,msg);
				dispose();
				penw.setVisible(true);
			}
		});
		btnCodifica.setBounds(10, 227, 414, 23);
		contentPane.add(btnCodifica);
	}

}
