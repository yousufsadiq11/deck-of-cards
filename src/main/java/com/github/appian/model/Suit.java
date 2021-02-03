package com.github.appian.model;

/**
 * Suits of a Card
 */
public enum Suit {

    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    HEARTS("Hearts"),
    SPADES("Spades");

    /**
     * Suit name
     */
    private final String name;

    private Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
