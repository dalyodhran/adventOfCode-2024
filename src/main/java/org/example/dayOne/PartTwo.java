package org.example.dayOne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartTwo {
    public int scoreLocationId(List<Integer> leftLocationId, List<Integer> rightLocationId) {

        Map<Integer, Integer> numberScore = new HashMap<>();

        for (int score : rightLocationId) {
            if (numberScore.containsKey(score)) {
                numberScore.put(score, numberScore.get(score) + 1);
            } else {
                numberScore.put(score, 1);
            }
        }

        int distance = 0;

        for (int i = 0; i < leftLocationId.size(); i++) {
            distance += (leftLocationId.get(i) * numberScore.getOrDefault(leftLocationId.get(i), 0));
        }

        return distance;
    }
}
