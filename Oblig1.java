public class Oblig1 {
    // Oppgave 6
    public static void rotasjon(char[] a) {
        if (a.length <= 1) {
            return; // Sjekker om tabellen er tom eller har ett element. Gjør ingenting hvis kravet blir oppfylt.
        }
        char x = a[a.length - 1]; // Sørger for å lagre siste element i tabellen før den blir overskrevet av resten av løkken.

        for (int i = a.length - 2; i >= 0; i--) {
            a[i + 1] = a[i];
        }

        a[0] = x; // Setter inn det lagrede siste elementet fra tidligere i starten av tabellen.
    }
    
    // Oppgave 7
    public static void rotasjon(char[] a, int k) {
        if (a.length <= 1) {
            return; // Sjekker om tabellen er tom eller har ett element. Gjør ingenting hvis kravet blir oppfylt.
        }
        char x = a[a.length - k]; // Sørger for å lagre siste element i tabellen før den blir overskrevet av resten av løkken.

        for (int i = a.length - 2; i >= 0; i--) {
            a[i + k] = a[i];
        }

        a[0] = x; // Setter inn det lagrede siste elementet fra tidligere i starten av tabellen.
    }

     // Oppgave 8
    public static String flett(String s, String t) {
        String mergedString = "";

        //Setter lengden til strengen som har størst lengde
        int targetLength = s.length() > t.length() ? s.length() : t.length();
    
        for (int i = 0; i < targetLength; i++){
            try {
                //if-sjekkene tillater koden å kjøre selv med tomme lister
                
                if (s.length() != 0) {mergedString += s.charAt(i);}
                if (t.length() != 0) {mergedString += t.charAt(i);}
                } catch (IndexOutOfBoundsException e) {
                //Hacky fix, men gjør at man får lagt til de resterende bokstavene fra t hvis den er lenger
                    if (t.length() > s.length()) {
                            mergedString += t.charAt(i);
                        }
                }
        }

        return mergedString;

    }

    public static String flett(String... s) {
        String mergedString = "";

        //Sjekker basically om det finnes helt tomme strings. Hvis alle stringsa er tomme, settes targetLength til 0. Hvis ikke, så settes den til lengden til den første stringen i s
        int targetLength = s.length > 0 ? s[0].length(): 0;
        for (int i = 0; i < s.length; i++) {
            if (targetLength < s[i].length()){
                targetLength = s[i].length();
            }
        }

        //ord
        //Betegner indeksplassen til bokstaven som skal legges til
        int indeks = 0;
        while (true) {
            //itererer gjennom alle ordene
            for (String ord : s) {
                //Hvis indeks er mindre enn lengden til ordet, legger vi til bokstaven som er på ord[indeks] [
                if (indeks < ord.length()) mergedString += ord.charAt(indeks);
            }
            //når alle ordene har blitt gått gjennom og bokstavene på ord[indeks] er lagt til, må vi oppdatere for å igjen iterere på alle ordene og legge til neste bokstav
            indeks++;

            if (indeks >= targetLength) break;
        }

        return mergedString;

    }

    public static void main(String[] args) {
        //System.out.println(flett("IJKLMN","OPQ"));
        //System.out.println(flett("ABC", "DEF"));
        //System.out.println(flett("", "deff"));
        //System.out.println(flett("ACEGIK", "BDFHJLMN"));
        System.out.println(flett("AM ", "L", "GEDS", "ORATKRR", "","R TRTE", "IO", "TGAUU"));
    }
}
