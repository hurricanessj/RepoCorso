package com.azienda.gestBiblioteca;

import java.util.Scanner;

public class Libro {
    Scanner in = new Scanner(System.in);
    private String titolo;
    private String autore;
    private String ISBN;
    private boolean disponibile;
    private boolean prestato;


    public Libro() {

    }

    public Libro(String titolo, String autore, String ISBN) {
        this.titolo = titolo;
        this.autore = autore;
        this.ISBN = ISBN;
        this.disponibile = true;
    }


    public boolean isPrestato() {
        return prestato;
    }

    public void setPrestato(boolean prestato) {
        this.prestato = prestato;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }


    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.prestato = !disponibile;
    }

    public String getDettagli() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", ISBN: " + ISBN +
                ", Disponibile: " + (disponibile ? "Sì" : "No");
    }

    public void prestareLibro() {
        if (disponibile) {
            disponibile = false;
            System.out.println("Libro prestato con successo");
        } else {
            System.out.println("Libro non disponibile");
        }
    }

    public void restituireLibro() {
        if (!disponibile) {
            disponibile = true;
            System.out.println("libro restituito con sucesso");
        } else {
            System.out.println("Errore il libro non era in prestito");
        }
    }
}
