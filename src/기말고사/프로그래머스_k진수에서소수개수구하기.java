package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 프로그래머스_k진수에서소수개수구하기 {

    static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int res = 0;

        String[] s = Integer.toString(n, k).split("0");

        for (String x : s) {
            if (x.isBlank() || x.isEmpty()) continue;
            else if (isPrime(Long.parseLong(x))) res++;
        }

        System.out.println(res);
    }
}
