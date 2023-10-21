package com.solution.programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 이중_우선순위_큐 {

    public static void main(String args[]) {
        String[] operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] solution = solution(operations);
        System.out.println(solution[0] + " " + solution[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            String[] s = operation.split(" ");
            String inputOperation = s[0];
            String inputValue = s[1];

            if (inputOperation.equals("I")) {
                // input
                list.add(Integer.valueOf(inputValue));
            } else {
                if (list.isEmpty()) {
                    continue;
                }
                //  if (inputOperation.equals("D"))
                // remove
                if (inputValue.equals("1")) {
                    // 최대값 삭제
                    list.sort((o1, o2) -> o2 - o1);
                    list.remove(0);
                } else {
                    // inputValue.equals("-1")
                    // 최소값 삭제
                    list.sort(Comparator.comparingInt(o -> o));
                    list.remove(0);
                }
            }
        }

        if (list.isEmpty()) {
            return answer;
        }

        list.sort((o1, o2) -> o2 - o1);
        answer[0] = list.get(0);

        list.sort(Comparator.comparingInt(o -> o));
        answer[1] = list.get(0);

        return answer;
    }
}
