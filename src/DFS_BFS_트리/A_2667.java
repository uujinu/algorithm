package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_2667 {
    /*
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list;
    static ArrayDeque<int[]> q;

    static void bfs(int n) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        num++;
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dir[k][0], ny = now[1] + dir[k][1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (!visited[nx][ny] && map[nx][ny] == 1) {
                                    visited[nx][ny] = true;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    list.add(num);
                    num = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        list = new ArrayList<>();
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(n);
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for (int x : list) {
            sb.append(x).append('\n');
        }
        System.out.println(sb.toString());
    }
     */

    static int n, num;
    static List<Integer> list;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void group(int i, int j, int g) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 1) {
                        ++num;
                        map[nx][ny] = g;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    ++num;
                    map[i][j] = num + 1;
                    group(i, j, num + 1);
                    list.add(num);
                    num = 0;
                }
            }
        }
        sb.append(list.size()).append('\n');
        list.sort((a, b) -> a - b);
        list.stream().forEach(a -> sb.append(a).append('\n'));
        System.out.println(sb.toString());
    }
}
