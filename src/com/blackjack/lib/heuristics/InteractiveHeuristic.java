package com.blackjack.lib.heuristics;


import com.blackjack.lib.Player;

import java.util.Scanner;

/**
 * This heuristic interactively asks the user whether they want to hit or stay.
 * It does not decide on its own.
 */
public class InteractiveHeuristic implements BlackJackHeuristic {
    /**
     * In this heuristic, both the player hand and dealer hands are ignored.
     * Since it is up to the user to decide.
     * @param myHand The current player's hand.
     * @param dealerHand The dealer's hand.
     * @return true if the user asked to hit.
     */
    public boolean isHitCondition(Player myHand, Player dealerHand) {
        System.out.println(dealerHand);
        System.out.println(myHand);
        Scanner reader = new Scanner(System.in);
        System.out.println("(h)it or (s)tay?\nYour choice (h, s): ");
        if (reader.nextLine().equals("h")) {
            return true;
        }
        return false;
    }
}
