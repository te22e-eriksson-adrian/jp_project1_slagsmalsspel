import java.util.Random;
import java.util.Scanner;

public class App {
    //Hälsopoäng för dator och spelare
    static int dator_hp = 5;
    static int spelar_hp = 5;

    public static void main(String[] args) throws Exception {
        //Startmeny
        Scanner tangentbord = new Scanner(System.in);
        System.out.println();
        System.out.println("Välkommen till detta textbaserade spel!");
        System.out.println("Startmeny:");
        System.out.println(" 1. Starta spelet \n 2. Se spelinstruktioner \n 3. Avsluta spelet");
        System.out.print("Val: ");
        int val = tangentbord.nextInt();
        tangentbord.nextLine();
        System.out.println();
        
        //Spel
        if (val==1) {
            while (dator_hp != 0 && spelar_hp != 0) {
                Random tärning_dator = new Random();
                Random tärning_spelare = new Random();

                //Datorn attackerar spelaren
                System.out.println("Datorn attackerar!");
                int slumptal_dator = tärning_dator.nextInt(6);
                Thread.sleep(100);
                int slumptal_spelare = tärning_spelare.nextInt(6);
                String resultat = dator_attack(slumptal_dator, slumptal_spelare);
                System.out.println(resultat);
                System.out.println(spelar_hp);
                System.out.println(dator_hp);
                System.out.println();

                //Spelaren attackerar datorn
                System.out.println("Du går till attack nu!");
                slumptal_spelare = tärning_spelare.nextInt(6);
                Thread.sleep(100);
                slumptal_dator = tärning_dator.nextInt(6);
                resultat = spelar_attack(slumptal_spelare, slumptal_dator);
                System.out.println(resultat);
                System.out.println(spelar_hp);
                System.out.println(dator_hp);
                System.out.println();
                
                if (dator_hp==0) {
                    System.out.println("Du besegrade datorn, denna förs till sjukhus för akut vård i detta nu och ordningsmakten letar efter dig. Bäst att du ligger lågt!");
                    System.out.println();
                    break;
                } else {
                    //Datorn attackerar spelaren
                    System.out.println("Datorn attackerar!");
                    slumptal_dator = tärning_dator.nextInt(6);
                    Thread.sleep(100);
                    slumptal_spelare = tärning_spelare.nextInt(6);
                    resultat = dator_attack(slumptal_dator, slumptal_spelare);
                    System.out.println(resultat);
                    System.out.println(spelar_hp);
                    System.out.println(dator_hp);
                    System.out.println();
                }
                if (spelar_hp==0) {
                    System.out.println("Du vaknar upp i en sjukhussäng, sjuksköterskan talar om för dig att du legat här i 3 dagar och kräver betalning för att ha räddat livet på dig.");
                    System.out.println();
                    break;
                } else {
                    //Spelaren attackerar datorn
                    System.out.println("Du går till attack nu!");
                    slumptal_spelare = tärning_spelare.nextInt(6);
                    Thread.sleep(100);
                    slumptal_dator = tärning_dator.nextInt(6);
                    resultat = spelar_attack(slumptal_spelare, slumptal_dator);
                    System.out.println(resultat);
                    System.out.println(spelar_hp);
                    System.out.println(dator_hp);
                    System.out.println();
                }
            }
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
        if (tal1>=tal2) {
            String vinst = "Datorn träffade!";
            spelar_hp--;
            return vinst;
        }else{
            String miss = "Datorn missade spelaren.";
            return miss;
        }
    }
    static String spelar_attack (int tal1, int tal2){
        if (tal1>=tal2) {
            String vinst = "Du träffade!";
            dator_hp--;
            return vinst;
        }else{
            String miss = "Du missade spelaren.";
            return miss;
        }
    }
}
