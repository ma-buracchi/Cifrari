/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.substitution;

import it.buracchi.cifrari.other.Util;

public class Substitution {

	private char[] permutation = new char[26];
	private String msg;
	
	public Substitution(String p, String m){
		setPermutation(p);
		msg = m;
	}
	
	private void setPermutation(String p){
		for (int i = 0; i < permutation.length; i++){
			permutation[i] = p.charAt(i);
		}
			
	}
	
	public String coding(){
		String res = "";
		for (int i = 0; i < msg.length(); i++){
			res = res + permutation[Util.convertLetter(msg.charAt(i))];
		}
		return res;
	}
	
	public String decoding(){
		String res = "";
		for (int i = 0; i < msg.length(); i++){
			char c = msg.charAt(i);
			int j = 0;
			while (c != permutation[j]){
				j++;
			}
			res = res + (char)(j+97);
		}
		return res;
	}
	
	

}
