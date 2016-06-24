/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.enigma;

import it.buracchi.cifrari.other.*;


public class Enigma {

	private Plugboard plugboard;
	private Rotore rotFast;
	private Rotore rotMed;
	private Rotore rotSlow;
	private Reflector reflector;
	private int j = 0;
	private int k = 0;

	public Enigma(String f, int fast, String m, int med, String s, int slow) {
		// Inizializzazione di Enigma dai file prescelti
		plugboard = new Plugboard(Util.readLineToArray("Plugboard/Plugboard01"));
		reflector = new Reflector(Util.readLineToArray("Reflector/Reflector01"));
		rotFast = new Rotore(Util.readLineToArray("Rotori/" + f));
		rotMed = new Rotore(Util.readLineToArray("Rotori/" + m));
		rotSlow = new Rotore(Util.readLineToArray("Rotori/" + s));
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

	public char code(char text) {

		rotate(); // rotazione dei rotori
		
		char res = plugboard.code(text); // entra nella plugboard
		res = rotFast.going(res); // entra nel rotore veloce
		res = rotMed.going(res); // nel medio
		res = rotSlow.going(res); // nel lento
		res = reflector.code(res); // nel reflector
		res = rotSlow.comeBack(res);// torna nel rotore lento
		res = rotMed.comeBack(res); // nel medio
		res = rotFast.comeBack(res);// nel veloce
		res = plugboard.code(res); // nella plugboard
		//System.out.print(text + " ------> " + res + "\n");
		return(res);

		
		/*try {
			Thread.sleep(400); // "velocita' di decodifica"
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
