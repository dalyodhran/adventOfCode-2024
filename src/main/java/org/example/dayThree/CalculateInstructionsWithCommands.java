package org.example.dayThree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateInstructionsWithCommands {
    public long calculate(String instructions) {
        String regex = "mul\\(([0-9]\\d{0,100},[0-9]\\d{0,100})\\)|don't\\(\\)|do\\(\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(instructions);
        long result = 0;
        boolean shouldCalculate = true;

        while (matcher.find()) {
            if (matcher.group().equals("do()")) {
                shouldCalculate = true;
                System.out.println("do()");
                matcher.find();
            } else if (matcher.group().equals("don't()")) {
                shouldCalculate = false;
                System.out.println("don't()");
                matcher.find();
            }

            if (shouldCalculate) {
                System.out.println(matcher.group());
                String digits = matcher.group().substring(4, matcher.group().length() - 1);
                String[] split = digits.split(",");
                long first = Long.parseLong(split[0]);
                long second = Long.parseLong(split[1]);
                result += first * second;
            } else {
                System.out.println(matcher.group());
            }
        }

        return result;
    }
}
