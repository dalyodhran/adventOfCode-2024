package org.example.dayOne;

import java.util.List;

public class PartOne {
    public int calculateLocation(List<Integer> leftLocationId, List<Integer> rightLocationId) {
        leftLocationId.sort(Integer::compareTo);
        rightLocationId.sort(Integer::compareTo);
        int distance = 0;

        for (int i = 0; i < leftLocationId.size(); i++) {
            if (leftLocationId.get(i) >= rightLocationId.get(i)) {
                distance += leftLocationId.get(i) - rightLocationId.get(i);
            } else {
                distance += rightLocationId.get(i) - leftLocationId.get(i);
            }
        }

        return distance;
    }
}
