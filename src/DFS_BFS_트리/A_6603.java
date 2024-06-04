package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_6603 {

    /*
    static int end;
    static int[] arr;
    static int[] tmpArr;
    static StringBuilder sb;

    static void sol(int idx, int numIdx) {
        if (idx == 6) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append('\n');
            return;
        }
        if (numIdx == end) return;

        // 선택
        arr[idx] = tmpArr[numIdx];
        sol(idx + 1, numIdx + 1);

        // 선택 x
        arr[idx] = 0;
        sol(idx, numIdx + 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            int[] num = new int[k];
            for (int i = 0; i < k; i++) num[i] = Integer.parseInt(st.nextToken());
            // 수를 고르는 모든 방법
            tmpArr = num;
            arr = new int[6];
            end = k;
            sol(0, 0);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

     */

    static int n, k;
    static int[] a;
    static StringBuilder sb;
    static boolean[] visited;

    static void sol(int depth, int idx) {
        if (depth == 0 && idx > n - 5) return; // 6개를 고를 수 없으면 return
        if (depth == 6) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) sb.append(a[i + 1]).append(" ");
            }
            sb.append('\n');
            return;
        }
        if (idx > n) return;

        visited[idx - 1] = true;
        sol(depth + 1, idx + 1);
        visited[idx - 1] = false;
        sol(depth, idx + 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String s;

        while (!(s = br.readLine()).equals("0")) {
            a = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            k = a[0];
            n = a.length - 1;
            visited = new boolean[n];
            sol(0, 1);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
