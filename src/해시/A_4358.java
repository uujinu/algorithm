package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_4358 {

    /**
     * 나무 종이 전체 종에서 몇 %를 차지하는지 구한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 나무 종 이름, 입력된 횟수 저장할 map
        HashMap<String, Double> map = new HashMap<>();

        int i = 0; // 전체 입력된 개수
        String s;
        while ((s = br.readLine()).length() != 0) {
            map.put(s, map.getOrDefault(s, (double) 0) + 1);
            i++;
        }

        int finalI = i;

        // 종의 이름을 사전 순으로 정렬 후, 비율 계산하여 StringBuilder에 이름과 비율 append
        map.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByKey())
                .forEach(m -> sb.append(m.getKey() + " " +String.format("%.4f", m.getValue() / finalI * 100) + '\n'));

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
