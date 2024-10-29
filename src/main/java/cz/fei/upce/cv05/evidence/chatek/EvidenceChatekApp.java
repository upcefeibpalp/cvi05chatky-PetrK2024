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
    
    static Chatka[] chatky = Kemp.vytvorChatky();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int operace;
        
        do {
            System.out.println("""
                    MENU:
                                        
                    1 - Vypsani vsech chatek 
                    2 - Vypsani konkretni chatky
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
                case VYPIS_CHATEK ->
                    Chatka.vypisVsechnyChatky();
                case VYPIS_KONKRETNI_CHATKU ->
                    Chatka.vypisKonretniChatku();
                case PRIDANI_NAVSTEVNIKU ->
                    Chatka.pridejNavstevniky();
                case ODEBRANI_NAVSTEVNIKU ->
                    Chatka.odeberNavstevnika();
                case CELKOVA_OBSAZENOST ->
                    Chatka.vypisCelkovouObsazenost();
                case VYPIS_PRAZDNE_CHATKY ->
                    Chatka.vypisPrazdneChatky();
                case KONEC_PROGRAMU ->
                    System.out.println("Konec programu");
                default -> {
                    System.err.println("Neplatna volba");
                }
            }
        } while (operace != 0);
    }
}
