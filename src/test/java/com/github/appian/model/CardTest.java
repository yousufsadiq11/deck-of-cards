package com.github.appian.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    public void testCardSuit() {
        Card card1 = new Card(Suit.CLUBS, CardValue.ACE);
        Card card2 = new Card(Suit.CLUBS, CardValue.EIGHT);

        Assertions.assertSame(card1.getSuit(), card2.getSuit());
        Assertions.assertNotSame(card1.getCardValue(), card2.getCardValue());
        Assertions.assertNotEquals(card1, card2);
    }

    @Test
    public void testCardValue() {
        Card card1 = new Card(Suit.HEARTS, CardValue.TEN);
        Card card2 = new Card(Suit.SPADES, CardValue.TEN);

        Assertions.assertNotSame(card1.getSuit(), card2.getSuit());
        Assertions.assertSame(card1.getCardValue(), card2.getCardValue());
        Assertions.assertNotEquals(card1, card2);
    }

    @Test
    public void testCardEqualsFunctionality() {
        Card card1 = new Card(Suit.DIAMONDS, CardValue.FIVE);
        Card card2 = new Card(Suit.DIAMONDS, CardValue.FIVE);
        Card card3 = new Card(Suit.CLUBS, CardValue.THREE);
        Card card4 = new Card(Suit.CLUBS, CardValue.FOUR);

        // assertions for two same cards
        Assertions.assertSame(card1.getCardValue(), card2.getCardValue());
        Assertions.assertSame(card1.getSuit(), card2.getSuit());
        Assertions.assertEquals(card1, card2);
        Assertions.assertEquals(card1.hashCode(), card2.hashCode());

        // assertions for different cards
        Assertions.assertNotSame(card3.getCardValue(), card4.getCardValue());
        Assertions.assertSame(card3.getSuit(), card4.getSuit());
        Assertions.assertNotEquals(card3, card4);
        Assertions.assertNotEquals(card3.hashCode(), card4.hashCode());
    }

}