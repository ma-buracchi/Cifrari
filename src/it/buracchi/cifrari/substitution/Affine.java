/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.substitution;

import it.buracchi.cifrari.other.Util;

public class Affine {
	
	private String msg;
	private int a;
	private int b;
	private int[] aInv= {0,1,0,9,0,21,0,15,0,0,0,19,0,0,0,0,0,23,0,0,0,0,0,0,0,25}; // inversi di a coprimi con 26
	
	public Affine(String s, int a, int b){
		msg = s;
		this.a = a;
		this.b = b;
	}
	
	public String coding(){
		String res = "";
		for (int i = 0; i < msg.length(); i++){
			res = res + (char)(((a*Util.convertLetter(msg.charAt(i)) + b) % 26)+97);
		}
		return res;
	}
	
	public String decoding(){
		String res = "";
		int inv = aInv[a];
		for (int i = 0; i < msg.length(); i++){
			res = res + (char)((((inv*(Util.convertLetter(msg.charAt(i))-b))+(int)Math.pow(26, 2))%26)+97);
		}
		return res;
	}

}
