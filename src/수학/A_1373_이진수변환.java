package 수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제설명 : 2진수를 8진수로 변환하여 출력한다.
 * 핵심개념 : 진수변환법
 */

public class A_1373_이진수변환 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();

        // 세자리씩 끊어서 변환하므로 문자열의 1/3 길이만큼 임의 배열을 선언한다.
        int[] arr = new int[input.length / 3 + 1];
        int idx = 0; // 2의 승수
        int cur = 0; // 임의 배열에 기록할 인덱스
        int res = 0; // 임의 배열에 기록할 변환된 값

        // 문자열 맨 오른쪽부터 한 자리씩 끊어서 읽는다.
        for (int i = input.length - 1; i >= 0; i--) {

            // 1일 경우 2의 승수를 계산해서 res에 더해줌
            res += input[i] == '1' ? Math.pow(2, idx % 3) : 0;
            idx++; // 승수+1

            // 세자리씩 끊어서 봤으면 (idx % 3 == 0)이므로 8진수로 변환한다.
            if (idx % 3 == 0 || i == 0) { // i == 0은 맨 나중에 세자리씩 나누어지지 않을 수 있으므로
                arr[cur++] = res; // 8진수 변환값을 기록하고, 인덱스 cur+1
                res = 0; // 다음 턴을 위해 res 초기화
            }
        }

        // 위의 for문이 종료되면 최종 기록된 인덱스 + 1(cur+1)이 되어있으므로
        // cur - 1부터 거꾸로 출력한다.
        for (int i = cur - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());
    }
}
