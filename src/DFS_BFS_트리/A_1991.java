package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_1991 {

    /**
     * 루트노드는 A
     * 자식 노드가 없는 경우 . 으로 표현
     *
     * 0: 부모 노드 붙이기
     * 1: 왼쪽 자식 노드 순회
     * 2: 오른쪽 자식 노드 순회
     *
     * 재귀로 구현
     */

    static StringBuilder sb;
    static List<Character>[] q;

    // 전위, 중위, 후위 순회 순서
    static int[][] order = {{0, 1, 2}, {1, 0, 2}, {1, 2, 0}};

    static void sol(char c, int o) {

        for (int i = 0; i < 3; i++) {
            if (order[o][i] == 0) { // 부모 노드
                sb.append(c);
            } else if (order[o][i] == 1) {
                if (q[c - 65].get(0) != '.') { // 왼쪽 자식노드
                    sol(q[c - 65].get(0), o);
                }
            } else {
                if (q[c - 65].get(1) != '.') { // 오른쪽 자식노드
                    sol(q[c - 65].get(1), o);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        q = new ArrayList[26];
        for (int i = 0; i < 26; i++) q[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0) - 65;
            q[p].add(st.nextToken().charAt(0));
            q[p].add(st.nextToken().charAt(0));
        }

        for (int i = 0; i < 3; i++) {
            sol('A', i);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
