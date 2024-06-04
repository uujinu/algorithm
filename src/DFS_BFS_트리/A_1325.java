package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_1325 {

    /**
     * A-B 신뢰관계 -> B 해킹 시 A도 해킹 가능
     * 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호 출력
     * DFS로 연결된 모든 컴퓨터 개수 구하기
     */

    static int n, num, max = Integer.MIN_VALUE;
    static List<Integer> graph[];
    static boolean[] visited;

    static void sol(int i) {
        if (!graph[i].isEmpty()) {
            for (int x : graph[i]) {
                if (!visited[x]) {
                    ++num;
                    visited[x] = true;
                    sol(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] res = new int[n];
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) { // 신뢰관계 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) { // 모든 컴퓨터에 대해 dfs
            visited = new boolean[n];
            num = 1;
            visited[i] = true;
            if (!graph[i].isEmpty()) sol(i);
            max = Math.max(max, num);
            res[i] = num; // 현재 컴퓨터가 감염시킬 수 있는 개수
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == max) sb.append(i + 1).append(" ");
        }
        System.out.println(sb.toString());
    }
}
