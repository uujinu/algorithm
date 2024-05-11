package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A_1620 {

    /**
     * 1번~N번까지의 포켓몬 이름이 입력된다.
     * 문제가 알파벳으로 들어오면 번호를, 숫자로 들어오면 이름을 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> map = new HashMap<>(); // 포켓몬 번호, 포켓몬 이름 저장
        HashMap<String, Integer> map2 = new HashMap<>(); // 포켓몬 이름, 포켓몬 번호 저장

        // map을 2개 사용한다.
        int n = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int m = Integer.parseInt(st.nextToken()); // 문제 개수

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(i, name); // key: 번호, value: 이름 저장
            map2.put(name, i); // key: 이름, value: 번호 저장
        }

        while (m-- > 0) {
            String s = br.readLine();
            if (s.charAt(0) >= '1' && s.charAt(0) <= '9') { // 숫자인 경우 이름 get
                sb.append(map.get(Integer.parseInt(s))).append('\n');
            } else { // 문자인 경우 번호 get
                sb.append(map2.get(s)).append('\n');
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
