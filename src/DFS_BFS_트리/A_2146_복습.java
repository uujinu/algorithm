package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_2146_복습 {

    static int n, res = Integer.MAX_VALUE;
    static int[][] map, len, visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 섬의 해안가 좌표를 저장
    static Queue<int[]> loc = new ArrayDeque<>();
    // n개 섬의 각 해안가 좌표들을 큐로 받아 저장
    static Queue<Queue<int[]>> allLoc = new ArrayDeque<>();

    static void group() {
        Queue<int[]> q = new ArrayDeque<>();

        int num = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = num;
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()) {
                        boolean flag = false; // 바다와 맞닿아 있는 곳인지
                        int[] now = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (map[nx][ny] == 1) {
                                    map[nx][ny] = num;
                                    q.add(new int[]{nx, ny});
                                } else if (map[nx][ny] == 0) { // 바다와 맞닿아 있음
                                    flag = true;
                                }
                            }
                        }
                        if (flag) { // 바다와 맞닿아 있는 좌표 저장
                            loc.add(new int[]{now[0], now[1], num});
                        }
                    }
                    ++num;
                    allLoc.add(loc); // n번째 섬의 해안가 좌표를 모은 loc을 추가
                }
            }
        }
    }

    public static int sol() {
        while (!allLoc.isEmpty()) {
            Queue<int[]> tmp = allLoc.poll(); // n번째 섬의 해안가에서 출발한 좌표들
            int size = tmp.size();
            while (size-- > 0) {
                int[] now = tmp.poll();
                int num = len[now[0]][now[1]]; // 현재까지 거리
                if (num >= res) continue; // 현재까지의 최소 거리 이상이면 넘어감

                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (map[nx][ny] == 0) { // 바다인 경우
                            if (visited[nx][ny] == 0) { // 처음 방문
                                visited[nx][ny] = now[2]; // 어떤 섬에서 출발한 건지 표시
                                len[nx][ny] = num + 1;
                                tmp.add(new int[]{nx, ny, now[2]});
                            } else if (visited[nx][ny] != 0 && visited[nx][ny] != now[2]) { // 다른 섬에서 이미 온 바다
                                res = Math.min(res, num + len[nx][ny]);
                            }
                        } else if (map[nx][ny] != now[2]) { // 다른 섬에 도착
                            res = Math.min(res, num);
                        }
                    }
                }
            }
            if (tmp.size() > 0) allLoc.add(tmp); // 이동할 좌표가 남아있다면 추가
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        len = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 1. 섬 번호 매기기
        group();

        // 2. 각 섬마다 바다에 인접한 부분 bfs
        // 바다에 인접한 좌표에서 바다로 한칸씩 전진하며 거리 기록
        System.out.println(sol());
    }
}
