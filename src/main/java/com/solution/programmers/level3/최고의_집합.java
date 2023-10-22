package com.solution.programmers.level3;

import java.util.Arrays;

public class 최고의_집합 {

    public static void main(String args[]) {
        int n = 2;
        int s = 9;
        int[] solution = solution(2, 9);
        for (int so : solution) {
            System.out.println(so);
        }
    }

    public static int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        Arrays.fill(answer, s / n);

        int remain = s % n;
        for (int i = n - 1; remain != 0; i--) {
            answer[i] += 1;
            remain--;
        }

        return answer;
    }

}
