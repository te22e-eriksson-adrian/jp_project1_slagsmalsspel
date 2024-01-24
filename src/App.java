import java.util.Random;
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
        System.out.println();
        
        //Spel
        if (val==1) {
            Random tärning_dator = new Random();
            Random tärning_spelare = new Random();

            //Datorn attackerar spelaren
            System.out.println("Datorn attackerar!");
            int slumptal_dator = tärning_dator.nextInt(6);
            Thread.sleep(100);
            int slumptal_spelare = tärning_spelare.nextInt(6);
            String resultat = dator_attack(slumptal_dator, slumptal_spelare);
            System.out.println(resultat);
            System.out.println();

            //Spelaren attackerar datorn
            System.out.println("Du går till attack nu!");
            slumptal_spelare = tärning_spelare.nextInt(6);
            Thread.sleep(100);
            slumptal_dator = tärning_dator.nextInt(6);
            resultat = spelar_attack(slumptal_spelare, slumptal_dator);
            System.out.println(resultat);
            System.out.println();
        }

        //Kod för felaktig inmatning
        if (val!=1 && val!=2 && val!=3) {
            System.out.println("Felaktig inmatning, var god starta om spelet och läs instruktionerna!");
        }

        //Kod för att avsluta spel
        if (val==3) {
            System.out.println("Spelet avslutas");
        }
        tangentbord.close();
    }
    static String dator_attack (int tal1, int tal2){
        if (tal1>tal2) {
            String vinst = "Datorn träffade!";
            return vinst;
        }else{
            String miss = "Datorn missade spelaren.";
            return miss;
        }
    }
    static String spelar_attack (int tal1, int tal2){
        if (tal1>tal2) {
            String vinst = "Du träffade!";
            return vinst;
        }else{
            String miss = "Du missade spelaren.";
            return miss;
        }
    }
}
