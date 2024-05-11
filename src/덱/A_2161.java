package 덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class A_2161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            d.offer(i);
        }
        while (d.size() > 1) {
            sb.append(d.poll()).append(" ");
            d.offer(d.poll());
        }
        sb.append(d.poll());
        System.out.println(sb);
    }
}
