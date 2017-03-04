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
    }
}
