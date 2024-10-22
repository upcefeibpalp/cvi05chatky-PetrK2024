package cz.fei.upce.cv05.evidence.chatek;

import java.util.Scanner;

public class EvidenceChatekApp {

    static final int KONEC_PROGRAMU = 0;
    static final int VYPIS_CHATEK = 1;
    static final int VYPIS_KONKRETNI_CHATKU = 2;
    static final int PRIDANI_NAVSTEVNIKU = 3;
    static final int ODEBRANI_NAVSTEVNIKU = 4;
    static final int CELKOVA_OBSAZENOST = 5;
    static final int VYPIS_PRAZDNE_CHATKY = 6;

    static final int VELIKOST_KEMPU = 10;
    static final int MAX_VELIKOST_CHATKY = 5;
    static int[] chatky = new int[VELIKOST_KEMPU];

    public static void main(String[] args) {
        // Konstanty pro definovani jednotlivych operaci (pouze pro cisty kod)
        Scanner scanner = new Scanner(System.in);

        // Definovani pole podle velikosti kempu (poctu chatek)
        int operace;

        do {
            System.out.println("""
                    MENU:
                                        
                    1 - vypsani vsech chatek
                    2 - vypsani konkretni chatky
                    3 - Pridani navstevniku
                    4 - Odebrani navstevniku
                    5 - Celkova obsazenost kempu
                    6 - Vypis prazdne chatky
                    0 - Konec programu
                    """);

            // Ziskani operace od uzivatele
            System.out.print("Zadej volbu: ");
            operace = scanner.nextInt();

            switch (operace) {
                case VYPIS_CHATEK -> {

                    vypisVsechnyChatky();
                }

                case VYPIS_KONKRETNI_CHATKU -> {
                    vypisKonretniChatku(scanner);
                }

                case PRIDANI_NAVSTEVNIKU -> {
                    pridejNavstevniky(scanner);
                }

                case ODEBRANI_NAVSTEVNIKU -> {
                    //odeberNavstevnika();
                }

                case CELKOVA_OBSAZENOST -> {
                    vypisCelkovouObsazenost();
                }

                case VYPIS_PRAZDNE_CHATKY -> {
                    // TODO
                }

                case KONEC_PROGRAMU -> {
                    System.out.println("Konec programu");
                }

                default -> {
                    System.err.println("Neplatna volba");
                }
            }
        } while (operace != 0);
    }

    private static void vypisVsechnyChatky() {
        for (int i = 0; i < chatky.length; i++) {
            System.out.println("Chatka [" + (i + 1) + "] = " + chatky[i]);
        }
    }

    private static void vypisKonretniChatku(Scanner scanner) {
        // Ziskani cisla chatky od uzivatele
        System.out.print("Zadej cislo chatky: ");
        // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0
        int index = scanner.nextInt() - 1;

        // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
        if (index < 0 || index >= chatky.length) {
            System.err.println("Tato chatka neexistuje");
        }

        System.out.println("Chatka [" + (index + 1) + "] = " + chatky[index]);
    }

    private static void pridejNavstevniky(Scanner scanner) {
        // Ziskani cisla chatky od uzivatele
        System.out.print("Zadej cislo chatky: ");
        // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0
        int cisloChatky = scanner.nextInt() - 1;

        // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
        if (cisloChatky < 0 || cisloChatky >= chatky.length) {
            System.err.println("Tato chatka neexistuje");
            
        }

        // Ziskani poctu navstevniku, kteri se chteji v chatce ubytovat
        System.out.print("Zadej pocet navstevniku: ");
        int pocetNavstevniku = scanner.nextInt();

        // Zaporne cislo nebo prilis velky nevalidni vstup
        if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {
            System.err.println("Neplatna hodnota pro pocet navstevniku");
            
        }

        // Pokud je pocet uz ubytovanych plus ty co se chteji ubytovat vetsi nez kapacita chatky je to nevalidni vstup
        if ((chatky[cisloChatky] + pocetNavstevniku) > MAX_VELIKOST_CHATKY) {
            System.err.println("Prekrocen maximalni pocet navstevniku chatky");
          
        }

        // Pridej nove ubytovane do chatky k tem co uz tam jsou
        chatky[cisloChatky] += pocetNavstevniku;
    }
    private static void odeberNavstevnika(Scanner scanner){
        System.out.println("Zadej cislo chatky: ");
        
        int cisloChatky = scanner.nextInt() - 1;

        // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
        if (cisloChatky < 0 || cisloChatky >= chatky.length) {
            System.err.println("Tato chatka neexistuje");
            
        }

        // Ziskani poctu navstevniku, kteri se chteji v chatce ubytovat
        System.out.print("Zadej pocet navstevniku: ");
        int pocetNavstevniku = scanner.nextInt();

        // Zaporne cislo nebo prilis velky nevalidni vstup
        if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {
            System.err.println("Neplatna hodnota pro pocet navstevniku");
            
        }

        // Pokud je pocet uz ubytovanych plus ty co se chteji ubytovat vetsi nez kapacita chatky je to nevalidni vstup
        if ((chatky[cisloChatky] + pocetNavstevniku) > MAX_VELIKOST_CHATKY) {
            System.err.println("Prekrocen maximalni pocet navstevniku chatky");
          
        }

        // Pridej nove ubytovane do chatky k tem co uz tam jsou
        chatky[cisloChatky] += pocetNavstevniku;
    }
    private static void vypisCelkovouObsazenost(){
        int obsazenost = 0;
        for (int chatka : chatky) {
            obsazenost += chatka;
        }
        System.out.println("Celkova obsazenost je: " + obsazenost);
    }
    private static void vypisPrazdneChatky(){

    }
}
