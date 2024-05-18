package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_2559_누적합_슬라이딩윈도우 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int num = 0;
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num += Integer.parseInt(st.nextToken());
            a[i] = num;
        }

        int max = a[k - 1];
        for (int i = k; i < n; i++) {
            max = Math.max(max, a[i] - a[i - k]);
        }
        System.out.println(max);
    }
}
