package it.buracchi.cifrari.substitution;

import it.buracchi.cifrari.other.Util;

public class Polibio {
	
	private String text;
	private char[][]tab = new char[7][7];
	
	public Polibio(String t, String h, String p){
		int j = 1;
		int k = 1;
		int l = 1;
		for(int i = 0; i < h.length();i++){
			tab[0][l] = h.charAt(i);
			tab[l++][0] = h.charAt(i);
		}
		for(int i = 0; i < p.length();i++){
			tab[j][k] = p.charAt(i);
			k++;
			if (k == 7){
				k = 1;
				j++;
			}
		}
		this.text = t;
	}
	
	public String coding(){
		String res = "";
		for (int i = 0; i < text.length(); i++){
			String temp = Util.searchMatrix(tab,text.charAt(i));
			res = res + temp;
		}
		return res;
	}
	
	public String decoding(){
		String res="";
		int i = 0;
		while (i < text.length()){
			char row = text.charAt(i++);
			char column = text.charAt(i++);
			int j;
			int k;
			for (j = 0; j < tab.length; j++){
				if (tab[j][0] == row){
					break;
				}
			}
			for (k = 0; k < tab[0].length; k++){
				if (tab[0][k] == column){
					break;
				}
			}
			res = res + tab[j][k];
		}
		return res;
	}
}
