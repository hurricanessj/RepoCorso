import java.util.Scanner;

public class eserciziPomeridiani {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Inserisci una stringa: ");
        String input = in.nextLine();

        suddividiStringa(input);
    }
    //metodi

    public static void inserisciStringa() {
        System.out.println("inserisci un testo:\n");
        String txt = in.nextLine();
        System.out.println(txt.length());

        while (txt.length() != 5) {
            System.out.println("inserisci ancora altri caratteri:\n");
            txt = in.nextLine();
        }

        System.out.println("hai raggiunto il massimo dei caratteri prestabiliti");
    }

    public static void suddividiStringa(String str) {

        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length) {
            System.out.print(chars[i]);
            if (i < chars.length - 1) {
                System.out.print(",");
            }
            i++;
        }
    }

    public static void contoAllaRovescia(){

    }

    //una classe e' un raggruppamento concettuale
    //cher definisce le caratteristiche condivise tra tutti gli oggetti



}
