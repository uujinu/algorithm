package 큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class A_18258_큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // 큐 구현을 위한 ArrayDeque 사용(LinkedList 보다 속도가 빠름)
        ArrayDeque<Integer> q = new ArrayDeque<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            if (x.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num); // 맨 뒤에 요소 추가
            } else if (x.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.remove()).append("\n"); // 맨 앞의 요소 삭제
            } else if (x.equals("size")) {
                sb.append(q.size()).append("\n"); // 큐의 사이즈 반환
            } else if (x.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
            } else if (x.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.getFirst()).append("\n"); // 맨 앞 요소 반환
            } else {
                sb.append(q.isEmpty() ? -1 : q.getLast()).append("\n"); // 맨 뒤 요소 반환
            }
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
