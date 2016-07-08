package it.buracchi.cifrari.gui.shift;

import it.buracchi.cifrari.substitution.Shift;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ShiftGUIdecodificaRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String msg = "";
	private static int shift = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShiftGUIdecodificaRes frame = new ShiftGUIdecodificaRes(msg,shift);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShiftGUIdecodificaRes(String m, int s) {
		setTitle("SHIFT CIPHER");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblIlMessaggioCodificato = new JLabel("Messaggio decodificato");
		lblIlMessaggioCodificato.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIlMessaggioCodificato, BorderLayout.NORTH);
		
		Shift gc = new Shift(m, s);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(gc.decoding());
		contentPane.add(textPane, BorderLayout.CENTER);
	}

}
