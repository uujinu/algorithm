package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_2606 {

    /**
     * 1번 컴퓨터를 통해 감염되는 컴퓨터의 수 구하기
     * bfs로 구현
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int res = -1;
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            list.add(tmp);
        }

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            list.get(a - 1).add(b - 1); // 연결 관계 저장
        }

        dq.add(0); // 1번 컴퓨터부터 탐색

        while (!dq.isEmpty()) {
            int now = dq.pop();
            if (!visited[now]) {
                visited[now] = true; // 감염
                res++;
            }

            // 현재 컴퓨터와 연결된 컴퓨터 중 아직 방문하지 않은 컴퓨터를 큐에 넣음
            List<Integer> tmp = list.get(now);
            for (int x : tmp) {
                if (!visited[x]) {
                    dq.add(x);
                }
            }
        }
        System.out.println(n == 1 ? 0 : res);
    }
}
