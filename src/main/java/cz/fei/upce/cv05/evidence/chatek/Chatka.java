package cz.fei.upce.cv05.evidence.chatek;

import static cz.fei.upce.cv05.evidence.chatek.EvidenceChatekApp.MAX_VELIKOST_CHATKY;
import static cz.fei.upce.cv05.evidence.chatek.EvidenceChatekApp.chatky;
import static cz.fei.upce.cv05.evidence.chatek.EvidenceChatekApp.scanner;

public class Chatka {

    public int cisloChatky;
    public int pocetNavstevniku;

    public Chatka(int cisloChatky, int pocetNavstevniku) { 
        this.cisloChatky = cisloChatky;
        this.pocetNavstevniku = pocetNavstevniku;
    }

    private static int zadejCisloChatky() {
        // Ziskani cisla chatky od uzivatele
        System.out.print("Zadej cislo chatky: ");
        // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0
        return scanner.nextInt() - 1;
    }

    private static boolean osetriIndex(int index) {
        // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
        if (index < 0 || index >= chatky.length) {
            System.err.println("Tato chatka neexistuje");
            return false;
        }
        return true;
    }

    private static int zadejPocetNavstevniku() {
        // Ziskani poctu navstevniku, kteri se chteji v chatce ubytovat
        System.out.print("Zadej pocet navstevniku: ");
        return scanner.nextInt();
    }

    static void vypisVsechnyChatky() {
        for (Chatka c : chatky) {
            System.out.println("Chatka[" + c.cisloChatky + "] = "
                    + c.pocetNavstevniku);
        }
    }

    static void vypisKonretniChatku() {
        int index = zadejCisloChatky();
        if (osetriIndex(index)) {
            System.out.println("Chatka[" + chatky[index].cisloChatky + "] = "
                    + chatky[index].pocetNavstevniku);
        }
    }

    static void pridejNavstevniky() {
        int index = zadejCisloChatky();

        //Když index není menší než 0 a zároveň, když není větší než počet chatek
        if (osetriIndex(index)) {
            int pocetNavstevniku = zadejPocetNavstevniku();

            // Zaporne cislo nebo prilis velky nevalidni vstup
            if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {
                System.err.println("Neplatna hodnota pro pocet navstevniku");
            } else {
                // Pokud je pocet uz ubytovanych plus ty co se chteji ubytovat vetsi 
                //nez kapacita chatky je to nevalidni vstup
                if ((chatky[index].pocetNavstevniku + pocetNavstevniku)
                        > MAX_VELIKOST_CHATKY) {
                    System.err.println("Prekrocen maximalni pocet navstevniku chatky");

                } else {
                    // Pridej nove ubytovane do chatky k tem co uz tam jsou
                    chatky[index].pocetNavstevniku += pocetNavstevniku;
                }
            }
        }
    }

    static void odeberNavstevnika() {
        int index = zadejCisloChatky();

        //Když index není menší než 0 a zároveň, když není větší než počet chatek
        if (osetriIndex(index)) {
            int pocetNavstevniku = zadejPocetNavstevniku();

            // Zaporne cislo nebo prilis velky nevalidni vstup
            if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {
                System.err.println("Neplatna hodnota pro pocet navstevniku");
            } else {
                // Pokud je pocet uz ubytovanych minus ty co chteji odejít menší 
                //než nula je to nevalidni vstup
                if ((chatky[index].pocetNavstevniku - pocetNavstevniku) < 0) {
                    System.err.println("Nelze mit záporny pocet navstevniku");
                } else {
                    //Odeber navstěvníky z chatky
                    chatky[index].pocetNavstevniku -= pocetNavstevniku;
                }
            }
        }
    }

    static void vypisCelkovouObsazenost() {
        int obsazenost = 0;

        //Projdi všechny chatky a sečti počet návštěvníků ze všech chatek
        for (Chatka chatka : chatky) {
            obsazenost += chatka.pocetNavstevniku;
        }
        System.out.println("Celkova obsazenost je: " + obsazenost);
    }

    static void vypisPrazdneChatky() {
        //Projdi všechny chatky a vypiš ty, které mají pocetNavstěvniku 0
        for (Chatka chatka : chatky) {
            if (chatka.pocetNavstevniku == 0) {
                System.out.println("Chatka[" + chatka.cisloChatky + "]");
            }
        }
    }
}
