import java.util.HashMap;

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
        char[] b = a.clone();

        if (a.length <= 1) {
            return; // Sjekker om tabellen er tom eller har ett element. Gjør ingenting hvis kravet blir oppfylt.
        }
        
        for (int i = 0; i < a.length; i++) {
            int pos = ((i+k) % a.length); // tar høyde for om k > a.length
            if (pos < 0) pos += a.length; // Hvis k er et negativt tall, legger vi til arrayens lengde for å ta høyde for dette
            b[pos] = a[i];
        }

        System.arraycopy(b, 0, a, 0, a.length);

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

    //oppgave 11
    public static boolean inneholdt(String a, String b){        
        // Hashmap som lagrer forekomsten av hver bokstav
        HashMap<Character, Integer> frequency = new HashMap<>();
        
        //1)Itererer gjennom String a, legger til bokstaver i HashMapen om de ikke er der. Hvis bokstaven på a.charAt(i) er i HashMappen, legger den til +1 
        for (int i = 0; i < a.length(); i++){
            frequency.put(a.charAt(i), frequency.getOrDefault(a.charAt(i), 0)+1);
        }
        
        //Itererer gjennom String b. Tanken bak algoritmen er at vi "krysser av" hver gang vi finner en bokstav i String b som eksisterer i String a. Hvis den gjør det, så kjører vi -1 på den bokstaven.
        for (int i = 0; i < b.length(); i++){
            
            if (frequency.containsKey(b.charAt(i))) { //Sjekker først om bokstaven på b.charAt(i) eksistererer i hashmappen. 
                if (frequency.get(b.charAt(i)) > 0) { // Sjekker om verdien er 0. Hvis den er 0, så har vi "krysset av" for alle forekomster av bokstaven i String b
                    frequency.put(b.charAt(i), frequency.get(b.charAt(i))-1); //Bokstaven er i String b, og vi krysser av for den
                }
            }
        }
        // Sjekker om frekvensen av hver bokstav er krysset av. Hvis bare én ikke er 0, betyr det i praksis at String b ikke inneholder String a, og dermed returnerer vi false
        for (Integer letterFrequency : frequency.values()){
            if (letterFrequency > 0) {
                return false;
            }
        }

        return true;
        
        /*
        for (int i = 0; i < b.length(); i++){
            if (b.charAt(0) == aIsNowAnArray[indeks]){
                indeks++;
            }
            if (indeks == b.length()){
                return true;
            }
        }
        return false;*/
    }

    public static void main(String[] args) {
        //System.out.println(flett("IJKLMN","OPQ"));
        //System.out.println(flett("ABC", "DEF"));
        //System.out.println(flett("", "deff"));
        //System.out.println(flett("ACEGIK", "BDFHJLMN"));
        //System.out.println(flett("AM ", "L", "GEDS", "ORATKRR", "","R TRTE", "IO", "TGAUU"));

        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] b = {'A', 'B'};
        rotasjon(a, -16);
        rotasjon(b, -1);
        
        System.out.println(inneholdt("ABBA", "ABCDE"));
    }
}
