/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.enigma;

import it.buracchi.cifrari.other.Util;

public class Plugboard {

private char[] to = new char[26];
	
	/**
	 * 
	 * @param t è l'array di caratteri che rappresenta l'inizializzazione della plugboard
	 */

	public Plugboard(String s) {
		for (int i = 0; i < s.length(); i++) {
			to[i] = s.charAt(i);
		}
	}
	
	/**
	 * 
	 * @param a è l'attuale carattere da codificare
	 * @return il carattere codificato
	 */

	public char code(char a) {
		//Util.printArray(from);
		char c = to[Util.convertLetter(a)];
		//Util.printArray(to);
		return c;
	}


}
