/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.vigenere;

import it.buracchi.cifrari.other.*;

public class Vigenere {
	
	private String key;	
	private String message;
	
	public Vigenere(String msg, String k){
		this.key = k;
		this.message = msg;
	}
	
	private void extendKey(){
		while (key.length() < message.length()){
			key = key+key;
		}
	}
	
	public String coding(){
		extendKey();
		String res = "";
		for (int i = 0; i < message.length(); i++){
			int m = Util.convertLetter(message.charAt(i));
			int k = Util.convertLetter(key.charAt(i));
			res = res + (char)(((m+k)%26)+97);
		}
		return res;
	}
	
	public String decoding(){
		extendKey();
		String res = "";
		for (int i = 0; i < message.length(); i++){
			int m = Util.convertLetter(message.charAt(i));
			int k = Util.convertLetter(key.charAt(i));
			res = res + (char)(((m-k+26)%26)+97);
		}
		return res;
	}

}
