package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) { // 재료들의 고유 번호를 입력받는다.
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int s = 0, e = n - 1;
        int res = 0;
        while (s < e) {
            int sum = a[s] + a[e];
            if (sum == m) {
                res++;
                s++;
                e--;
            } else if (sum > m) {
                e--;
            } else {
                s++;
            }
        }
        System.out.println(res);
    }
}
