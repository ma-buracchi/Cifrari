/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.other;

public class Farfallino {

	String msg;

	Farfallino(String m) {
		msg = m;
	}

	public String coding() {
		String res = "";
		for (int i = 0; i < msg.length(); i++){
			if (msg.charAt(i) == 'a' || msg.charAt(i) == 'e' || msg.charAt(i) == 'i' ||msg.charAt(i) == 'o' || msg.charAt(i) == 'u'){
				res += msg.charAt(i) + "f" + msg.charAt(i);
			} else {
				res += msg.charAt(i);
			}
		}
			return res;
	}
	
	public String decoding(){
		String res = "";
		for (int i = 0; i < msg.length(); i++){
			if (msg.charAt(i) == 'a' || msg.charAt(i) == 'e' || msg.charAt(i) == 'i' ||msg.charAt(i) == 'o' || msg.charAt(i) == 'u'){
				res += msg.charAt(i);
				i += 2;
			} else {
				res += msg.charAt(i);
			}
		}
			return res;
	}

}
