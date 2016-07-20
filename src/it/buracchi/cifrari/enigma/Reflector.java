/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.enigma;

import it.buracchi.cifrari.other.Util;

public class Reflector {

	private char[] to = new char[26];

	private char[] ref1 = { 'y', 'r', 'u', 'h', 'q', 's', 'l', 'd', 'p', 'x',
			'n', 'g', 'o', 'k', 'm', 'i', 'e', 'b', 'f', 'z', 'c', 'w', 'v',
			'j', 'a', 't' };
	private char[] ref2 = { 'f', 'v', 'p', 'j', 'i', 'a', 'o', 'y', 'e', 'd',
			'r', 'z', 'x', 'w', 'g', 'c', 't', 'k', 'u', 'q', 's', 'b', 'n',
			'm', 'h', 'l' };

	/**
	 * 
	 * @param t
	 *            è l'array di caratteri che rappresenta l'inizializzazione
	 *            della plugboard
	 */

	public Reflector(String r) {
		switch (r) {

		case ("B"):
			to = ref1;
			break;

		case ("C"):
			to = ref2;
			break;
		}
	}

	/**
	 * 
	 * @param a
	 *            è l'attuale carattere da codificare
	 * @return il carattere codificato
	 */

	public char code(char a) {
		// Util.printArray(from);
		char c = to[Util.convertLetter(a)];
		// Util.printArray(to);
		return c;
	}

}
