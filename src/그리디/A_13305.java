package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] len = new long[n - 1];
        long[] oil = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        long cost = len[0] * oil[0];
        long minCost = oil[0];
        for (int i = 1; i < n - 1; i++) {
            if (oil[i] < minCost) {
                minCost = oil[i];
            }
            cost += minCost * len[i];
        }
        System.out.println(cost);
    }
}
