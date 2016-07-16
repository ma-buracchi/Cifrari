/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.substitution;

import it.buracchi.cifrari.other.*;

public class Shift {
	
	private String s;
	private int n;
	
	public Shift(String s, int n){
		this.s = s;
		this.n = n;
	}
	
	public String coding(){
		String res = "";
		for (int i = 0; i < s.length(); i++){
			res = res + (char)(((Util.convertLetter(s.charAt(i)) + n) % 26)+97);
		}
		return res;
	}
	
	public String decoding(){
		String res = "";
		for (int i = 0; i < s.length(); i++){
			res = res + (char)((((Util.convertLetter(s.charAt(i))) - n + 26) % 26)+97);
		}
		return res;
	}

}
