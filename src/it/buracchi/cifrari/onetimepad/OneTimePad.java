/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.onetimepad;

import it.buracchi.cifrari.other.Util;

public class OneTimePad {
	
	private String msg;
	private String key;
	
	public OneTimePad(String m, String k){
		msg = m;
		key = Util.readLineToString("Key/" + k);
	}
	
	public String coding(){
		String res = "";
		for(int i = 0; i < msg.length(); i++){
			int m = Character.getNumericValue(msg.charAt(i));
			int k = Character.getNumericValue(key.charAt(i));
			res = res + (m^k);
		}
		return res;
	}

}
