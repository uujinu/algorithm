package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_2531 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[n]; // 1~d 초밥 종류 저장
        // 초밥 배열이 n이면 k개씩 묶으면 1 2 3 4 5 6 7 8 9 9개씩 다 봐야함
        int[] eat = new int[3001]; // 누적결과 담을 배열(종류 최대 3천개)
        eat[c] = 50000; // 쿠폰번호의 초밥은 무조건 하나 제공

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        /**
         * k접시 먹으면서 종류를 최대한 많이 먹으려면 한바퀴 돌면서 종류가 최대값이 되는 순간을 찾아야 한다.
         * - 조건
         * 대신 쿠폰 번호 종류의 초밥은 보너스로 하나 먹을 수 있다.
         * 그렇다면 한바퀴 돌면서 종류 체크하는 배열에 보너스 초밥을 기본 옵션으로 깔아둔다.
         * 이때, 테이블에 보너스 번호인 초밥이 더 있을 수 있으므로 보너스 초밥은 "최대값으로" 해놓는다.
         */

        // k개 만큼 먹었을 때의 경우를 배열에 담아 초기화한다.
        // 보너스 초밥은 무조건 먹으므로 결과값을 애초에 1로 시작한다.
        int res = 1;
        for (int i = 0; i < k; i++) { // 처음에 놓인 k개 먹기
            // 현재 먹을 초밥 종류 sushi[i]
            // 누적배열을 보면서 현재 초밥번호가 0이면 새로 먹는 것이므로 결과+1, 새로 먹는게 아니면 누적배열에만 +1
            // 만약 보너스초밥번호면 +1 소용없음 그냥 넘어감
            int now = sushi[i];
            if (eat[now] == 0) { // 처음 먹는다.
                res++; // 종류 추가
            }
            eat[now]++;
        }

        int max = res;
        for (int i = 1; i < n; i++) {
            // 이전에서 없어진 것, 더해진 것 비교
            // 이전 스시 sushi[i - 1]
            int prev = sushi[i - 1];
            // 새로 추가된 스시
            int nextIdx = i + k - 1 >= n ? i + k - 1 - n : i + k - 1;
            int next = sushi[nextIdx];

            if (--eat[prev] == 0) { // 종류 없어짐
                res--;
            }
            if (++eat[next] == 1) { // 새로운 종류 먹음
                res++;
            }

            max = Math.max(max, res);
        }
        System.out.println(max);

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 접시 수
        st.nextToken(); // d
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        int[] a = new int[n];
        int[] sushi = new int[3001];
        int count = 1; // 기본 무료 초밥
        for (int i = 0; i < n; i++) // 초밥 번호 입력
            a[i] = Integer.parseInt(br.readLine());
        sushi[c] = 5000;

        for (int i = 0; i < k; i++) { // k개까지 먹음
            if (sushi[a[i]] == 0) {
                count++;
            }
            sushi[a[i]]++;
        }

        int max = count;
        for (int i = 1; i < n; i++) { // n바퀴 돌면서 먹음
            // 이전 접시 지우기
            int prev = i == 0 ? n - 1 : i - 1;
            if (--sushi[a[prev]] == 0) { // 이전 스시 지움
                count--; // 종류 하나 제거
            }

            // 다음 스시 먹음
            int next = i + k - 1 >= n ? i + k - 1 - n : i + k - 1;
            if (++sushi[a[next]] == 1) {
                count++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);*/
    }
}
