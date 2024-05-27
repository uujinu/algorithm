package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_10870_피보나치수열 {

    static int fibonacci(int val) {
        if (val <= 1) return val;
        return fibonacci(val - 1) + fibonacci(val - 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fibonacci(Integer.parseInt(br.readLine())));
    }
}
