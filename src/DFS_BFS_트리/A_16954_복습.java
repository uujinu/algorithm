package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class A_16954_복습 {

    static String[][] map = new String[8][8], tmp = new String[8][8];
    static int[][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    static int sol() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{7, 0});
        int time = 0;

        while(!q.isEmpty()) {
            if (time == 8) return 1;

            int size = q.size();
            while(size-- > 0) {
                // 캐릭터 이동
                int[] loc = q.poll();

                if (tmp[loc[0]][loc[1]].equals("#")) {
                    continue;
                }
                if (loc[0] == 0 && loc[1] == 7) return 1;

                for (int d = 0; d < dir.length; d++) {
                    int nx = loc[0] + dir[d][0], ny = loc[1] + dir[d][1];
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        if (nx < time) return 1;
                        if (tmp[nx][ny].equals(".")) {
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            ++time;


            // 벽 이동
            for (int i = 0; i < time; i++) {
                for (int j = 0; j < 8; j++) {
                    tmp[i][j] = ".";
                }
            }
            for (int i = 0; i < 8 - time; i++) tmp[time + i] = Arrays.copyOf(map[i], 8);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            map[i] = br.readLine().split("");
            tmp[i] = Arrays.copyOf(map[i], 8);
        }
        System.out.println(sol());
    }
}
