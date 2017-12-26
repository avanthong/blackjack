package com.blackjack;

import com.blackjack.lib.heuristics.InteractiveHeuristic;
import com.blackjack.lib.heuristics.TheBookHeuristic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BlackJack bj = new BlackJack(2);
        Scanner reader = new Scanner(System.in);
        System.out.println("Let's play Black Jack!");
        System.out.println("How many games to play? ");
        int numGames = Integer.parseInt(reader.nextLine());
        InteractiveHeuristic heuristic = new InteractiveHeuristic();
        TheBookHeuristic bookHeuristic = new TheBookHeuristic();
        bj.setPlayerHeuristic(0, bookHeuristic);
        bj.setPlayerHeuristic(1, heuristic);
        for (int i = 0; i < numGames; i++) {
            System.out.println("New round! This is round #" + i);
            bj.nextMatch();
            bj.dealAll();
            bj.playPlayers();
            bj.playDealer();
            System.out.println(bj);
            System.out.println("Winners: " + bj.getWinners());
        }
        System.out.println("All rounds completed!");
    }
}
