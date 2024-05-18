package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n]; // 동전 종류

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine()); // 오름차순으로 주어짐

        int res = 0;
        // 동전개수 최소값
        for (int i = n - 1; i >= 0; i--) {
            if (k >= a[i]) {
                res += k / a[i];
                k %= a[i];
            }
        }
        System.out.println(res);
    }
}
