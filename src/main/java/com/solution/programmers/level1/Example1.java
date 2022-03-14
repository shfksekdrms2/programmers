package com.solution.programmers.level1;

/**
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * @Author: jsj0828
 **/
public class Example1 {

    public static void main(String args[]) {
        solution(3, 12);
    }

    public static int[] solution(int n, int m) {

        int gcd = gcd(n, m);
        int lcm = (n * m) / gcd(n, m);

        return new int[]{gcd, lcm};
    }

    private static int gcd(int n, int m) {
        int r;
        while (m != 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}
