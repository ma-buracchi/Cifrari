/*
 *  Created on: June 23, 2016
 *      Author: Marco Buracchi
 */

package it.buracchi.cifrari.other;

import it.buracchi.cifrari.enigma.Enigma;
import it.buracchi.cifrari.hill.Hill;
import it.buracchi.cifrari.hill.Permutation;
import it.buracchi.cifrari.onetimepad.OneTimePad;
import it.buracchi.cifrari.substitution.Affine;
import it.buracchi.cifrari.substitution.Shift;
import it.buracchi.cifrari.substitution.Substitution;
import it.buracchi.cifrari.vigenere.Vigenere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));

		while (true) {

			try {
				Util.clearScreen();
				System.out
						.print("Selezionare cifrario da utilizzare:\n1)Shift cipher\t\t2)Substitution cipher\n3)Affine ciphere\t4)Vigenere\n5)Hill\t\t\t6)Permutation cipher\n7)One-Time Pad\t\t8)Enigma\n9)Arresta il programma\n");

				String choice = console.readLine();
				//int choice = Integer.parseInt(console.readLine());

				switch (choice) {

				case "1": // Shift cipher

					Util.clearScreen();

					System.out
							.print("Selezionare \n1) per cifrare\n2) per decifrare\n");

					choice = console.readLine();

					switch (choice) {

					case "1":

						Util.clearScreen();

						System.out.print("Inserire messaggio da cifrare\n");
						String msg = console.readLine();

						Util.clearScreen();

						System.out
								.print("Inserire numero di posizioni di shift(3 = Giulio Cesare)\n");
						int shift = Integer.parseInt(console.readLine());

						Util.clearScreen();

						Shift gc = new Shift(msg, shift);
						System.out.print("Il messaggio cifrato è: "
								+ gc.coding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					case "2":

						Util.clearScreen();

						System.out.print("Inserire messaggio da decifrare\n");
						msg = console.readLine();

						Util.clearScreen();

						System.out
								.print("Inserire numero di posizioni di shift(3 = Giulio Cesare)\n");
						shift = Integer.parseInt(console.readLine());

						Util.clearScreen();

						gc = new Shift(msg, shift);
						System.out.print("Il messaggio decifrato è: "
								+ gc.decoding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;
					default:
						System.out.println("Selezione errata, premere INVIO per tornare al menu");
						console.readLine();
					}

					break;

				case "2": // Substitution

					Util.clearScreen();

					System.out
							.print("Selezionare \n1) per cifrare\n2) per decifrare\n");

					choice = console.readLine();

					switch (choice) {

					case "1":

						Util.clearScreen();

						System.out.print("Inserire messaggio da cifrare\n");
						String msg = console.readLine();

						Util.clearScreen();

						System.out.print("Inserire permutazione\n");
						String permutation = console.readLine();

						Util.clearScreen();

						Substitution s = new Substitution(permutation, msg);
						System.out.print("Il messaggio cifrato è: "
								+ s.coding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					case "2":

						Util.clearScreen();

						System.out.print("Inserire messaggio da decifrare\n");
						msg = console.readLine();

						Util.clearScreen();

						System.out.print("Inserire permutazione\n");
						permutation = console.readLine();

						Util.clearScreen();

						s = new Substitution(permutation, msg);
						System.out.print("Il messaggio decifrato è: "
								+ s.decoding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					default:
						System.out.println("Selezione errata, premere INVIO per tornare al menu");
						console.readLine();
					}
					break;

				case "3": // Affine

					Util.clearScreen();

					System.out
							.print("Selezionare \n1) per cifrare\n2) per decifrare\n");

					choice = console.readLine();

					switch (choice) {

					case "1":

						Util.clearScreen();

						System.out.print("Inserire messaggio da cifrare\n");
						String msg = console.readLine();

						Util.clearScreen();

						System.out
								.print("Inserire coefficiente 'a' (1,3,5,7,11,17,25 sono gli unici numeri coprimi con 26)\n");
						int a = Integer.parseInt(console.readLine());

						Util.clearScreen();

						System.out.print("Inserire coefficiente 'b'\n");
						int b = Integer.parseInt(console.readLine()) % 26;

						Util.clearScreen();

						Affine aff = new Affine(msg, a, b);
						System.out.print("Il messaggio cifrato è: "
								+ aff.coding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					case "2":

						Util.clearScreen();

						System.out.print("Inserire messaggio da decifrare\n");
						msg = console.readLine();

						Util.clearScreen();

						System.out
								.print("Inserire coefficiente 'a' (1,3,5,7,11,17,25 sono gli unici numeri coprimi con 26)\n");
						a = Integer.parseInt(console.readLine());

						Util.clearScreen();

						System.out.print("Inserire coefficiente 'b'\n");
						b = Integer.parseInt(console.readLine()) % 26;

						Util.clearScreen();

						aff = new Affine(msg, a, b);
						System.out.print("Il messaggio decifrato è: "
								+ aff.decoding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					default:
						System.out.println("Selezione errata, premere INVIO per tornare al menu");
						console.readLine();
					}

					break;

				case "4": // Vigenere

					Util.clearScreen();

					System.out
							.print("Selezionare \n1) per cifrare\n2) per decifrare\n");

					choice = console.readLine();

					switch (choice) {

					case "1":

						Util.clearScreen();

						System.out.print("Inserire messaggio da cifrare\n");
						String msg = console.readLine();

						Util.clearScreen();

						System.out.print("Inserire chiave\n");
						String key = console.readLine();

						Util.clearScreen();

						Vigenere v = new Vigenere(msg, key);
						System.out.print("Il messaggio cifrato è: "
								+ v.coding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					case "2":

						Util.clearScreen();

						System.out.print("Inserire messaggio da decifrare\n");
						msg = console.readLine();

						Util.clearScreen();

						System.out.print("Inserire chiave\n");
						key = console.readLine();

						Util.clearScreen();

						v = new Vigenere(msg, key);
						System.out.print("Il messaggio decifrato è: "
								+ v.decoding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;
					default:
						System.out.println("Selezione errata, premere INVIO per tornare al menu");
						console.readLine();
					}
					break;

				case "5": // Hill

					Util.clearScreen();

					System.out.print("Inserire lunghezza blocchi (m)\n");
					int m = Integer.parseInt(console.readLine());

					Util.clearScreen();

					System.out.print("Inserire chiave\n");
					String k = console.readLine();

					Util.clearScreen();

					System.out
							.print("Inserire messaggio da cifrare (in caso la lunghezza del messaggio non sia multiplo di m vengono aggiunte delle 'a' finali)\n");
					String msg = console.readLine();

					Util.clearScreen();

					Hill h = new Hill(m, k, msg);

					System.out.print("Il messaggio cifrato è: " + h.coding()
							+ "\nPremere INVIO per continuare");
					console.readLine();
					break;

				case "6": // Permutation

					Util.clearScreen();

					System.out
							.print("Inserire lunghezza blocchi (m)(max 10)\n");
					m = Integer.parseInt(console.readLine());

					Util.clearScreen();

					System.out
							.print("Inserire permutazione(interi da 0 a 9)\n");
					String perm = console.readLine();

					Util.clearScreen();

					System.out
							.print("Selezionare \n1) per cifrare\n2) per decifrare\n");

					choice = console.readLine();

					switch (choice) {

					case "1":

						Util.clearScreen();

						System.out
								.print("Inserire messaggio da cifrare (in caso la lunghezza del messaggio non sia multiplo di m vengono aggiunte delle 'a' finali)\n");

						msg = console.readLine();

						Util.clearScreen();

						Permutation p = new Permutation(m, perm, msg);

						System.out.print("Il messaggio cifrato è: "
								+ p.coding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					case "2":

						Util.clearScreen();

						System.out
								.print("Inserire messaggio da decifrare (in caso la lunghezza del messaggio non sia multiplo di m vengono aggiunte delle 'a' finali)\n");

						msg = console.readLine();

						Util.clearScreen();

						p = new Permutation(m, perm, msg);

						System.out.print("Il messaggio decifrato è: "
								+ p.decoding() + "\nPremere INVIO per continuare");
						console.readLine();
						
						break;

					default:
						System.out.println("Selezione errata, premere INVIO per tornare al menu");
						console.readLine();
					}

					break;

				case "7": // One-Time Pad
					
					Util.clearScreen();

					System.out
							.print("Selezionare \n1) per cifrare\n2) per decifrare\n");

					choice = console.readLine();

					switch (choice) {

					case "1":

						Util.clearScreen();

						System.out.print("Inserire messaggio da cifrare\n");
						msg = console.readLine();

						Util.clearScreen();

						OneTimePad otp = new OneTimePad(msg);

						System.out.print("Il messaggio cifrato è: " + otp.coding()
								+ "\n");
						System.out.print("La chiave per decifrare questo messaggio è: " + otp.printKey()
								+ "\nPremere INVIO per continuare");
						console.readLine();
						
						break;

					case "2":

						Util.clearScreen();

						System.out
								.print("Inserire messaggio da decifrare\n");

						msg = console.readLine();
						
						Util.clearScreen();

						System.out
								.print("Inserire chiave\n");

						String key = console.readLine();

						Util.clearScreen();

						otp = new OneTimePad(msg,key);

						System.out.print("Il messaggio decifrato è: "
								+ otp.decoding() + "\nPremere INVIO per continuare");
						console.readLine();
						
						break;

					default:
						System.out.println("Selezione errata, premere INVIO per tornare al menu");
						console.readLine();
					}

					break;

				case "8": // Enigma

					Util.clearScreen();

					System.out.print("Inserire rotore veloce\n");
					String r1 = console.readLine();
					Util.clearScreen();
					while (!Util.checkRotor(r1)) {
						System.out
								.print("Il rotore inserito non esiste, reinserire rotore veloce\n");
						r1 = console.readLine();
						Util.clearScreen();
					}

					System.out.print("Inserire rotore medio\n");
					String r2 = console.readLine();
					Util.clearScreen();
					while (!Util.checkRotor(r2)) {
						System.out
								.print("Il rotore inserito non esiste, reinserire rotore medio\n");
						r2 = console.readLine();
						Util.clearScreen();
					}

					System.out.print("Inserire rotore lento\n");
					String r3 = console.readLine();
					Util.clearScreen();
					while (!Util.checkRotor(r3)) {
						System.out
								.print("Il rotore inserito non esiste, reinserire rotore lento\n");
						r3 = console.readLine();
						Util.clearScreen();
					}

					System.out
							.print("Inserire posizione partenza rotore veloce\n");
					int p1 = Integer.parseInt(console.readLine());
					Util.clearScreen();
					while (p1 < 0 || p1 > 25) {
						System.out
								.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
						p1 = Integer.parseInt(console.readLine());
						Util.clearScreen();
					}

					System.out
							.print("Inserire posizione partenza rotore medio\n");
					int p2 = Integer.parseInt(console.readLine());
					Util.clearScreen();
					while (p2 < 0 || p2 > 25) {
						System.out
								.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
						p2 = Integer.parseInt(console.readLine());
						Util.clearScreen();
					}

					System.out
							.print("Inserire posizione partenza rotore lento\n");
					int p3 = Integer.parseInt(console.readLine());
					Util.clearScreen();
					while (p3 < 0 || p3 > 25) {
						System.out
								.print("La posizione di partenza deve essere compresa tra 0 e 25\n");
						p3 = Integer.parseInt(console.readLine());
						Util.clearScreen();
					}

					Enigma e = new Enigma(r1, p1, r2, p2, r3, p3);

					System.out.print("Inserire il messaggio \n");
					String message = console.readLine();
					Util.clearScreen();
					int mLength = message.length();
					String res = "";
					System.out.print(message + "\n\n");
					for (int i = 0; i < mLength; i++) {
						char text = message.charAt(i);
						char temp = e.code(text);
						System.out.print(text + " ------> " + temp + "\n");
						res = res + temp;
						// Util.clearScreen();
					}
					System.out.print("\nIl messaggio cifrato è: " + res + "\nPremere INVIO per continuare");
					console.readLine();
					break;

				case "9": // chiusura
					console.close();
					System.exit(0);
					break;

				default:
					
					Util.clearScreen();
					System.out.print("Easter egg!! Codice farfallino!!\n");
					
					System.out
							.print("Selezionare \n1) per cifrare\n2) per decifrare\n");

					choice = console.readLine();

					switch (choice) {

					case "1":

						Util.clearScreen();

						System.out.print("Inserire messaggio da cifrare\n");
						msg = console.readLine();

						Util.clearScreen();

						Farfallino f = new Farfallino(msg);
						System.out.print("Il messaggio cifrato è: "
								+ f.coding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;

					case "2":

						Util.clearScreen();

						System.out.print("Inserire messaggio da decifrare\n");
						msg = console.readLine();

						Util.clearScreen();

						f = new Farfallino(msg);
						System.out.print("Il messaggio decifrato è: "
								+ f.decoding() + "\nPremere INVIO per continuare");
						console.readLine();
						break;
						
					default:
						System.out.println("Selezione errata, premere INVIO per tornare al menu");
						console.readLine();
					}

					break;
					
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
