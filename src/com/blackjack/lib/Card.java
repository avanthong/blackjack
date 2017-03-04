package com.blackjack.lib;

public class Card {
    public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
    public enum Value {
        ACE (11),
        TWO (2),
        THREE (3),
        FOUR (4),
        FIVE (5),
        SIX (6),
        SEVEN (7),
        EIGHT (8),
        NINE (9),
        TEN (10),
        JACK (10),
        QUEEN (10),
        KING (10);

        private final int value;

        Value(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Suit suit;
    private Value value;

    public Suit getSuit() {
        return suit;
    }

    public void setSuit (Suit newSuit) {
        this.suit = newSuit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value newValue) {
        this.value = newValue;
    }

    public Card(Suit suit, Value value) {
        setSuit(suit);
        setValue(value);
    }

    public String toString() {
        return value.name() + " of " + suit;
    }
}