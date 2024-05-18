package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class A_2141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];
        long[] s = new long[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]); // 정렬
        // 누적합
        s[0] = a[0][1];
        for (int i = 1; i < n; i++) {
            s[i] += s[i - 1] + a[i][1];
        }

        int start = 0;
        int end = n - 1;
        long res = Long.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (s[mid] >= s[n - 1] - s[mid]) {
                end = mid - 1;
                res = Math.min(res, a[mid][0]);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(res);

        /*List<int[][]> list = new ArrayList<>();
        long sum = 0; // 전체 인원
        int res = 0;
        // x위치 a명 거주
        // 각 사람들까지 거리 합이 최소되는 곳에 우체국 세움
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] a = new int[1][2];
            a[0][0] = Integer.parseInt(st.nextToken());
            a[0][1] = Integer.parseInt(st.nextToken());
            list.add(a);
            sum += a[0][1];
        }

        list.sort((o1, o2) -> o1[0][0] - o2[0][0]);

        // 인원명 오름차순으로 정렬
        long std = (sum + 1) / 2; // 기준 왜 이렇게 해줌????
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += list.get(i)[0][1]; // 인원수
            if (sum >= std) { // std이상일 때
                res = list.get(i)[0][0];
                break;
            }
        }
        System.out.println(res);*/
    }
}
