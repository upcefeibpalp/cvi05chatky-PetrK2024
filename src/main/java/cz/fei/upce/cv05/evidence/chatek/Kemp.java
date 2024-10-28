package cz.fei.upce.cv05.evidence.chatek;

import static cz.fei.upce.cv05.evidence.chatek.EvidenceChatekApp.VELIKOST_KEMPU;

public class Kemp {

    // Statický inicializační blok pro naplnění pole
    static Chatka[] vytvorChatky() {
        Chatka[] chatky = new Chatka[VELIKOST_KEMPU];
        for (int i = 0; i < VELIKOST_KEMPU; i++) {
            // Inicializace chatky s číslem a počtem návštěvníků
            chatky[i] = new Chatka(i + 1, 0);
        }
        return chatky;
    } 
}
