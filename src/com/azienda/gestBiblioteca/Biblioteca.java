package com.azienda.gestBiblioteca;

import java.util.Scanner;

public class Biblioteca {
    private Libro[] catalogoLibri;
    private Utente[] utentiRegistrati;
    private int numeroLibri;
    private int numeroUtenti;
    Scanner in = new Scanner(System.in);

    public Biblioteca() {
    }

    public Biblioteca(int maxLibri, int maxUtenti) {
        this.catalogoLibri = new Libro[maxLibri];
        this.utentiRegistrati = new Utente[maxUtenti];
        this.numeroLibri = 0;
        this.numeroUtenti = 0;
    }

    public Libro[] getCatalogoLibri() {
        return catalogoLibri;
    }

    public void setCatalogoLibri(Libro[] catalogoLibri) {
        this.catalogoLibri = catalogoLibri;
    }

    public Utente[] getUtentiRegistrati() {
        return utentiRegistrati;
    }

    public void setUtentiRegistrati(Utente[] utentiRegistrati) {
        this.utentiRegistrati = utentiRegistrati;
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public void setNumeroLibri(int numeroLibri) {
        this.numeroLibri = numeroLibri;
    }

    public int getNumeroUtenti() {
        return numeroUtenti;
    }

    public void setNumeroUtenti(int numeroUtenti) {
        this.numeroUtenti = numeroUtenti;
    }

    public void aggiungiLibro(Libro libro){
        if (numeroLibri < catalogoLibri.length) {
            catalogoLibri[numeroLibri] = libro;
            numeroLibri++;
            System.out.println("Libro aggiunto al catalogo: " + libro.getTitolo());
        } else {
            System.out.println("Il catalogo è pieno, non è possibile aggiungere altri libri.");
        }
    }
    public void registraUtente(Utente utente) {
        if (numeroUtenti < utentiRegistrati.length) {
            utentiRegistrati[numeroUtenti] = utente;
            numeroUtenti++;
            System.out.println("Utente registrato: " + utente.getNomeUtente() + " " + utente.getCognomeUtente());
        } else {
            System.out.println("Il numero massimo di utenti è stato raggiunto.");
        }
    }

    private Utente trovaUtente(String idUtente) {
        for (int i = 0; i < numeroUtenti; i++) {
            if (utentiRegistrati[i] != null && utentiRegistrati[i].getIDUtente().equals(idUtente)) {
                return utentiRegistrati[i];
            }
        }
        return null;
    }

    private Libro trovaLibroPerISBN(String ISBN) {
        for (int i = 0; i < numeroLibri; i++) {
            if (catalogoLibri[i] != null && catalogoLibri[i].getISBN().equals(ISBN)) {
                return catalogoLibri[i];
            }
        }
        return null;
    }


    public void prestitoLibro(String idUtente, String ISBN) {
        Utente utente = trovaUtente(idUtente);
        Libro libro = trovaLibroPerISBN(ISBN);

        if (utente != null && libro != null) {
            utente.prendereInPrestito(libro);
        } else {
            System.out.println("Operazione fallita: utente o libro non trovati.");
        }
    }

    public void restituzioneLibro(String idUtente, String ISBN) {
        Utente utente = trovaUtente(idUtente);
        Libro libro = trovaLibroPerISBN(ISBN);

        if (utente != null && libro != null) {
            if (libro.isPrestato()) {
                utente.restituireLibro(libro);
                libro.setDisponibile(true);
                System.out.println("Il libro '" + libro.getTitolo() + "' è stato restituito con successo.");
            } else {
                System.out.println("Il libro '" + libro.getTitolo() + "' non è stato preso in prestito.");
            }
        } else {
            System.out.println("Operazione fallita: utente o libro non trovati.");
        }
    }


    public void mostraCatalogo() {
        System.out.println("Catalogo della Biblioteca");
        for (int i = 0; i < numeroLibri; i++) {
            if (catalogoLibri[i] != null) {
                String stato = catalogoLibri[i].isDisponibile() ? "Disponibile" : "Non disponibile";
                System.out.println("Titolo: " + catalogoLibri[i].getTitolo() +
                        " | ISBN: " + catalogoLibri[i].getISBN() +
                        " | Stato: " + stato);
            }
        }
    }

    public void mostraUtentiRegistrati() {
        System.out.println(" Elenco Utenti Registrati");
        for (int i = 0; i < numeroUtenti; i++) {
            if (utentiRegistrati[i] != null) {
                System.out.println("ID: " + utentiRegistrati[i].getIDUtente() +
                        " | Nome: " + utentiRegistrati[i].getNomeUtente() +
                        " | Cognome: " + utentiRegistrati[i].getCognomeUtente());
            }
        }
    }
}
