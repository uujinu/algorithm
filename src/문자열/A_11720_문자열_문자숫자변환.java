package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제설명 : 문자열을 구성하는 모든 숫자를 더하여 출력하라.
 * 핵심개념 : 문자열 -> 문자 및 숫자 변환
 */

public class A_11720_문자열_문자숫자변환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        for (String a : br.readLine().split("")) {
            ans += Integer.parseInt(a);
        }

        System.out.println(ans);
    }
}