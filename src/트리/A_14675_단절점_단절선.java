package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A_14675_단절점_단절선 {

    /**
     * 단절점: 해당 정점 제거 시 그 정점이 포함된 그래프가 2개 이상으로 나뉨
     * 단절선: 해당 간선 제거 시 그 간선이 포함된 그래프가 2개 이상으로 나뉨
     * 트리: 사이클이 존재하지 않으며, 모든 정점이 연결된 그래프
     *
     * - 단절점 조건
     *   - 어떤 정점 A가 dfs tree 상에서 root가 아니고,
     *     정점 A의 자손 정점 중 A를 거치지 않고 A 이전에 탐색했던 정점에 갈 수 없다면
     *     정점 A는 단절점이다.
     *   - 어떤 정점 A가 dfs tree 상에서 root이고,
     *     해당 노드의 자식 노드 수가 2개 이상이면 단절점이다.
     *     - 연결 노드가 한개밖에 없는 경우 단절점이 아니다.
     *       ex) 리프 노드는 제거해도 트리 개수에 변화가 없다.
     *
     * - 간선 제거일 경우: 어떠한 경우라도 그래프가 2개 이상으로 나눠지므로 항상 yes
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            list[b].add(a);
        }
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()) - 1;
            if (t == 1 && list[k].size() <= 1) sb.append("no\n");
            else sb.append("yes\n");
        }
        System.out.println(sb.toString());
    }
}
