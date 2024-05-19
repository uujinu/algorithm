package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 프로그래머스_신규아이디추천 {

    static boolean check(char c) {
        return c == '-' || c == '_' || c == '.' || c >= 'a' && c <= 'z' || c >= '1' && c <= '9';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 3자~ 15자
        // 알파벳 소문자, 숫자, -, _, . 문자만 사용 가능
        // .는 처음 끝에 올 수 없고 연속으로 사용 불가
        String s = br.readLine();

        s = s.toLowerCase();
        char[] c = s.toCharArray();
        for (char x : c) {
            if (check(x)) sb.append(x);
        }

        // 점 제거
        s = sb.toString().replace("..", ".");
        while (s.contains("..")) {
            s = s.replace("..", ".");
        }

        sb = new StringBuilder(s); // 처음 마지막 제거
        while(sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0) {
            sb.append('a');
        }

        if (sb.length() >= 16) {
            s = sb.substring(0, 15);
            sb = new StringBuilder(s);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        if (sb.length() <= 2) {
            if (sb.length() == 0) sb.append('a');
            char t = sb.charAt(sb.length() - 1);
            while (sb.length() <= 2) {
                sb.append(t);
            }
        }



        /*s = s.toLowerCase();

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') { // 대문자인경우  65를 97로 바꿈
                c[i] += 32;
            }

            if (check(c[i])) { // 일단 여기서 넘어가야됨
                if (c[i] == '.') { // 점 두개 연속인지 확인
                    if (sb.length() >= 1 && sb.charAt(sb.length() - 1) != '.') {
                        sb.append(c[i]);
                    }
                } else sb.append(c[i]);
            }
            System.out.println(sb.toString());
        }

        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') { // 끝에 점 아닐때까지 제거
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0) { // 빈문자열일 경우
            sb.append('a');
        }

        if (sb.length() >= 16) {
            s = sb.substring(0, 15);
            sb = new StringBuilder(s);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') { // 끝에 점 아닐때까지 제거
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        if (sb.length() <= 2) {
            if (sb.length() == 0) sb.append('a');
            char t = sb.charAt(sb.length() - 1);
            while (sb.length() <= 2) {
                sb.append(t);
            }
        }*/
        System.out.println(sb.toString());
    }
}
