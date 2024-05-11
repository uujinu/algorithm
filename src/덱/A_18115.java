package 덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class A_18115 {

    /**
     * 카드 기술 3가지
     * 1. 제일 위의 카드 1장을 바닥에 내려놓는다.
     * 2. 위에서 두 번째 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
     * 3. 제일 밑에 있는 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
     *
     * 기술을 N번 사용하여 카드를 내려놓았을 때 놓여 있는 카드는
     * 위에서부터 순서대로 1 ~ N이 적혀있다.
     * ----------------------------------------------------------------------
     * 처음에 배치되었던 카드의 순서를 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] c = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        // 덱 선언
        Deque<Integer> d = new ArrayDeque<>();

        int num = 1;

        // 입력받은 카드기술의 순서를 거꾸로 따라하면서 덱에 카드 번호를 추가한다.
        for (int i = n - 1; i >= 0; i--) {
            if (c[i].equals("1")) { // 기술 1: 맨 위 카드 1장을 내려놓는다.

                d.addFirst(num); // 맨 앞에 카드를 추가한다.

            } else if (c[i].equals("2")) { // 기술 2: 맨 위에서 두번째 카드를 내려놓는다.

                if (d.size() >= 1) {
                    int tmp = d.removeFirst(); // 맨 위 카드 제거
                    d.addFirst(num); // 두번째 위치에 카드 추가
                    d.addFirst(tmp); // 맨 위 카드 다시 추가
                }

            } else { // 기술 3: 제일 맨 밑 카드를 내려놓는다.
                if (d.size() >= 1) {
                    d.addLast(num);
                }
            }
            num++;
        }

        for (int x : d) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }
}
