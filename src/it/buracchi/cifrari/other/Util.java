/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Util {

	public static int convertLetter(char a) {
		return (int) a - 97;
	}

	public static void printArray(String[] temp) {
		System.out.println();
		for (int i = 0; i < 26; i++) {
			System.out.print(temp[i] + " | ");
		}
		System.out.println();
	}

	public static char[] readLineToArray(String fileName) {
		char[] res = new char[26];
		try {
			String line = "";
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			line = br.readLine();
			StringTokenizer lineTokens = new StringTokenizer(line, ",");
			for (int i = 0; i < 26; i++) {
				res[i] = lineTokens.nextToken().charAt(0);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static String readLineToString(String fileName) {
		String line = "";
		try {
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			line = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	public static String readLineN(String fileName, int r) {
		String line = "";
		try {
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			line = br.readLine();
			for (int j = 0; j < r; j++) {
				line = br.readLine();
			}
			br.close();
			return line;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	public static int[][] readMatrix(int m, String fileName) {
		int[][] res = new int[m][m];
		try {
			String line = "";
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			for (int i = 0; i < m; i++) {
				line = br.readLine();
				StringTokenizer lineTokens = new StringTokenizer(line, ",");
				for (int j = 0; j < m; j++) {
					res[i][j] = Integer.parseInt(lineTokens.nextToken());
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static boolean checkRotor(String s) {
		return(s.equals("I")||s.equals("II")||s.equals("III")||s.equals("IV")||s.equals("V"));		
	}

	public static boolean checkChar(char t) {
		return (int) t < 97 || (int) t > 122;
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static int[] matVec(int[][] mat, int[] vec) {
		int m = vec.length;
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				res[i] += mat[i][j] * vec[j];
			}
		}
		return res;
	}
}
