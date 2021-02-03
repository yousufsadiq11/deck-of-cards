package com.github.appian.operations;

import com.github.appian.model.Card;
import com.github.appian.model.CardValue;
import com.github.appian.model.Suit;
import lombok.extern.java.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Log
public class DeckOperation {

    protected final List<Card> cardsList = new ArrayList<>();

    public DeckOperation() {
        for (Suit suit : Suit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                cardsList.add(new Card(suit, cardValue));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if (obj == this) {
            isEquals = true;
        } else {
            DeckOperation cardsDeck = (DeckOperation) obj;
            if (cardsDeck.cardsList.size() == this.cardsList.size()) {
                isEquals = true;
                for (int i = 0; i < cardsDeck.cardsList.size(); i++) {
                    if (!cardsDeck.cardsList.get(i).equals(this.cardsList.get(i))) {
                        isEquals = false;
                        break;
                    }
                }
            }
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int index = 1;
        for (Card card : cardsList) {
            hash = 31 * hash * index + card.hashCode();
            index++;
        }
        return hash;
    }

    /**
     * Shuffles the cards using random shuffle algorithm
     */
    public void shuffle() {
        log.info("-------- Shuffling Operation on Deck -------- ");

        Random random = new Random();
        int size = cardsList.size();
        for (int i = 0; i < size; i++) {
            int swapIndex = random.nextInt(size);

            if (swapIndex != i) {
                Card temp = cardsList.get(i);
                cardsList.set(i, cardsList.get(swapIndex));
                cardsList.set(swapIndex, temp);
            }
        }
    }

    /**
     * returns null for an empty deck and removes the last card from the list when list is not empty
     */
    public Card dealOneCard() {
        log.info("------ Deal One Card Operation ------");
        if (cardsList.size() == 0) {
            log.info("------ Empty Deck ------");
            return null;
        }
        Card card = cardsList.remove(cardsList.size() - 1);
        log.info(String.format("Card Dealt with suit ::: %s and value ::: %s", card.getSuit(), card.getCardValue()));
        return card;
    }

}
