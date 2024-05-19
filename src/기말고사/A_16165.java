package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class A_16165 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); // 입력받을 걸그룹 수
        int m = Integer.parseInt(st.nextToken()); // 맞힐 문제
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, String> t = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // 팀이름
            String team = br.readLine();
            List<String> list = new ArrayList<>();
            // 인원수
            int num = Integer.parseInt(br.readLine());
            // 멤버 이름
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                list.add(name);
                t.put(name, team);
            }
            list.sort((o1, o2) -> o1.compareTo(o2));
            map.put(team, list);
        }

        for (int z = 0; z < m; z++) {
            // 퀴즈 2줄
            String x = br.readLine();
            if (Integer.parseInt(br.readLine()) == 0) { // 팀이름이 주어짐
                List<String> ll = map.get(x);
                for (String l : ll) {
                    sb.append(l).append('\n');
                }
            } else { // 멤버이름
                sb.append(t.get(x)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
