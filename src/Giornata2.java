import java.time.LocalDate;
import java.util.Scanner;

public class Giornata2 {
    static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        stringaPariDispari();
        annoBisestile();
        LocalDate now = LocalDate.now();
        System.out.print(now.getYear());

        LocalDate data = LocalDate.of(2025, 2, 11);

        // Chiama il metodo e passa l'oggetto LocalDate
        stampaDataCompleta(data);


    }

    public static void stringaPariDispari() {
        System.out.println("inserisci una stringa:\n");
        String stringa = in.nextLine();
        int lunghezza = stringa.length();
        if (lunghezza % 2 == 0) {
            System.out.println("la lunghezza della stringa e' pari");
        } else {
            System.out.println("la lunghezza della stinga e' dispari");
        }
        System.out.println("la lunghezza della stringa e' " + stringa.length());
    }

    /* metodo fatto da Emanuele Umberto
    public static boolean stringaPariDispari() {
        System.out.println("inserisci una stringa:\n");
        String stringa = in.next();
        int lunghezza = stringa.length();
        if (lunghezza % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }*/

    public static void annoBisestile() {
        System.out.println("Inserisci un anno:\n");
        int anno = in.nextInt();

        if ((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0)) {
            System.out.println("Il tuo anno è bisestile");
        } else {
            System.out.println("Il tuo anno non è bisestile");
        }
    }

    /* metodo fatto da Emanuele Umberto
    public static boolean annoBisestile() {
        System.out.println("Inserisci un anno:");
        int anno = Integer.parseInt(in.nextLine());

        if ((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }*/


    //1) stampa mese per passare un oggetto di tipo local date come parametro del metodo e stamare a video la data completa
    // nel seguente formato (11- febbraio -2025)
    //2)  stampa stagione dove passare localDade e stampare a video la stagione corrispondente

    public static void stampaDataCompleta(LocalDate data) {
        // Ottieni il numero del mese
        int mese = data.getMonthValue();  // Restituisce il mese numerico (1-12)

        // Usa uno switch per determinare il nome del mese
        String nomeMese;
        switch (mese) {
            case 1: nomeMese = "Gennaio"; break;
            case 2: nomeMese = "Febbraio"; break;
            case 3: nomeMese = "Marzo"; break;
            case 4: nomeMese = "Aprile"; break;
            case 5: nomeMese = "Maggio"; break;
            case 6: nomeMese = "Giugno"; break;
            case 7: nomeMese = "Luglio"; break;
            case 8: nomeMese = "Agosto"; break;
            case 9: nomeMese = "Settembre"; break;
            case 10: nomeMese = "Ottobre"; break;
            case 11: nomeMese = "Novembre"; break;
            case 12: nomeMese = "Dicembre"; break;
            default: nomeMese = "Mese non valido"; break;
        }

        // Definisci il formato della data
        String dataFormattata = String.format("%d - %s - %d", data.getDayOfMonth(), nomeMese, data.getYear());

        // Stampa la data formattata
        System.out.println(dataFormattata);
    }


    public static void stampaStagione(LocalDate data) {
        // Ottieni il numero del mese
        int mese = data.getMonthValue();  // Restituisce il mese numerico (1-12)

        // Usa uno switch per determinare la stagione
        String stagione;
        switch (mese) {
            case 12: case 1: case 2:
                stagione = "Inverno";
                break;
            case 3: case 4: case 5:
                stagione = "Primavera";
                break;
            case 6: case 7: case 8:
                stagione = "Estate";
                break;
            case 9: case 10: case 11:
                stagione = "Autunno";
                break;
            default:
                stagione = "Stagione non valida";
                break;
        }

        // Stampa la stagione
        System.out.println("La stagione per la data " + data + " è: " + stagione);
    }
}
