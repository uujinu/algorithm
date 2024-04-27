package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제설명 : 주어진 변수명이 Java 형식일 경우 C++로, C++ 형식일 경우 Java 형식으로 바꿔서 출력하라.
 * 핵심개념 : 문자열 구분자로 슬라이싱, 아스키코드 개념
 */

public class A_3613_문자열슬라이싱_아스키코드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        byte[] bytes = str.getBytes();
        boolean flag = true;
        boolean cplusplus = false;

        if (bytes[0] >= 65 && bytes[0] <= 90 || bytes[0] == 95 || bytes[bytes.length - 1] == 95 || str.contains("__")) {
            flag = false;
        } else {
            int underIdx = str.indexOf('_');
            if (underIdx != -1) {
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] >= 65 && bytes[i] <= 90) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cplusplus = true;
            }
        }

        if (!flag) {
            System.out.println("Error!");
        } else {
            if (cplusplus) {
                StringTokenizer st = new StringTokenizer(str, "_");
                sb.append(st.nextToken());
                while (st.hasMoreTokens()) {
                    String s = st.nextToken();
                    char first = s.charAt(0);
                    sb.append((char)(first - 32));
                    sb.append(s.substring(1));
                }
            } else {
                boolean upper = false;
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] >= 97) {
                        sb.append((char) bytes[i]);
                    } else {
                        sb.append("_");
                        sb.append((char) (bytes[i] + 32));
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
