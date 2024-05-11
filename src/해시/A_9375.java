package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            int res = 1;
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String c = st.nextToken();
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                res *= e.getValue() + 1;
            }
            sb.append(res - 1).append('\n');
        }
        System.out.println(sb.toString());
    }
}
