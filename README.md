# Cifrari
Implementazioni di alcuni dei più famosi cifrari a chiave condivisa

- Estrarre in una cartella il contenuto del file CIFRARI.zip
- Lanciare l’applicazione CIFRARI.jar (richiede Java)
- Selezionare il cifrario che si vuole utilizzare

1) Shift cipher:
- Ogni lettera del messaggio da cifrare/decifrare (solo lettere minuscole) verrà spostata in avanti/indietro del numero di posizioni desiderato (3 è il valore con il quale è impostato lo storico cifrario di Giulio Cesare)

2) Substitution cipher:
- Ogni lettera del messaggio da cifrare/decifrare (solo lettere minuscole) verrà sostituita con la corrispondente lettera nella permutazione indicata

3) Affine cipher:
- Ogni lettera (x) del messaggio da cifrare/decifrare (solo lettere minuscole) verrà cifrata come c(x) = (ax + b) mod 26 utilizzando i coefficienti selezionati

4) Vigenere:
- Ogni lettera del messaggio da cifrare/decifrare (solo lettere minuscole) verrà cifrata utilizzando la chiave inserita, secondo il cifrario di Vigenere

5) Hill:
- Il messaggio da cifrare/decifrare (solo lettere minuscole) verrà cifrato secondo il cifrario di Hill utilizzando le matrici selezionate dall'utente. Possono essere create ed utilizzate nuove matrici (solo di interi) che possono essere salvate nella cartella Key.

6) Permutation cipher:
- Ogni blocco del messaggio di grandezza m (max 10, selezionata dall'utente) verrà cifrato utilizzando la permutazione di interi (da 0 a m-1) inserita.

7) One-Time Pad:
- In caso di cifratura, il messaggio (solo lettere minuscole) verrà cifrato secondo il cifrario One-Time Pad e verrà fornita la relativa chiave di decifratura
- In caso di decifratura, il messaggio verrà decifrato secondo il cifrario One-Time Pad, utilizzando la chiave inserita

8) ENIGMA:
- Il messaggio da cifrare/decifrare (solo lettere minuscole) verrà cifrato/decifrato secondo il cifrario ENIGMA utilizzando la configurazione dei rotori selezionata dall'utente.

9) ?????????