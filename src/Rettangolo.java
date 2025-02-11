import java.util.Scanner;

public class Rettangolo {
    Scanner in = new Scanner(System.in);
    private double base;
    private double altezza;

    public Rettangolo(double base, double altezza) {
        this.altezza = altezza;
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void RichiediDati(){
        System.out.println("Inserisci la base del rettangolo:");
        this.base = in.nextDouble();

        System.out.println("Inserisci l'altezza del rettangolo:");
        this.altezza = in.nextDouble();
    }

    public double calcolaPerimetro() {
        double perimetro = (base + altezza) * 2;
        return perimetro;
    }

    public double calcolaArea() {
        double area = base * altezza;
        return area;
    }

    @Override
    public String toString(){
        return "Il risultato del perimetro e': "+ calcolaPerimetro() + "\n risultato area: "+ calcolaArea();
    }

}
