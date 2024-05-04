package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A_10799_스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        List<Character> stack = new ArrayList<>();
        int res = 0;

        for (int i = 0; i < c.length; i++) {
            // 이전 위치가 (이고, 현재 위치(c[i])가 )이면 레이저이다.
            if (i != 0 && c[i - 1] == '(' && c[i] == ')') {
                // 스택에서 레이저의 시작 부분인 (를 제거한다.
                stack.remove(stack.size() - 1);

                // 스택에 저장되어 있는(레이저 범위 내에 있는) 쇠막대기 개수 더해줌
                res += stack.size();
            } else if (c[i] == '(') { // 쇠막대기 시작 or 레이저 시작 부분을 스택에 저장
                stack.add(c[i]);
            } else { // 쇠막대기가 끝나는 부분으로 마지막으로 잘려진 부분 1을 더해준다.
                res++;
                stack.remove(stack.size() - 1);
            }
        }
        System.out.println(res);
    }
}
