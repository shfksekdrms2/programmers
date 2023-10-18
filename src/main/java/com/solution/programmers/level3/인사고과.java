package com.solution.programmers.level3;

import java.util.Arrays;

public class 인사고과 {

    public static void main(String args[]) {
        int[][] scores = new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
        int solution = solution(scores);
        System.out.println(solution);
    }

    public static int solution(int[][] scores) {
        if (scores.length == 1) {
            return 1;
        }

        int a1 = scores[0][0];
        int a2 = scores[0][1];

        Arrays.sort(scores,
                (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                });

        int rank = 1;
        int maxValue = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] >= maxValue) {
                maxValue = scores[i][1];
                if (scores[i][0] + scores[i][1] > a1 + a2) {
                    rank++;
                }
            } else {
                if (scores[i][0] == a1 && scores[i][1] == a2) {
                    return -1;
                }
            }
        }

        return rank;
    }
}
