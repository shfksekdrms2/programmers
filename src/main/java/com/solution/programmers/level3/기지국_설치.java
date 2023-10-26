package com.solution.programmers.level3;

public class 기지국_설치 {

    public static void main(String[] args) {
//        int n = 1;
//        int[] stations = new int[]{4, 11};
//        int w = 1;

        int n = 16;
        int[] stations = new int[]{9, 11};
        int w = 2;

        int solutions = solution(n, stations, w);
        System.out.println(solutions);
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int pivot = 1;
        int wide = 2 * w + 1;
        for (int i = 0; i < stations.length; i++) {
            int position = stations[i];
            int leftEnd = position - w;
            int leftStart = leftEnd - pivot;
            if (leftStart > 0) {
                answer = answer + (int) ((double) leftStart / wide);
                if ((double) leftStart % wide != 0) {
                    answer++;
                }
            }

            pivot = position + w + 1;

            // 마지막 이면 뒤에도 채울수 있도록 한다.
            if (i == stations.length - 1) {
                int rightStart = position + w;
                if (rightStart < n) {
                    int count = n - rightStart;
                    answer = answer + (int) ((double) count / wide);
                    if ((double) count % wide != 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
