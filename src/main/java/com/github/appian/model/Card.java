package com.github.appian.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Card {

    private Suit suit;
    private CardValue cardValue;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            Card card = (Card) obj;
            return this.suit == card.suit &&
                   this.cardValue == card.cardValue;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.suit.hashCode();
        hash = 31 * hash + this.cardValue.hashCode();
        return hash;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return "Card suit is ::: " + suit + ", and cardValue is ::: " + cardValue;
    }

}
