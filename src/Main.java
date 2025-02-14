import com.azienda.gestBiblioteca.Biblioteca;
import com.azienda.gestBiblioteca.Libro;
import com.azienda.gestBiblioteca.OperazioneBiblioteca;
import com.azienda.gestBiblioteca.Utente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(10, 10);


        Libro l1 = new Libro("Harry Potter", "J.K.Rowling", "AB001");
        Libro l2 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "AB002");
        Libro l3 = new Libro("Il Codice da Vinci", "Dan Brown", "AB003");
        Libro l4 = new Libro("1984", "George Orwell", "AB004");
        Libro l5 = new Libro("I Promessi Sposi", "Alessandro Manzoni", "AB005");


        biblioteca.aggiungiLibro(l1);
        biblioteca.aggiungiLibro(l2);
        biblioteca.aggiungiLibro(l3);
        biblioteca.aggiungiLibro(l4);
        biblioteca.aggiungiLibro(l5);


        Utente u1 = new Utente("U123", "Marco", "Rossi");
        Utente u2 = new Utente("U456", "Giulia", "Bianchi");
        Utente u3 = new Utente("U789", "Lorenzo", "Verdi");

        biblioteca.registraUtente(u1);
        biblioteca.registraUtente(u2);
        biblioteca.registraUtente(u3);


        System.out.println("\nSTATO INIZIALE DELLA BIBLIOTECA ");
        biblioteca.mostraCatalogo();
        biblioteca.mostraUtentiRegistrati();

        // Loop per l'interazione con l'utente
        boolean continua = true;
        while (continua) {
            System.out.println("\n Scegli un'operazione:");
            for (OperazioneBiblioteca op : OperazioneBiblioteca.values()) {
                System.out.println(op.ordinal() + " - " + op);
            }
            System.out.print("Inserisci il numero dell'operazione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta < 0 || scelta >= OperazioneBiblioteca.values().length) {
                System.out.println(" Scelta non valida!");
                continue;
            }

            OperazioneBiblioteca operazione = OperazioneBiblioteca.values()[scelta];

            switch (operazione) {
                case MOSTRA_CATALOGO:
                    biblioteca.mostraCatalogo();
                    break;

                case MOSTRA_UTENTI:
                    biblioteca.mostraUtentiRegistrati();
                    break;

                case PRESTITO_LIBRO:
                    System.out.print("Inserisci l'ID utente: ");
                    String idUtente = scanner.nextLine();
                    System.out.print("Inserisci l'ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    biblioteca.prestitoLibro(idUtente, isbn);
                    break;

                case RESTITUZIONE_LIBRO:
                    System.out.print("Inserisci l'ID utente: ");
                    idUtente = scanner.nextLine();
                    System.out.print("Inserisci l'ISBN del libro da restituire: ");
                    isbn = scanner.nextLine();
                    biblioteca.restituzioneLibro(idUtente, isbn);
                    break;

                case ESCI:
                    System.out.println("👋 Chiusura del sistema...");
                    continua = false;
                    break;
            }
        }

        System.out.println("\n STATO FINALE DELLA BIBLIOTECA");
        biblioteca.mostraCatalogo();
        biblioteca.mostraUtentiRegistrati();

        scanner.close();
    }
}
