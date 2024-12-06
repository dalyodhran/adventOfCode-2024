package org.example.dayTwo;

import java.util.List;

public class PartTwo {
    public int getNumberOfSafeReports(List<String> reports) {
        int safeReports = 0;

        for (String report : reports) {
            String[] parts = report.split(" ");
            int[] numbers = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }


            int chance = 0;
            int pointer = 0;
            boolean shouldCount = true;
            boolean isAscending = numbers[0] < numbers[1];

            while (chance <= 1 && pointer < numbers.length - 1) {
                if (isAscending) {
                    if (numbers[pointer + 1] - numbers[pointer] < 1 || numbers[pointer + 1] - numbers[pointer] > 3) {
                        if (pointer + 1 == numbers.length - 1) {
                            numbers = removeNumber(numbers, pointer + 1);
                        } else if (numbers[pointer + 2] - numbers[pointer] >= 1 && numbers[pointer + 2] - numbers[pointer] <= 3) {
                            numbers = removeNumber(numbers, pointer + 1);
                        } else {
                            numbers = removeNumber(numbers, pointer);
                        }
                        chance++;
                        shouldCount = false;
                    }
                } else {
                    if (numbers[pointer] - numbers[pointer + 1] < 1 || numbers[pointer] - numbers[pointer + 1] > 3) {
                        if (pointer + 1 == numbers.length - 1) {
                            numbers = removeNumber(numbers, pointer + 1);
                        }else if (numbers[pointer] - numbers[pointer + 2] >= 1 && numbers[pointer] - numbers[pointer + 1] <= 3) {
                            numbers = removeNumber(numbers, pointer + 1);
                        } else {
                            numbers = removeNumber(numbers, pointer);
                        }
                        chance++;
                        shouldCount = false;
                    }
                }

                if (shouldCount) {
                    pointer++;
                } else {
                    if (pointer == 0) {
                        isAscending = numbers[0] < numbers[1];
                    }
                    shouldCount = true;
                }
            }

            if (pointer == numbers.length - 1 && chance <= 1) {
                safeReports++;
            } else {
                System.out.println("Unsafe report: ");
                System.out.println(report);
                for (int number : numbers) {
                    System.out.print(number + " ");
                }
                System.out.println();
            }
        }

        return safeReports;
    }

    private int[] removeNumber(int[] numbers, int index) {
        int[] newNumbers = new int[numbers.length - 1];
        int pointer = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (i != index) {
                newNumbers[pointer] = numbers[i];
                pointer++;
            }
        }

        return newNumbers;
    }
}
