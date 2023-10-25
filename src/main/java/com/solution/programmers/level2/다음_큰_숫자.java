package com.solution.programmers.level2;

public class 다음_큰_숫자 {

    public static void main(String args[]) {
        int n = 15;
        int solutions = solution(n);
        System.out.println(solutions);
    }

    public static int solution(int n) {
        int answer = 0;

        // n 의 1의 자리 갯수 구하기
        int count = getCount(n);

        for (int i = n + 1; i < 1000000; i++) {
            int count1 = getCount(i);
            if (count == count1) {
                return i;
            }
        }

        return answer;
    }

    private static int getCount(int n) {
        int count = 0;
        int a = n;
        while (a > 1) {
            int remain = a % 2;
            a = a / 2;
            if (remain == 1) {
                count++;
            }
        }

        if (a == 1) {
            count++;
        }

        return count;
    }
}
