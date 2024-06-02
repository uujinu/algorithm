package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_2231 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            int num = i;
            int sum = i;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
