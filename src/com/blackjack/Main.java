package com.blackjack;

import com.blackjack.lib.heuristics.InteractiveHeuristic;
import com.blackjack.lib.heuristics.TheBookHeuristic;

public class Main {

    public static void main(String[] args) {
        System.out.println("Let's play Black Jack!");
        BlackJack bj = new BlackJack(2);
        bj.dealAll();
        InteractiveHeuristic heuristic = new InteractiveHeuristic();
        TheBookHeuristic bookHeuristic = new TheBookHeuristic();
        bj.setPlayerHeuristic(0, bookHeuristic);
        bj.setPlayerHeuristic(1, heuristic);
        bj.playPlayers();
        bj.playDealer();
        System.out.println(bj);
        System.out.println("Winners: " + bj.getWinners());

        //TODO: remove this comment
        /*
        Idea for another game: Card version of "Elements".
        Counters can remove value from the opponent's played cards.
        Un-countered cards add up to the player's total points.
        Special abilities for K/Q/J/A?
        First person to reach 21 wins. (OR: more pts after 3 turns?)
         */
    }
}
