package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제설명 : 주어진 문자열에서 확장자를 추출하고, 확장자의 이름과 개수를 사전순으로 출력하라.
 * 핵심개념 : 문자열에서 특정 문자 인덱스 찾기, 구분자로 슬라이싱
 */

public class A_20291_문자열슬라이싱 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String str = br.readLine(); // 문자열은 소문자와 점으로만 구성. 점은 한번만 등장, 처음 및 마지막 글자로 오지 않는다.
            StringTokenizer st = new StringTokenizer(str, "."); // .으로 문자열을 구분한다.
            st.nextToken(); // 파일명
            String ext = st.nextToken(); // 확장자
            if (map.containsKey(ext)) {
                map.put(ext, map.get(ext) + 1);
            } else map.put(ext, 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list); // 사전순 정렬
        for (String s : list) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
