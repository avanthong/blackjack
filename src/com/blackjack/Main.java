package com.blackjack;

import com.blackjack.lib.heuristics.AggressiveHeuristic;
import com.blackjack.lib.heuristics.InteractiveHeuristic;
import com.blackjack.lib.heuristics.NeverBustHeuristic;
import com.blackjack.lib.heuristics.TheBookHeuristic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BlackJack bj = new BlackJack();
        Scanner reader = new Scanner(System.in);
        System.out.println("Let's play Black Jack!");
        System.out.println("How many games to play? ");
        int numGames = Integer.parseInt(reader.nextLine());
        InteractiveHeuristic humanInput = new InteractiveHeuristic();
        TheBookHeuristic bookHeuristic = new TheBookHeuristic();
        AggressiveHeuristic aggroHeuristic = new AggressiveHeuristic();
        NeverBustHeuristic neverBustHeuristic = new NeverBustHeuristic();
        bj.addPlayer("The Book", bookHeuristic);
        //bj.addPlayer("Human player", humanInput);
        bj.addPlayer("Aggressive player", aggroHeuristic);
        bj.addPlayer("Safe player", neverBustHeuristic);
        for (int i = 1; i <= numGames; i++) {
            System.out.println("New round! This is round #" + i);
            bj.nextMatch();
            bj.dealAll();
            bj.playPlayers();
            bj.playDealer();
            System.out.println(bj);
            bj.getWinners().forEach(winner -> System.out.println(winner.getName() + " won!"));
        }
        System.out.println("All rounds completed! Win tallies for all players:");
        bj.getPlayers().forEach(player -> System.out.println(player.getName() + " wins: " + player.getNumWins()));
    }
}
