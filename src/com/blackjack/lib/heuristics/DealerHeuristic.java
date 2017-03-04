package com.blackjack.lib.heuristics;

import com.blackjack.lib.Player;

/**
 * This blackjack heuristics determines whether to hit or not based
 * on the conventional casino blackjack dealer rules.
 */
public class DealerHeuristic implements BlackJackHeuristic {
    /**
     * In this particular case, the dealer's hand and myHand will be the same.
     * In this implementation, only the "dealerHand" will be used.
     * @param myHand The current player's hand. Unused in this implementation.
     * @param dealerHand The dealer's hand.
     * @return True if the dealer has less than 17
     */
    public boolean isHitCondition(Player myHand, Player dealerHand) {
        if (dealerHand.getValue() < 17) {
            return true;
        }
        return false;
    }
}
