package org.example.dayTwo;

import java.util.List;

public class PartOne {

    public int getNumberOfSafeReports(List<String> reports)
    {
        int safeReports = 0;

        for (String report : reports) {
            String[] parts = report.split(" ");
            int[] numbers = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            boolean isAscending = numbers[0] < numbers[1];

            for (int i = 0; i < numbers.length - 1; i++) {
                if (isAscending) {
                    if (numbers[i + 1] - numbers[i] < 1 || numbers[i + 1] - numbers[i] > 3) {
                        break;
                    }
                } else {
                    if (numbers[i] - numbers[i + 1] < 1 || numbers[i] - numbers[i + 1] > 3) {
                        break;
                    }
                }

                if (i == numbers.length - 2) {
                    safeReports++;
                }
            }
        }

        return safeReports;
    }
}
