package org.example.dayFive;

import java.util.*;

public class CorrectBrokenPages {

    public int find(List<List<Integer>> listToOrder, String [] pagesNumbers) {
        List<List<Integer>> validPageList = new ArrayList<>();
        FindMiddlePage findMiddlePage = new FindMiddlePage();

        for (List<Integer> list : listToOrder) {
            if (!findMiddlePage.isPageOrderValid(pagesNumbers, list)) {
                System.out.println("InValid Pages list: " + list);
                List<Integer> validOrderedPages = orderPages(pagesNumbers, list);
                validPageList.add(validOrderedPages);
                System.out.println("  Valid Pages list: " + list);
                System.out.println();
            }
        }

        int middleCount = 0;
        for (List <Integer> orderedList : validPageList) {
            int middle = orderedList.size() / 2;
            middleCount += orderedList.get(middle);
        }

        return middleCount;
    }

    public List<Integer> orderPages(String [] precedenceRules, List<Integer> pages) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (String rule : precedenceRules) {
            String[] split = rule.split("\\|");
            int before = Integer.parseInt(split[0]);
            int after = Integer.parseInt(split[1]);

            graph.computeIfAbsent(before, k -> new ArrayList<>()).add(after);
        }


        for (int i = 1; i < pages.size(); i++) {
            int currentPage = pages.get(i);
            List<Integer> pageRules = graph.get(currentPage);

            if (pageRules != null) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                pages = reorder(graph, pages, stack);
            }
        }

        return pages;
    }

    public List<Integer> reorder(Map<Integer, List<Integer>> graph, List<Integer> pages, Stack<Integer> valuesToValidate) {
        if (valuesToValidate.isEmpty()) {
            return pages;
        }

        int currentPageIndex = valuesToValidate.pop();
        int currentPage = pages.get(currentPageIndex);
        List<Integer> pageRules = graph.get(currentPage);

        for (int j = currentPageIndex - 1; j >= 0; j--) {
            var page = pages.get(j);
            if (pageRules.contains(page)) {
                int temp = pages.remove(currentPageIndex);
                pages.add(j, temp);
                valuesToValidate.push(j);
                pages = reorder(graph, pages, valuesToValidate);
                break;
            }
        }

        return pages;
    }
}
