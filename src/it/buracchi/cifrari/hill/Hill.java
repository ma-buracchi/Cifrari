/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.hill;

import it.buracchi.cifrari.other.Util;

public class Hill {

	private int m;
	private int key[][];
	private int[] message;

	public Hill(int m, String k, String msg) {
		this.m = m;
		key = Util.readMatrix(m, "Key/" + k);
		while(msg.length() % m != 0){
			msg += "a";
		}
		message = new int[msg.length()];
		for (int i = 0; i < msg.length(); i++) {
			message[i] = Util.convertLetter(msg.charAt(i));
		}
	}

	public String coding() {
		String res = "";
		int[] temp = new int[m];
		int[] ris = new int[m];
		int i = 0;
		while (i < message.length) {
			for (int j = 0; j < m; j++) {
				temp[j] = message[i++];
			}
			ris = Util.matVec(key, temp);
			for (int k = 0; k < m; k++) {
				res = res
						+ (char) (((ris[k] + (int) (Math.pow(26, 2))) % 26) + 97);
			}
		}
		return res;
	}

}
