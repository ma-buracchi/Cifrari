# Cifrari
Implementazioni di alcuni dei più famosi cifrari a chiave condivisa

1) Shift cipher:
- Ogni lettera del messaggio da cifrare/decifrare verrà spostata in avanti/indietro del numero di posizioni desiderato (3 è il valore con il quale è impostato lo storico cifrario di Giulio Cesare)

2) Substitution cipher:
- Ogni lettera del messaggio da cifrare/decifrare verrà sostituita con la corrispondente lettera nella permutazione indicata

3) Affine cipher:
- Ogni lettera (x) del messaggio da cifrare/decifrare verrà cifrata come c(x) = (ax + b) mod 26 utilizzando i coefficienti selezionati

4) Vigenere:
- Ogni lettera del messaggio da cifrare/decifrare verrà cifrata utilizzando la chiave inserita, secondo il cifrario di Vigenere

5) Hill:
- Il messaggio da cifrare/decifrare verrà cifrato secondo il cifrario di Hill utilizzando le matrici inserite dall'utente. La matrice deve essere composta da numeri interi e deve essere inserita elemento per elemento, separati da spazi, riga per riga. Ad esempio per inserire una matrice 2x2 con elementi rispettivamente 1 e 2 nella prima riga, 3 e 4 nella seconda deve essere inserita la stringa "1 2 3 4".

6) Permutation cipher:
- Ogni blocco del messaggio di grandezza m (max 10, selezionata dall'utente) verrà cifrato utilizzando la permutazione di interi (da 0 a m-1) inserita.

7) One-Time Pad:
- In caso di cifratura, il messaggio verrà cifrato secondo il cifrario One-Time Pad e verrà fornita la relativa chiave di decifratura
- In caso di decifratura, il messaggio verrà decifrato secondo il cifrario One-Time Pad, utilizzando la chiave inserita

8) ENIGMA:
- Il messaggio da cifrare/decifrare verrà cifrato/decifrato secondo il cifrario ENIGMA utilizzando la configurazione dei rotori e della plugboard selezionata dall'utente. Per configurare la plugboard occorre inserire l'alfabeto con gli scambi desiderati; ad esempio se si vuole scambiare la b con la s e la g con la v l'alfabeto da inserire sarà: 
ascdefvhijklmnopqrbtugwxyz

9) ?????????
