/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.hill;

public class Permutation {
	
	private int m;
	private int permutation[];
	private char[] message;

	public Permutation(int m, String p, String msg) {
		this.m = m;
		permutation = new int[m];
		setPermutation(p);
		while(msg.length() % m != 0){
			msg += "a";
		}
		message = new char[msg.length()];
		for (int i = 0; i < msg.length(); i++) {
			message[i] = msg.charAt(i);
		}
	}
	
	private void setPermutation(String p){
		for (int i = 0; i < permutation.length; i++){
			permutation[i] = Character.getNumericValue(p.charAt(i));
		}
	}

	public String coding() {
		String res = "";
		int i = 0;
		int j = 0;
		while (i < message.length) {
			res = res + message[permutation[i%m]+j*m];
			i++;
			if (i%m == 0){
				j++;
			}
		}
		return res;
	}
	
	public String decoding() {
		String res = "";
		int i = 0;
		int k = 0;
		while (i < message.length) {
			int j = 0;
			while (permutation[j] != i%m){
				j++;
			}
			res = res + message[j+k];
			i++;
			if (i%m == 0){
				k=i;
			}
		}
		return res;
	}

}
