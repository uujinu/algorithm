package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A_13023 {

    /**
     * dfs로 탐색하여 연결된 친구가 5명 되는지 구하기
     */

    static int n, res;
    static boolean[] visited;
    static List<Integer>[] list;

    static void dfs(int depth, int num) {
        if (depth == 5) {
            res = 1;
            return;
        }

        if (!list[num].isEmpty()) {
            for (int x : list[num]) {
                if (!visited[x]) {
                    visited[x] = true;
                    dfs(depth + 1, x);
                    if (res == 1) return;
                    visited[x] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            if (!list[i].isEmpty()) {
                visited[i] = true;
                dfs(1, i);
                if (res == 1) break;
                visited[i] = false;
            }
        }
        System.out.println(res);
    }
}
