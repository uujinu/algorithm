package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_1758 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tip = new int[n];
        for (int i = 0; i < n; i++) {
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip);

        // 돈 - (받은 등수 - 1)
        long a = 0;
        for (int i = n - 1; i >= 0; i--) { // n-1이 1등
            long t = tip[i] - n + i + 1;
            a += t > 0 ? t : 0;
        }
        System.out.println(a);
    }
}
