package 덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class A_2164 {

    /**
     * 위에서부터 1번 ~ N번의 카드가 놓여 있다.
     *
     * 반복 : 제일 위의 카드를 버리고
     *       그 다음 제일 위에 있는 카드를 제일 아래 카드 밑으로 옮긴다.
     * -----------------------------------------------------------
     * 반복 후 제일 마지막에 남는 카드를 구한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 덱 선언
        Deque<Integer> d = new ArrayDeque<>();

        // 1부터 N까지의 수를 덱에 넣어준다.
        for (int i = 1; i <= n; i++) {
            d.offer(i);
        }

        // 덱에 한 개의 숫자가 남을 때까지 동작을 반복한다.
        while (d.size() > 1) {
            d.poll(); // 맨 위(헤드 쪽) 숫자 제거
            d.offer(d.poll()); // 맨 위 숫자를 맨 아래로 옮김
        }

        // 마지막으로 남은 숫자를 출력한다.
        System.out.println(d.poll());
    }
}