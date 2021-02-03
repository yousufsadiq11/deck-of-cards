package com.github.appian.operations;

import com.github.appian.model.Card;
import com.github.appian.model.CardValue;
import com.github.appian.model.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckOperationTest {

    private static final int DECK_SIZE = 52;

    @Test
    public void testDeckSizeAfterInitialization() {
        List<Card> cardsList = new DeckOperation().cardsList;

        assertEquals(DECK_SIZE, cardsList.size());
    }

    @Test
    public void testIfAllCardsArePresentInDeckAfterInitialization() {
        List<Card> cardsList = new DeckOperation().cardsList;

        for (Suit suit : Suit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                for (Iterator<Card> iterator = cardsList.iterator(); iterator.hasNext(); ) {
                    Card card = iterator.next();
                    if (card.getCardValue() == cardValue && card.getSuit() == suit) {
                        iterator.remove();
                        break;
                    }
                }
            }
        }

        assertEquals(0, cardsList.size());
    }

    @Test
    public void testDealOneCardOperation() {
        DeckOperation deckOperation = new DeckOperation();

        // dealOneCard operation should retrieve a card for 52 times which is Deck Size
        for (int i = 1; i <= DECK_SIZE; i++) {
            Assertions.assertNotNull(deckOperation.dealOneCard());
        }

        // After 52 calls to dealOneCard it should return null
        Assertions.assertNull(deckOperation.dealOneCard());
    }

    @Test
    public void testShuffleOperation() {
        DeckOperation deckOperation1 = new DeckOperation();
        DeckOperation deckOperation2 = new DeckOperation();

        // shuffling deck1
        deckOperation1.shuffle();

        List<Card> shuffledCards = deckOperation1.cardsList;
        List<Card> unShuffledCards = deckOperation2.cardsList;

        // ensuring all cards from deck1 are available in deck2 after the shuffle
        int invalidShuffledCards = 0;
        for (int i = 0; i < DECK_SIZE; i++) {
            Card shuffledCard = shuffledCards.get(i);
            if (!unShuffledCards.contains(shuffledCard)) {
                Assertions.fail();
            }
        }
    }

}