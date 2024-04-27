package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제설명 : 문자열이 패턴과 일치하는지 여부 판단
 * 핵심개념 : 정규식 표현
 */

public class A_9342_정규식 {

    static boolean compareVal(int val) {
        if (val >= 'A' && val <= 'F') return true;
        else return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        /**
         * 문자열은 ABCDEF중 0개 또는 1개로 시작
         * 그 다음 A가 1개 이상
         * 그 다음 F가 1개 이상
         * 그 다음 C가 1개 이상
         * 그 다음 ABCDEF중 0개 또는 1개
         */

        while (n-- > 0) {
            String s = br.readLine();
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            int aIdx = s.indexOf('A');
            int fIdx = s.indexOf('F');
            int cIdx = s.indexOf('C');
            int len = s.length();
            char[] c = {'A', 'F', 'C'};

            if (s.length() < 3 || !compareVal(start) || !compareVal(end)
                    || aIdx == -1 || fIdx == -1 || cIdx == -1)
                sb.append("Good\n");
            else {
                boolean flag = true;
                char subStart = s.charAt(1); // 인덱스 1번 글자는 A or F
                if (subStart == 'A' || subStart == 'F') {
                    int tmp = subStart == 'A' ? 0 : 1;
                    for (int i = 1; i < s.length() - 1; i++) {
                        if (s.charAt(i) != subStart) { // 연속하지 않은 문자열
                            if (tmp < 2 && s.charAt(i) == c[tmp + 1]) {
                                subStart = c[++tmp];
                            } else { // 조건 불일치
                                flag = false;
                                break;
                            }
                        }
                    }

                    if (flag) {
                        if (start != 'A') {  // 첫글자가 A가 아니라면 끝글자만 조사
                            if (end == 'C') { // 끝글자가 C인 경우 앞글자가 C or F여야 한다.
                                if (s.charAt(len - 2) == 'C' || s.charAt(len - 2) == 'F') {
                                    sb.append("Infected!\n");
                                } else sb.append("Good\n");
                            } else { // 끝글자가 C가 아닌 경우 그 앞글자는 무조건 C여야 한다.
                                if (s.charAt(len - 2) == 'C') sb.append("Infected!\n");
                                else sb.append("Good\n");
                            }
                        } else sb.append("Infected!\n");
                    } else sb.append("Good\n");
                } else sb.append("Good\n");
            }
            /**
             * 정규식 표현으로 풀면
             * String s = br.readLine();
             * String pattern = "^[A-F]?A+F+C+[A-F]?$";
             * boolean val = s.matches(pattern);
             * ....
             */
        }

        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
