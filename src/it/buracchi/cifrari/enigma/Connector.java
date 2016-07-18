/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.enigma;

import it.buracchi.cifrari.other.*;

/**
 * 
 * @author Marco Buracchi
 *
 */

public abstract class Connector {

	private char[] to = new char[26];
	
	/**
	 * 
	 * @param t è l'array di caratteri che rappresenta l'inizializzazione della plugboard
	 */

	public Connector(char[] t) {
		for (int i = 0; i < 26; i++) {
			to[i] = t[i];
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
