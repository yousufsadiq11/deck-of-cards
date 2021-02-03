package com.github.appian;

import com.github.appian.model.Card;
import com.github.appian.operations.DeckOperation;
import lombok.extern.java.Log;

@Log
public class MainApplication {


    public static void main(String[] args) {
        log.info("------ Welcome to Deck of Cards ------");

        DeckOperation deckOperation = new DeckOperation();
        deckOperation.shuffle();

        int num = 1;
        while (true) {
            Card card = deckOperation.dealOneCard();
            if (card == null) {
                break;
            } else {
                log.info(card.toString());
            }
            num++;
        }
    }

}
