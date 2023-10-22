package com.solution.programmers.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 최솟값_만들기 {


    public static void main(String args[]) {
        int[] a = new int[]{1, 4, 2};
        int[] b = new int[]{4, 5, 4};
        int solution = solution(a, b);
        System.out.println(solution);
    }

    public static int solution(int[] A, int[] B) {
        PriorityQueue<Integer> minA = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int a : A) {
            minA.add(a);
        }

        PriorityQueue<Integer> maxB = new PriorityQueue<>(Comparator.reverseOrder());
        for (int b : B) {
            maxB.add(b);
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int poll = minA.poll();
            int poll1 = maxB.poll();
            sum = sum + (poll * poll1);
        }

        return sum;
    }
}
