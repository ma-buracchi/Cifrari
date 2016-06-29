# Cifrari
Implementazioni di alcuni dei più famosi cifrari a chiave condivisa

- Estrarre in una cartella il contenuto del file CIFRARI.zip
- Da linea di comando, spostarsi nella directory che contiene i file appena estratti
- Lanciare l’applicazione tramite il comando java -jar CIFRARI.jar (richiede Java)
- Il programma chiederà quale cifrario si vuole utilizzare. Selezionare il cifrario e premere INVIO oppure selezionare 9 e premere INVIO per chiudere il programma.

1) Shift cipher:
- Selezionare se si intende cifrare o decifrare il messaggio e premere INVIO
- Inserire il messaggio da cifrare/decifrare (solo lettere minuscole senza spazi) e premere INVIO
- Inserire di quante posizioni vogliamo spostare in avanti/indietro ciascuna lettera e premere INVIO (3 è il valore con il quale è impostato lo storico cifrario di Giulio Cesare)
- Viene visualizzato il messaggio cifrato/decifrato. Per continuare premere INVIO

2) Substitution cipher:
- Selezionare se si intende cifrare o decifrare il messaggio e premere INVIO
- Inserire il messaggio da cifrare/decifrare (solo lettere minuscole senza spazi) e premere INVIO
- Inserire la permutazione dei 26 caratteri dell'alfabeto che vogliamo usare per effettuare la sostituzione
- Viene visualizzato il messaggio cifrato/decifrato. Per continuare premere INVIO

3) Affine cipher:
- Selezionare se si intende cifrare o decifrare il messaggio e premere INVIO
- Inserire il messaggio da cifrare/decifrare (solo lettere minuscole senza spazi) e premere INVIO
- Inserire il valore del coefficiente a (vengono suggeriti i valori ammissibili che devono essere coprimi con 26)
- Inserire il valore del coefficiente b
- Viene visualizzato il messaggio cifrato/decifrato. Per continuare premere INVIO

4) Vigenere:
- Selezionare se si intende cifrare o decifrare il messaggio e premere INVIO
- Inserire il messaggio da cifrare/decifrare (solo lettere minuscole senza spazi) e premere INVIO
- Inserire la chiave e premere INVIO
- Viene visualizzato il messaggio cifrato/decifrato. Per continuare premere INVIO

5) Hill:
- Inserire la lunghezza dei blocchi (m) e premere INVIO
- Inserire il nome del file contenente la matrice da utilizzare come chiave (si trovano nella cartella Key) e premere INVIO
- Inserire il messaggio da cifrare/decifrare (solo lettere minuscole senza spazi) e premere INVIO
- Viene visualizzato il messaggio cifrato/decifrato. Per continuare premere INVIO

6) Permutation cipher:
- Inserire la lunghezza dei blocchi m (max 10) e premere INVIO
- Inserire la permutazione di interi che vogliamo usare per effettuare la sostituzione
- Selezionare se si intende cifrare o decifrare il messaggio e premere INVIO
- Inserire il messaggio da cifrare/decifrare (solo lettere minuscole senza spazi) e premere INVIO
- Viene visualizzato il messaggio cifrato/decifrato. Per continuare premere INVIO

7) One-Time Pad:
- Selezionare se si intende cifrare o decifrare il messaggio e premere INVIO
  - In caso di cifratura
    - Inserire il messaggio da cifrare (solo lettere minuscole senza spazi) e premere INVIO
    - Viene visualizzato il messaggio cifrato e la chiave da utilizzare per decifrare. Per continuare premere INVIO.
  - In caso di decifrazione
    - Inserire il messaggio cifrato e premere INVIO
    - Inserire la chiave e premere INVIO
    - Viene visualizzato il messaggio decifrato.
- Per continuare premere INVIO

8) ENIGMA:
- Selezionare i tre rotori che vogliamo usare (scegliere tra ’I’,’II’,’III’,’IV’,’V’). Selezionare il rotore desiderato e premere INVIO. 
- Selezionare la posizione di partenza di ogni rotore selezionando un intero compreso tra 0 e 25 e premendo INVIO
- inserire il messaggio da cifrare (solo lettere minuscole, senza spazi) e premere INVIO
- Viene visualizzato il messaggio cifrato/decifrato. Per continuare premere INVIO
