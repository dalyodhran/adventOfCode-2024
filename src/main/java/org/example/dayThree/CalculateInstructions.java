package org.example.dayThree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateInstructions {
    public long calculate(String instructions) {
         String regex = "mul\\(([0-9]\\d{0,100},[0-9]\\d{0,100})\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(instructions);
        long result = 0;

        while (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
            String digits = matcher.group().substring(4, matcher.group().length() - 1);
            String[] split = digits.split(",");
            long first = Long.parseLong(split[0]);
            long second = Long.parseLong(split[1]);
            result += first * second;
        }

        return result;
    }
}
