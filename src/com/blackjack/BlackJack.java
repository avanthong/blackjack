package com.blackjack;

import com.blackjack.lib.Deck;
import com.blackjack.lib.Player;
import com.blackjack.lib.heuristics.DealerHeuristic;
import com.blackjack.lib.heuristics.BlackJackHeuristic;

import java.util.ArrayList;

public class BlackJack {
    private ArrayList<Player> playerHands;
    private Player dealerHand;
    private Deck deck;
    private BlackJackHeuristic dealerHeuristic;

    public BlackJack(int numPlayers) {
        playerHands = new ArrayList<Player>(numPlayers);
        for (int i = 0; i < numPlayers; i++)
            playerHands.add(new Player("Player " + String.valueOf(i + 1)));
        dealerHand = new Player("Dealer");
        deck = new Deck();
        deck.shuffle();
        dealerHeuristic = new DealerHeuristic();
        //Burn the top card of the deck, per tradition:
        System.out.println("Burn card is: " + deck.deal());
    }

    /**
     * Update a given player's heuristic
     * @param playerIndex The index of the player to update
     * @param heuristic The heuristic the player will use.
     */
    public void setPlayerHeuristic(int playerIndex, BlackJackHeuristic heuristic) {
        Player tmp = playerHands.get(playerIndex);
        tmp.setHeuristic(heuristic);
        playerHands.set(playerIndex, tmp);
        System.out.println("Setting " + tmp.getName() + "'s heuristic to: " + heuristic.getClass().getSimpleName());
    }

    /**
     * Deals two cards to all playerHands and the dealerHand
     */
    public void dealAll() {
        playerHands.forEach( (player) -> player.addCard(deck.deal()) );
        dealerHand.addCard(deck.deal());
        if (dealerHand.numCards() < 2) {
            dealAll();
        }
    }

    /**
     * Determines which players won the game - their total value is greater than
     * the dealer's and is not greater than 21. The dealer cannot be included in
     * this list of winning players.
     * @return Player objects who have beat the dealer
     */
    public ArrayList<Player> getWinners() {
        ArrayList<Player> winners = new ArrayList<Player>(0);
        playerHands.forEach( (playerHand) -> {
            if (playerHand.getValue() <= 21 && (dealerHand.getValue() > 21 || 
                    playerHand.getValue() > dealerHand.getValue())) {
                winners.add(playerHand);
                playerHand.addWin();
            }
        });
        return winners;
    }

    /**
     * Play out each players' turn for one round
     */
    public void playPlayers() {
        playerHands.forEach( (playerHand) -> {
            while (playerHand.isHitting(dealerHand)) {
                playerHand.addCard(deck.deal());
                System.out.println(playerHand.getName() + " is hitting . . .");
            }
        });
    }

    /**
     * Play out the dealer's turn for one round.
     */
    public void playDealer() {
        while (dealerHeuristic.isHitCondition(new Player(""), dealerHand)) {
            dealerHand.addCard(deck.deal());
            System.out.println("Dealer is hitting.");
        }
    }

    /**
     * Sets up the next match by discarding everyone's hands.
     * Does not re-shuffle the deck unless there are less than 15 cards left.
     */
    public void nextMatch() {
        dealerHand.discardHand();
        for (Player player : playerHands) {
            player.discardHand();
        }
        if (deck.size() <= 15) {
            System.out.println("Deck is getting low. Shuffling deck.");
            deck.shuffle();
        }
    }

    public String toString() {
        String s = dealerHand + "\n";
        for (Player p : playerHands) {
            s += p + "\n";
        }
        return s;
    }
}
