package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class A_1012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 가로세로 m, n : 1~50, k : 1~2500
            int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            int[][] veg = new int[k][2]; // 배추 위치 저장
            int res = 0;
            ArrayDeque<int[]> arr = new ArrayDeque<>();
            boolean[][] v = new boolean[n][m];

            for (int i = 0; i < k; i++) { // 배추 위치 입력
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
                veg[i][0] = x;
                veg[i][1] = y;
                map[x][y] = 1;
            }

            for (int i = 0; i < k; i++) { // 입력받은 배추들
                if (v[veg[i][0]][veg[i][1]]) continue;

                arr.add(veg[i]);
                v[veg[i][0]][veg[i][1]] = true;

                while (!arr.isEmpty()) { // 현재 배추와 인접한 배추들을 모두 순회한다.
                    int[] now = arr.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                        // 범위 내
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (map[nx][ny] == 1 && !v[nx][ny]) {
                                arr.add(new int[]{nx, ny});
                                v[nx][ny] = true;
                            }
                        }
                    }
                }

                // 지렁이는 인접한 곳마다 1개씩이므로
                // 인접한 곳을 모두 탐색했으면 지렁이 개수를 한 개 늘린다.
                res++;
            }
            sb.append(res).append('\n');
        }
        System.out.println(sb.toString());
    }
}
