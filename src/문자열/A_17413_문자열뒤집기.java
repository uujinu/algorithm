package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제설명 : 태그는 '<'와 '>' 사이에 있는 길이 3이상의 문자열, 단어는 소문자와 숫자로만 이루어진 부분 문자열이다.
 *          문자열 규칙이 다음과 같을 때, 태그를 제외한 단어만 뒤집어 출력하라.
 *   - 문자열 규칙
 *   1. 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
 *   2. 문자열의 시작과 끝은 공백이 아니다.
 *   3.'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
 * 핵심개념 : 문자열 다루기
 */

public class A_17413_문자열뒤집기 {

    private static void addReverseString(StringBuilder sb, char[] c) {
        for (int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int startIdx = str.indexOf('<'); // 문자열 내 태그 유무
        int endIdx = str.indexOf('>');

        while (idx < str.length()) {
            if (startIdx == -1) { // 문자열 내 태그가 존재하지 않는 경우
                StringTokenizer st = new StringTokenizer(str.substring(idx));
                while (st.hasMoreTokens()) {
                    addReverseString(sb, st.nextToken().toCharArray());
                    if (st.hasMoreTokens()) sb.append(" ");
                }
                break;
            } else if (startIdx == idx) { // 태그가 현재 인덱스 위치에서 시작하는 경우
                sb.append(str.substring(startIdx, endIdx + 1));
                if (endIdx + 1 < str.length()) {
                    int tmp = str.substring(endIdx + 1).indexOf('<'); // 그 다음 태그 유무
                    if (tmp == -1) {
                        startIdx = tmp;
                        idx = endIdx + 1;
                    } else {
                        startIdx = tmp + endIdx + 1;
                        idx = endIdx + 1;
                        endIdx = str.substring(endIdx + 1).indexOf('>') + endIdx + 1;
                    }
                }
                else break;
            } else { // 태그가 현재 위치보다 오른쪽에 있는 경우
                // 태그 이전까지 범위에 있는 단어를 reverse한다.
                StringTokenizer st = new StringTokenizer(str.substring(idx, startIdx));
                while (st.hasMoreTokens()) {
                    addReverseString(sb, st.nextToken().toCharArray());
                    if (st.hasMoreTokens()) sb.append(" ");
                }
                idx = startIdx;
            }
        }
        System.out.println(sb.toString());
    }
}