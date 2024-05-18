package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // k개 로프 사용 w물체 들어올리면 각 로프에 w/k 중량 걸림
        // 로프 조합을 이용해서 들어올릴 수 있는 최대 중량 구하기
        int[] a = new int[n];
        int w = 0;
        for (int i = 0; i < n; i++) { // 각 로프가 버틸 수 있는 최대 중량
            a[i] = Integer.parseInt(br.readLine());
            // w / k가 각 로프의 최대중량 이하여야 한다.
            // 먼저 싹 중량 더하고, 최대중량이 작은 것부터 빼본다.
        }
        Arrays.sort(a); // 최대중량 기준 오름차순 정렬

        int num = n;
        for (int i = 0; i < n; i++) {
            w = Math.max(a[i] * num, w);
            num --;
        }
        System.out.println(w);
    }
}
