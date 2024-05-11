package 덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        sb.append('<');
        while (!q.isEmpty()) {
            int s = k - 1;
            while (s != 0) {
                s--;
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 2).toString().trim() + '>');
    }
}
