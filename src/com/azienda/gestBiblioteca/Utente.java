package com.azienda.gestBiblioteca;

public class Utente {
    private String nomeUtente;
    private String cognomeUtente;
    private String IDUtente;
    private Libro[] listaPrestiti;
    private int numeroLibri;

    public Utente() {
    }

    public Utente(String nomeUtente, String cognomeUtente, String IDUtente){
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.IDUtente = IDUtente;
        this.listaPrestiti = new Libro[3];
        this.numeroLibri = 0;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }

    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    public String getIDUtente() {
        return IDUtente;
    }

    public void setIDUtente(String IDUtente) {
        this.IDUtente = IDUtente;
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public void setNumeroLibri(int numeroLibri) {
        this.numeroLibri = numeroLibri;
    }

    public Libro[] getListaPrestiti() {
        return listaPrestiti;
    }

    public void setListaPrestiti(Libro[] listaPrestiti) {
        this.listaPrestiti = listaPrestiti;
    }

    public void prendereInPrestito(Libro libro){
        if (numeroLibri < 3 && libro.isDisponibile()) {
            listaPrestiti[numeroLibri] = libro;
            numeroLibri++;
            libro.setDisponibile(false);
            System.out.println(libro.getTitolo() + " è stato preso in prestito.");
        } else if (numeroLibri >= 3) {
            System.out.println("Non puoi prendere più di 3 libri in prestito.");
        } else {
            System.out.println(libro.getTitolo() + " non è disponibile.");
        }
    }

    public void restituireLibro(Libro libro) {
        boolean trovato = false;
        for (int i = 0; i < numeroLibri; i++) {
            if (listaPrestiti[i].equals(libro)) {
                listaPrestiti[i] = listaPrestiti[numeroLibri - 1];
                listaPrestiti[numeroLibri - 1] = null;
                numeroLibri--;
                libro.setDisponibile(true);
                trovato = true;
                System.out.println(libro.getTitolo() + " è stato restituito.");
                break;
            }
        }
        if (!trovato) {
            System.out.println("Non hai preso in prestito questo libro.");
        }
    }

    public void mostraLibriInPrestito() {
        if (numeroLibri == 0) {
            System.out.println("Non hai preso alcun libro in prestito.");
        } else {
            System.out.println("Libri presi in prestito:");
            for (int i = 0; i < numeroLibri; i++) {
                System.out.println(listaPrestiti[i].getTitolo());
            }
        }
    }

}
