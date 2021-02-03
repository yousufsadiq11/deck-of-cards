package com.github.appian.model;

/**
 * Various Values a card can have
 */
public enum CardValue {
    ACE("Ace"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    KING("King"),
    QUEEN("Queen"),
    JACK("Jack");

    private final String name;

    private CardValue(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
