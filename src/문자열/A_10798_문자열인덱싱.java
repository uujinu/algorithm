package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제설명 : 주어진 5줄의 문자열을 세로로 읽은 순서대로 출력하라.
 * 핵심개념 : 문자열에서 특정 문자 인덱스 찾기
 *
 * 예시) 세로로 읽은 경우 Aa0aPAf985Bz1EhCz2W3D1gkD6x
 * A A B C D D
 * a f z z
 * 0 9 1 2 1
 * a 8 E W g 6
 * P 5 h 3 k x
 */

public class A_10798_문자열인덱싱 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        int maxIndex = -1;
        for (int i = 0; i < 5; i++) {
            list.add(br.readLine()); // 리스트에 문자열 입력을 담음
            maxIndex = Math.max(maxIndex, list.get(i).length()); // 문자열 최대 길이까지 순회
        }

        for (int i = 0; i < maxIndex; i++) {
            for (String str : list) { // 매 인덱스마다 문자열을 순회하여 문자를 읽어들임
                if (str.length() > i) {
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb.toString());
    }
}