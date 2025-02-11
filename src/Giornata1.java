import java.util.Scanner;

public class Giornata1 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        double som = somma();
        double diff = differenza();
        double molt = moltiplicazione();
        double div = divisione();
        concatena(som, diff, molt, div);

    }

    public static double somma() {
        System.out.println("Inserisci il primo numero da sommare:");
        double a = in.nextDouble();
        System.out.println("Inserisci il secondo numero da sommare:");
        double b = in.nextDouble();
        double som = a = b;
        return som;
    }

    public static double differenza() {
        System.out.println("Inserisci il primo numero da sottrarre:");
        double a = in.nextDouble();
        System.out.println("Inserisci il secondo numero da sottrarre:");
        double b = in.nextDouble();
        double diff = a - b;
        return diff;
    }

    public static double moltiplicazione() {
        System.out.println("Inserisci il primo numero da moltiplicare:");
        double a = in.nextDouble();
        System.out.println("Inserisci il secondo numero da moltiplicare:");
        double b = in.nextDouble();
        double molt = a * b;
        return molt;
    }

    public static double divisione() {
        System.out.println("Inserisci il primo numero da dividere:");
        double a = in.nextDouble();
        System.out.println("Inserisci il secondo numero da dividere:");
        double b = in.nextDouble();
        double div = a / b;
        return div;
    }

    public static void concatena(double risultatoAd, double risultatoSot, double risultatoMolt, double risultatoDiv) {
        System.out.println("Risultati:");
        System.out.println("Addizione: " + risultatoAd);
        System.out.println("Sottrazione: " + risultatoSot);
        System.out.println("Moltiplicazione: " + risultatoMolt);
        System.out.println("Divisione: " + risultatoDiv);
    }
}
