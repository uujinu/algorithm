package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A_10816 {

    /**
     * 각 카드에는 정수가 적혀있다.
     * 문제로 M개의 숫자가 주어졌을 때 숫자가 적힌 카드가 몇 개인지 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 카드 번호, 가지고 있는 카드 개수 저장할 map
        HashMap<Integer, Integer> map = new HashMap<>();

        // 카드에 적혀있는 정수 입력
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());

            // map에 카드 숫자와 가지고 있는 개수 저장
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        // 카드 번호를 입력받음
        br.readLine();
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) { // 숫자가 적힌 카드를 몇 개 가지고 있는지 map에서 조회한다.
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
