package 큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A_1966_큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 타겟 문서 인덱스
            int order = 0; // 인쇄 순서
            int max = -1;
            int min = 10;

            st = new StringTokenizer(br.readLine()); // 문서 중요도 입력

            // 문서 저장할 큐 사용
            Queue<Integer> queue = new ArrayDeque<>();

            while (st.hasMoreTokens()) { // 문서 중요도의 최대값, 최소값 구하고, 큐에 저장
                int priority = Integer.parseInt(st.nextToken());
                max = Math.max(max, priority);
                min = Math.min(min, priority);
                queue.add(priority);
            }

            if (min == max) { // 중요도가 모두 같을 경우 바로 출력
                sb.append(m + 1);
            } else {
                while (!queue.isEmpty()) {
                    boolean flag = true;
                    int i = 0;
                    int tmp = queue.poll();

                    while (i++ < queue.size()) {
                        if (queue.isEmpty()) {
                            break;
                        } else if (queue.peek() > tmp) {
                            queue.add(tmp);
                            if (m != 0) m--;
                            else m = queue.size() - 1;
                            flag = false;
                            break;
                        } else {
                            queue.add(tmp);
                            if (m != 0) m--;
                            else m = queue.size() - 1;
                        }
                    }
                    if (!flag) continue;;
                    order++;
                    if (m == 0) {
                        sb.append(order).append('\n');
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}