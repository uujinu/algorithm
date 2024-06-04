package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_1260 {

    static List<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int i) {
        sb.append(i + 1).append(" ");
        visited[i] = true;
        for (int k = 0; k < adj[i].size(); k++) {
            if (!visited[adj[i].get(k)]) {
                dfs(adj[i].get(k));
            }
        }
    }

    static void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[i] = true;
        sb.append(i + 1).append(" ");
        q.add(i);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int k = 0; k < adj[now].size(); k++) {
                if (!visited[adj[now].get(k)]) {
                    visited[adj[now].get(k)] = true;
                    sb.append(adj[now].get(k) + 1).append(" ");
                    q.add(adj[now].get(k));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()) - 1;
        adj = new List[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 0; i < n; i++) adj[i].sort((a, b) -> a - b);

        visited = new boolean[n];
        dfs(v);
        sb.append('\n');
        visited = new boolean[n];
        bfs(v);
        System.out.println(sb.toString());
    }
}
