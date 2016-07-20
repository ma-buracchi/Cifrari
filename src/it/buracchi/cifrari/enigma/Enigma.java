/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.enigma;

public class Enigma {

	private Plugboard plugboard;
	private Rotore rotFast;
	private Rotore rotMed;
	private Rotore rotSlow;
	private Reflector reflector;
	private int j = 0;
	private int k = 0;

	public Enigma(String f, int fast, String m, int med, String s, int slow,
			String plug, String ref) {
		// Inizializzazione di Enigma dai file prescelti
		plugboard = new Plugboard(plug);
		reflector = new Reflector(ref);
		rotFast = new Rotore(f);
		rotMed = new Rotore(m);
		rotSlow = new Rotore(s);
		setEnigma(fast, med, slow);
	}

	private void setEnigma(int fast, int med, int slow) {
		for (int i = 0; i < fast; i++) {
			rotFast.rotate();
		}
		for (int i = 0; i < med; i++) {
			rotMed.rotate();
		}
		for (int i = 0; i < slow; i++) {
			rotSlow.rotate();
		}
	}

	public String code(String msg) {
		String res = "";
		for (int i = 0; i < msg.length(); i++) {
			rotate(); // rotazione dei rotori
			char text = msg.charAt(i);
			char temp = plugboard.code(text); // entra nella plugboard
			temp = rotFast.going(temp); // entra nel rotore veloce
			temp = rotMed.going(temp); // nel medio
			temp = rotSlow.going(temp); // nel lento
			temp = reflector.code(temp); // nel reflector
			temp = rotSlow.comeBack(temp);// torna nel rotore lento
			temp = rotMed.comeBack(temp); // nel medio
			temp = rotFast.comeBack(temp);// nel veloce
			temp = plugboard.code(temp); // nella plugboard
			res = res + temp;
		}
		return (res);
	}

	private void rotate() {
		rotFast.rotate();
		j++;
		if (j % 26 == 0) {
			rotMed.rotate();
			k++;
			if (k % 26 == 0) {
				rotSlow.rotate();
			}
		}
	}

}
