package 수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제설명 : 두 수의 최대공약수와 최소공배수를 출력하라.
 * 핵심개념 : 최대공약수 및 최소공배수 구하는 알고리즘
 */

public class A_2609_최대공약수_최소공배수 {
    private static int gcd(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
}