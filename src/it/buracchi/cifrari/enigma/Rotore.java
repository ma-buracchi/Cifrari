/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.enigma;


public class Rotore {
	
	private char[] from = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	protected char[] out = new char[26];

	public Rotore(char[] set) {
		for (int i = 0; i < 26; i++) {
			out[i] = set[i];
		}
	}

	public void rotate() {
		char temp = from[0];			//salvo l'ultima lettera
		for (int i = 0; i <= 24; i++) { //sposto di una posizione tutte le altre
			from[i] = from[i+1]; 		// l'ultima la metto in testa
		}
		from[25] = temp;
		
	}

	public char going(char a) {
		//Util.printArray(from);
		char b;
		for (int i = 0; i < 26; i++) {
			if (from[i] == a) {
				b = out[i];
				//Util.printArray(out);
				return b;
			}
		}
		return ' ';
	}

	public char comeBack(char a) {
		//Util.printArray(out);
		char b;
		for (int i = 0; i < 26; i++) {
			if (out[i] == a) {
				b = from[i];
				//Util.printArray(from);
				return b;
			}
		}
		return ' ';
	}
	
}
