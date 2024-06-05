package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_11725_트리 {

    /**
     * 루트 노드로부터 시작하여 bfs를 이용하여 연결된 노드들을 방문하며
     * 부모 노드를 입력한다.
     *
     * 트리에서 각 노드는 오직 하나의 부모 노드를 갖는다.
     * 따라서 트리의 루트에서 시작하여 각 노드를 방문한다고 할 때,
     * 방문하는 노드의 이전 노드가 그 노드의 부모가 된다.
     *
     * 단, 방문한 노드를 표시하여 한 번 방문했던 노드는 다시 방문하지 않도록 한다.
     * 방문했다는 것은 해당 노드의 부모 노드를 이미 찾았다는 의미이기 때문이다.
     */

    // bfs 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine()); // 2~100000
        List<Integer>[] adjList = new ArrayList[n + 1];
        int[] arr = new int[n + 1]; // 부모 노드 표시할 배열
        boolean[] visited = new boolean[n];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a); // 노드 연결관계 저장
        }

        dq.add(1); // 루트노드 1부터 탐색
        visited[0] = true;

        while (!dq.isEmpty()) {
            int now = dq.poll(); // 현재 탐색할 노드
            if (!adjList[now].isEmpty()) {
                for (int x : adjList[now]) { // 현재 노드와 연결된 노트 순회

                    // 아직 방문하지 않은 노드는 현재 노드의 자식 노드이다.
                    if (!visited[x - 1]) {
                        visited[x - 1] = true;
                        arr[x] = now; // 현재 노드를 부모노드로 표시
                        dq.add(x);
                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) sb.append(arr[i]).append('\n');
        System.out.println(sb.toString());
    }
}
