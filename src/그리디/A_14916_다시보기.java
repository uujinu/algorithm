package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_14916_다시보기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int LNF = Integer.MAX_VALUE;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1]; // 만약 거슬러줄수 없으면 -1

        // 초기화
        arr[0] = LNF;
        arr[1] = LNF;
        arr[2] = 1;
        arr[3] = LNF;
        arr[4] = 2;
        arr[5] = 1;

        // 2랑 5의 조합 중 최소합을 구해야 하므로, n보다 2작은 곳, n보다 5작은 곳의 조합 숫자를 보고 그 중 작은 걸 선택한다.
        // 거슬러줄 수 없으면 -1을 출력해야 하는데, 배열에 -1을 써주면 최소 비교를 할 수 없으므로 LNF를 써준다.
        // arr[6] = 3 => Math.min(arr[6 - 2], arr[6 - 5]) + 1 // 1을 더해주는 건 2 or 5를 더해주는 것

        for (int i = 6; i <= n; i++) {
            arr[i] = Math.min(arr[i - 2], arr[i - 5]) + 1;
        }
        System.out.println(arr[n] == LNF ? -1 : arr[n]);
    }
}
