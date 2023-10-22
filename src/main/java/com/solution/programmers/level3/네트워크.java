package com.solution.programmers.level3;

import java.util.Arrays;

public class 네트워크 {

    public static void main(String args[]) {
        int n = 3;
//        int[][] computers = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int solution = solution(n, computers);
        System.out.println(solution);
    }

    public static int solution(int n, int[][] computers) {
        // 방문한 위치
        int[][] visit = new int[n][n];
        for (int[] ints : visit) {
            Arrays.fill(ints, 0);
        }
        int count = 0;
        for (int row = 0; row < computers.length; row++) {
            for (int col = 0; col < computers[row].length; col++) {
                if (visit[row][col] != 1 && computers[row][col] == 1) {
                    count++;
                    dfs(visit, computers, row, col);
                } else {
                    visit[row][col] = 1;
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] visit, int[][] computers, int row, int col) {
        if (visit[row][col] == 1) {
            return;
        }
        visit[row][col] = 1;
        for (int i = 0; i < computers[row].length; i++) {
            if (i == row) {
                visit[row][i] = 1;
                continue;
            }

            if (visit[row][i] != 1 && computers[row][i] == 1) {
                // 방문을 하지 않았다면
                visit[row][i] = 1;
                dfs(visit, computers, i, row);
            }
        }
    }
}
