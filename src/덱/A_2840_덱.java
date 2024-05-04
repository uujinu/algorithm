package 덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_2840_덱 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 바퀴 칸 수
        int k = Integer.parseInt(st.nextToken()); // 바퀴 돌리는 횟수

        char[] list = new char[n]; // 글자 표시 배열
        boolean[] visited = new boolean[n]; // 글자 표시 여부
        boolean[] dup = new boolean[26]; // 글자 중복 여부
        boolean flag = true;
        int idx = 0; // 시작 인덱스

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 글자 변경 횟수
            char c = st.nextToken().charAt(0); // 최종 글자

            // 회전 후 인덱스
            idx = (idx + s) % n;

            if (visited[idx] && list[idx] != c || dup[c - 65] && list[idx] != c) { // 중복이거나 이미 다른 글자가 적혀있음
                flag = false;
                break;
            } else { // 빈 칸
                visited[idx] = true;
                dup[c - 65] = true;
                list[idx] = c;
            }
        }
        if (!flag) System.out.println('!');
        else {
            /**
             * 4칸일 경우 원판을 시계방향으로 돌렸을 때
             * 0 1 2 3 이라면 배열은 0 3 2 1 순서이다.
             */
            if (idx != 0) {
                for (int i = idx; i > 0; i--) {
                    sb.append(visited[i] ? list[i] : '?');
                }
                // 0 처리
                sb.append(visited[0] ? list[0] : '?');
                // 나머지
                for (int i = n -1; i > idx; i--) {
                    sb.append(visited[i] ? list[i] : '?');
                }
            } else {
                // 0 처리
                sb.append(visited[0] ? list[0] : '?');
                // 나머지
                for (int i = n -1; i > 0; i--) {
                    sb.append(visited[i] ? list[i] : '?');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
