package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TournamentWinner {

    // https://www.algoexpert.io/questions/tournament-winner
    //
    // NOTES:
    // Use a Map to record the scores of every team. And then find the team with the max score.

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions,
                                   ArrayList<Integer> results) {
        Map<String, Integer> scoreCard = new HashMap<>();

        int maxScore = Integer.MIN_VALUE;
        String tournamentWinner = "";

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            int index = results.get(i) ^ 1;
            String matchWinner = competition.get(index);
            int score = scoreCard.compute(matchWinner, (_, v) -> v == null ? 1 : v + 1);
            if (score > maxScore) {
                maxScore = score;
                tournamentWinner = matchWinner;
            }
        }

        return tournamentWinner;
    }

}
