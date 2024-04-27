package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제설명 : 문자열이 패턴과 일치하는지 여부 판단
 * 핵심개념 : 문자열에서 특정 문자 인덱스 찾기, 구분자로 슬라이싱
 */

public class A_9996_문자열패턴_슬라이싱 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        // *표 기준으로 문자열을 구분한다.
        int asteriskIdx = pattern.indexOf('*');
        String start = pattern.substring(0, asteriskIdx); // *표 앞부분
        String end = pattern.substring(asteriskIdx + 1); // *표 뒷부분

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            // 문자열과 패턴을 비교한다.
            if (str.startsWith(start) && str.endsWith(end) && str.length() >= start.length() + end.length())
                System.out.println("DA");
            else System.out.println("NE");
        }
    }
}