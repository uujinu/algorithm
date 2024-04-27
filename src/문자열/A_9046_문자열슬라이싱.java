package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제설명 : 문자열에서 빈도수 높은 문자 출력
 * 핵심개념 :
 */

public class A_9046_문자열슬라이싱 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        while(n-- > 0) {
            char[] s = br.readLine().toCharArray();
            int max = 0;
            char c = '?';

            for (int i = 0; i < s.length; i++) {
                // 해당 문자가 소문자인지 판별
                if (s[i] >= 'a' && s[i] <= 'z') {
                    // map에 해당 문자와 빈도수를 저장
                    if (map.containsKey(s[i])) {
                        map.put(s[i], map.get(s[i]) + 1);
                    } else {
                        map.put(s[i], 1);
                    }
                    // max값과 비교하여 max값보다 더 클 경우 max값 및 최대 빈도 문자 갱신
                    if (map.get(s[i]) > max) {
                        max = map.get(s[i]);
                        c = s[i];
                    } else if (map.get(s[i]) == max) c = '?'; // max값이 같을 경우 문자 ?로 저장
                }
            }
            System.out.println(c);
            map.clear();
        }
    }
}
