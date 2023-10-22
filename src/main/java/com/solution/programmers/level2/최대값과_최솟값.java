package com.solution.programmers.level2;

import java.util.Arrays;

public class 최대값과_최솟값 {

    public static void main(String args[]) {
        String s = "1 2 3 4";
        String solution = solution(s);
        System.out.println(solution);
    }

    public static String solution(String s) {
        int max = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .max()
                .orElseThrow();

        int min = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .min()
                .orElseThrow();


        return min + " " +  max;
    }
}
