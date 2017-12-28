package com.blackjack.lib.heuristics;

import com.blackjack.lib.Player;

/**
 * This heuristic optimizes for never ever busting. Thus, will never hit
 * unless its hand total isless than 12.
 */
public class NeverBustHeuristic implements BlackJackHeuristic {
    public boolean isHitCondition(Player myHand, Player dealerHand) {
        return myHand.getValue() < 12;
    }
}
