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

	protected char[] rot1 = { 'e', 'k', 'm', 'f', 'l', 'g', 'd', 'q', 'v', 'z',
			'n', 't', 'o', 'w', 'y', 'h', 'x', 'u', 's', 'p', 'a', 'i', 'b',
			'r', 'c', 'j' };
	protected char[] rot2 = { 'a', 'j', 'd', 'k', 's', 'i', 'r', 'u', 'x', 'b',
			'l', 'h', 'w', 't', 'm', 'c', 'q', 'g', 'z', 'n', 'p', 'y', 'f',
			'v', 'o', 'e' };
	protected char[] rot3 = { 'b', 'd', 'f', 'h', 'j', 'l', 'c', 'p', 'r', 't',
			'x', 'v', 'z', 'n', 'y', 'e', 'i', 'w', 'g', 'a', 'k', 'm', 'u',
			's', 'q', 'o' };
	protected char[] rot4 = { 'e', 's', 'o', 'v', 'p', 'z', 'j', 'a', 'y', 'q',
			'u', 'i', 'r', 'h', 'x', 'l', 'n', 'f', 't', 'g', 'k', 'd', 'c',
			'm', 'w', 'b' };
	protected char[] rot5 = { 'v', 'z', 'b', 'r', 'g', 'i', 't', 'y', 'u', 'p',
			's', 'd', 'n', 'h', 'l', 'x', 'a', 'w', 'm', 'j', 'q', 'o', 'f',
			'e', 'c', 'k' };

	public Rotore(String r) {
		switch (r){
		
		case ("I"):
			out = rot1;
			break;
		
		case("II"):
			out = rot2;
			break;
			
		case("III"):
			out = rot3;
			break;
			
		case("IV"):
			out = rot4;
			break;
			
		case("V"):
			out = rot5;
			break;		
		}
	}

	public void rotate() {
		char temp = from[0]; // salvo l'ultima lettera
		for (int i = 0; i <= 24; i++) { // sposto di una posizione tutte le
										// altre
			from[i] = from[i + 1]; // l'ultima la metto in testa
		}
		from[25] = temp;

	}

	public char going(char a) {
		// Util.printArray(from);
		char b;
		for (int i = 0; i < 26; i++) {
			if (from[i] == a) {
				b = out[i];
				// Util.printArray(out);
				return b;
			}
		}
		return ' ';
	}

	public char comeBack(char a) {
		// Util.printArray(out);
		char b;
		for (int i = 0; i < 26; i++) {
			if (out[i] == a) {
				b = from[i];
				// Util.printArray(from);
				return b;
			}
		}
		return ' ';
	}

}
