/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.other;

import it.buracchi.cifrari.substitution.Polibio;

public class Main {

	public static void main(String[] args) {

		Polibio poli = new Polibio("grecia","abcdef","abcdefghijklmnopqrstuvwxyz0123456789");
		String code = poli.coding();
		System.out.println(code);
		poli = new Polibio(code,"abcdef","abcdefghijklmnopqrstuvwxyz0123456789");
		System.out.println(poli.decoding());

	}
}
