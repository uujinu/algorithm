package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_9655 {

    /**
     * 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가지는 사람이 이김
     * 상근이가 먼저 시작
     *
     * 1개: 1 (상근 승)
     * 2개: 1 1 (창영 승)
     * 3개: 1 1 1 (상근 승)
     *      3 (상근 승)
     * 4개: 1 1 1 1 (창영 승)
     *      1 3 (창영 승)
     *      3 1 (창영 승)
     * 5개: 1 나머지4개 (상근 승)
     *      3 나머지2개 (상근 승)
     *
     * - 홀수의 경우
     *   n-1 또는 n-3을 하면 무조건 짝수가 된다. 짝수에서는 항상 창영이 승리이므로,
     *   1이나 3을 빼는 하나의 턴을 더하면 마지막은 항상 상근이가 승리하게 된다.
     * - 짝수의 경우
     *   n-1 또는 n-3을 하면 무조건 홀수가 된다. 홀수에서는 항상 상근이 승리이므로
     *   한 턴을 더하면 마지막은 항상 창영이 승리
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}
