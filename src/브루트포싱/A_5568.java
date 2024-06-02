package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A_5568 {

    /**
     * 카드 N장 중 K장을 선택하여 만들 수 있는 모든 정수 구하기
     */

    static int n, k;
    static Set<Long> set;
    static int[] num;
    static boolean[] b;

    static void sol(StringBuilder sb, int depth) {
        if (depth == k) { // K장 사용 시
            set.add(Long.parseLong(sb.toString()));
            return;
        }
        if (depth == 0) sb.setLength(0);
        for (int i = 0; i < n; i++) {
            if (!b[i]) { // 아직 사용하지 않은 카드
                b[i] = true;
                sb.append(num[i]);
                sol(sb, depth + 1); // 재귀 호출
                int len = String.valueOf(num[i]).length();
                sb.delete(sb.length() - len, sb.length()); // 사용한 카드 제거
                b[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine()); // 4~10장, 1~99 숫자
        k = Integer.parseInt(br.readLine()); // 2~4장

        // 중복된 경우를 거르기 위해 HashSet 사용
        set = new HashSet<>();
        num = new int[n];
        b = new boolean[n];
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(br.readLine());
        sol(sb, 0);
        System.out.println(set.size());
    }
}
