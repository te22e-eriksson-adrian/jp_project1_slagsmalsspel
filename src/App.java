import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Startmeny
        Scanner tangentbord = new Scanner(System.in);
        System.out.println("Välkommen till detta textbaserade spel!");
        System.out.println("Startmeny:");
        System.out.println(" 1. Starta spelet \n 2. Se spelinstruktioner \n 3. Avsluta spelet");
        System.out.print("Val: ");
        int val = tangentbord.nextInt();
        tangentbord.nextLine();
        
        //Spel
        if (val==1) {
            System.out.println("Hello World!");
        }

        //Kod för felaktig inmatning
        if (val!=1 && val!=2 && val!=3) {
            System.out.println("Felaktig inmatning, var god starta om spelet och läs instruktionerna!");
        }

        //Kod för att avsluta spel
        if (val==3) {
            System.out.println("Spelet avslutas");
        }
    }
}
