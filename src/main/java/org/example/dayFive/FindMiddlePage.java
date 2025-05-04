package org.example.dayFive;

import java.util.*;

public class FindMiddlePage {

    public int find(List<List<Integer>> listToOrder, String [] pagesNumbers) {

        List<List<Integer>> validPageList = new ArrayList<>();
        for (List<Integer> list : listToOrder) {
            if (isPageOrderValid(pagesNumbers, list)) {
                validPageList.add(list);
                System.out.println("Valid Pages list: " + list);
            }
        }

        int middleCount = 0;
        for (List <Integer> orderedList : validPageList) {
            int middle = orderedList.size() / 2;
            middleCount += orderedList.get(middle);
        }

        return middleCount;
    }

    public boolean isPageOrderValid(String [] precedenceRules, List<Integer> pages) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean isValid = true;

        for(String rule : precedenceRules) {
            String[] split = rule.split("\\|");
            int before = Integer.parseInt(split[0]);
            int after = Integer.parseInt(split[1]);

            graph.computeIfAbsent(before, k -> new ArrayList<>()).add(after);
        }

        for (int i = 1; i < pages.size(); i++) {
            if (!isValid) {
                break;
            }

            int currentPage = pages.get(i);
            List<Integer> pageRules = graph.get(currentPage);

            if (pageRules != null) {
                for (int j = i - 1; j >= 0; j--) {
                    if (pageRules.contains(pages.get(j))) {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        return isValid;
    }
}
