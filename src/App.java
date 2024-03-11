
//Importering från java-biblioteket
import java.util.Random;
import java.util.Scanner;

/** Författare: Adrian Eriksson, Te22E
 * Programmet låter användaren få möjligheten att spela en digital version
 * av ett simpelt brädspelsaktigt spel där man med hjälp av tärningar 
 * (slumptalsgeneratorer) spela om sin tur mot datorn och se vem som vinner.
 * Programmet tar in tangentbordinmatningar för menyval (1, 2, 3, andra tecken 
 * (fel)) och fortgång i spelet (ENTER).
 * @author Adrian Eriksson Te22E
 * @version 1.0
 * @since 2024
 */

public class App {
    /** 
     * Hälsopoäng för dator och spelare.
     * Detta är vad som avgör vem som vinner spelet för varje omgång.
     **/
    static int dator_hp;
    static int spelar_hp;

    public static void main(String[] args) throws Exception {
        /* Variabel för att lagra valalternativ som görs när menyn visas. */
        int val = 0;
        
        /** Scanner som låter programmet ta in inforamtion från tangentbordet.
         * Denna tar in inmatningar från tangentbordet och distribuerar informationen
         * till den variabel som är likställd med scannern.
         **/
        Scanner tangentbord = new Scanner(System.in);
        
        while (val != 3) {
            //Startmeny
            System.out.println();
            System.out.println("Välkommen till detta textbaserade spel!");
            System.out.println("Startmeny:");
            System.out.println(" 1. Starta spelet \n 2. Se spelinstruktioner \n 3. Avsluta spelet");
            System.out.print("Val: ");
            val = tangentbord.nextInt();
            tangentbord.nextLine();
            System.out.println();

            //Inställning av antal hälsopoäng
            dator_hp = 5;
            spelar_hp = 5;

            //Kod för att räkna antal attacker
            double attack = 0;
            
            switch (val) {
                case 1:
                    //Spel
                    while (dator_hp != 0 && spelar_hp != 0) {
                        //Kod som skapar tärningar för deltagarna i attacken/matchen
                        Random tärning_dator = new Random();
                        Random tärning_spelare = new Random();

                        //Datorn attackerar spelaren
                        tangentbord.nextLine();
                        attack++;
                        System.out.println("Datorn attackerar!");
                        int slumptal_dator = tärning_dator.nextInt(6);
                        Thread.sleep(100);
                        int slumptal_spelare = tärning_spelare.nextInt(6);
                        String resultat = dator_attack(slumptal_dator, slumptal_spelare);
                        System.out.println(resultat);
                        System.out.print("Spelare: ");
                        System.out.println(spelar_hp);
                        System.out.print("Dator: ");
                        System.out.println(dator_hp);
                        System.out.println();

                        //Kod som kollar ifall någon har hälsopoöng som är lika med noll.
                        if (dator_hp==0) {
                            System.out.println("Du besegrade datorn, denna förs till sjukhus för akut vård i detta nu och ordningsmakten letar efter dig. Bäst att du ligger lågt!");
                            System.out.println("Matchen innehöll "+attack+" attacker.");
                            System.out.println();
                            break;
                        }
                        if (spelar_hp==0) {
                            System.out.println("Du vaknar upp i en sjukhussäng, sjuksköterskan talar om för dig att du legat här i 3 dagar och kräver betalning för att ha räddat livet på dig.");
                            System.out.println("Matchen innehöll "+attack+" attacker.");
                            System.out.println();
                            break;
                        }

                        //Spelaren attackerar datorn
                        tangentbord.nextLine();
                        attack++;
                        System.out.println("Du går till attack nu!");
                        slumptal_spelare = tärning_spelare.nextInt(6);
                        Thread.sleep(100);
                        slumptal_dator = tärning_dator.nextInt(6);
                        resultat = spelar_attack(slumptal_spelare, slumptal_dator);
                        System.out.println(resultat);
                        System.out.print("Spelare: ");
                        System.out.println(spelar_hp);
                        System.out.print("Dator: ");
                        System.out.println(dator_hp);
                        System.out.println();
                        
                        //Kod som kollar ifall någon har hälsopoöng som är lika med noll.
                        if (dator_hp==0) {
                            System.out.println("Du besegrade datorn, denna förs till sjukhus för akut vård i detta nu och ordningsmakten letar efter dig. Bäst att du ligger lågt!");
                            System.out.println("Matchen innehöll "+attack+" attacker.");
                            System.out.println();
                            break;
                        }
                        if (spelar_hp==0) {
                            System.out.println("Du vaknar upp i en sjukhussäng, sjuksköterskan talar om för dig att du legat här i 3 dagar och kräver betalning för att ha räddat livet på dig.");
                            System.out.println("Matchen innehöll "+attack+" attacker.");
                            System.out.println();
                            break;
                        }
                        //Ställer om val-variabeln till noll så att ett nytt val kan göras efter spelet
                        val = 0;
                    }
                    break;
                case 2:
                    //Spelinstruktioner
                    System.out.println("Spelet går ut på att användaren slåss mot datorn utifrån vem som får högst slumpmässigt utvalt tal. Om man träffar förlorar den andra deltagaren hälsopoäng. Oavsett om man träffar eller missar så blir det nästa deltagares tur att attackera därefter så länge inte någon av deltagarna har 0 i hälsopoäng.");
                    System.out.println();
                    break;
                case 3:
                    //Kod för att avsluta spel
                    System.out.println("Spelet avslutades.");
                    System.out.println();
                    break;
                default:
                    //Kod för felaktig inmatning
                    System.out.println("Felaktig inmatning, var god starta om spelet och läs instruktionerna!");
                    System.out.println();
            }
        }
        //Visar programmet att inga fler inmatningar från tangentbordet behöver registreras.
        tangentbord.close();
    }
    //Metoder för spelet
    /** Metoderna tolkar vem som fick högst värde på tärningarna
     * och använder den informationen för att skriva ut en passande text
     * som exempelvis "Datorn träffade!" eller "Datorn missade spelaren!" osv.
     * @param tal1 och tal2 jämförs, om tal1 är lika med tal2 eller högst så träffar datorn spelaren.
     * @return Skickar tillbaka texten "Datorn träffade!" eller "Datorn missade spelaren!" genom variabel
     * vinst eller miss.
     */
    static String dator_attack (int tal1, int tal2){    //När datorn attackerar spelaren.
        if (tal1>=tal2) {
            String vinst = "Datorn träffade!";
            spelar_hp--;
            return vinst;
        }else{
            String miss = "Datorn missade spelaren.";
            return miss;
        }
    }
    /**
    * @param  tal1 och tal2 jämförs, om tal1 är lika med tal2 eller högst så träffar spelaren datorn.
    * @return Skickar tillbaka texten "Du träffade!" eller "Du missade spelaren!" genom variabel
    * vinst eller miss.
    */
    static String spelar_attack (int tal1, int tal2){   //När spelaren attackerar datorn.
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