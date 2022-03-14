package com.solution.programmers.level1;

public class Example2 {

    public static void main(String arge[]) {
        solution("AB", 1);
    }

    public static String solution(String s, int n) {

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            System.out.println((int) c);

            int valueOf = c;
            int value = valueOf + n;
            if (valueOf >= 65 && valueOf <= 90) {
                // 대문자
                int data = (value / 90) * 64 + value % 90;
                result += String.valueOf((char) data);
            } else if (valueOf >= 97 && valueOf <= 122) {
                // 소문자
                int data = (value / 122) * 96 + value % 122;
                result += String.valueOf((char) data);
            } else {
                // 공백
                result += String.valueOf(c);
            }

        }
        System.out.println(result);


        return null;
    }
}
