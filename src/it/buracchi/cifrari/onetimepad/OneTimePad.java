/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.onetimepad;

import it.buracchi.cifrari.other.Util;

public class OneTimePad {

	private String convert[] = { "00000", "00001", "00010", "00011", "00100",
			"00101", "00110", "00111", "01000", "01001", "01010", "01011",
			"01100", "01101", "01110", "01111", "10000", "10001", "10010",
			"10011", "10100", "10101", "10110", "10111", "11000", "11001", };

	private String msg = "";
	private String key = "";
	private String res = "";

	public OneTimePad(String m) {
		stringToBin(m);
		createKey();
	}
	
	public OneTimePad(String m, String k) {
		stringToBin(m);
		key += k;
	}

	private void createKey() {
		for (int i = 0; i < msg.length(); i++) {
			key = key + ((int) (Math.random() * 2));
		}
	}
	
	private void stringToBin(String m){
		for (int i = 0; i < m.length(); i++) {
			msg += convert[Util.convertLetter(m.charAt(i))];
		}
	}
	
	private void binToString(String b){
		for (int i = 0; i < b.length(); i += 5) {
			String temp = b.substring(i, i+5);
			for (int j = 0; j < convert.length; j++) {
				if(temp.equals(convert[j])){
					res += (char)(j+97);
				}
			}
		}
	}
	
	public String coding() {
		String temp = "";
		for (int i = 0; i < msg.length(); i++) {
			int m = Character.getNumericValue(msg.charAt(i));
			int k = Character.getNumericValue(key.charAt(i));
			temp = temp + (m ^ k);
		}
		binToString(temp);
		return res;
	}

	public String printKey() {
		return key;
	}

}
