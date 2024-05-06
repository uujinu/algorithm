package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A_2504 {

    /**
     * 한 쌍의 괄호는 다음과 같은 값을 가진다.
     * () = 2, [] = 3
     *
     * 한 쌍의 괄호에 괄호집합이 포함될 경우
     * (x) = 2 * x
     * [x] = 3 * x
     *
     * 서로 붙어 있는 경우 더해줌
     * xy = x + y
     * -------------------------------------------------------
     * 괄호열을 나타내는 정수 출력, 올바르지 않은 괄호열일 경우 0 출력
     */

    public static boolean check(String c) { // 스택의 문자열이 숫자인지 괄호인지 검사
        return c.equals("(") || c.equals(")") || c.equals("[") || c.equals("]");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> tmp = new ArrayDeque<>(); // 스택으로 사용할 ArrayDeque

        String[] s = br.readLine().split(""); // 괄호열 입력 후 char 배열로 변환

        long res = 0;
        boolean flag = true; // 올바른 괄호열인지 체크

        // 괄호열의 처음, 끝 검사
        if (s[0].equals(")") || s[s.length - 1].equals("(") || s[0].equals("]") || s[s.length - 1].equals("[")) {
            flag = false;
        } else {
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("(") || s[i].equals("[")) { // 괄호 시작인 경우
                    // 이전 괄호 처리가 미완인 경우 실패
                    if (!tmp.isEmpty() && (tmp.peek().equals(")") || tmp.peek().equals("]"))) {
                        flag = false;
                        break;
                    } else { // 괄호 시작인 경우 스택에 넣음
                        tmp.push(s[i]);
                    }
                } else { // 괄호 닫는 연산자인 경우
                    if (tmp.isEmpty()) { // 스택이 텅 비어있음. 괄호쌍이 맞지 않음.
                        flag = false;
                        break;
                    } else {
                        long v = 0;
                        if (!check(tmp.peek())) { // 숫자가 나오는 경우 이전에 스택에 괄호 시작부분이 있는지 검사
                            v = Long.parseLong(tmp.pop());
                        }

                        if (!tmp.isEmpty()) {
                            String e = tmp.pop();
                            if (s[i].equals(")") && e.equals("(") || s[i].equals("]") && e.equals("[")) { // 괄호 완성

                                // 가운데 숫자가 있던 경우 숫자*2 or 숫자*3해주고, 아닌 경우 2 or 3
                                long vv = e.equals("(") ? v == 0 ? 2 : v * 2 : v == 0 ? 3 : v * 3;

                                // 그리고 스택에 숫자가 있으면 더해준다.
                                while (!tmp.isEmpty() && !check(tmp.peek())) {
                                    long temp = Long.parseLong(tmp.pop());
                                    vv += temp;
                                }
                                tmp.push(String.valueOf(vv)); // 계산 완료 후 스택에 다시 숫자 넣음
                            } else {
                                flag = false;
                                break;
                            }
                        } else { // 괄호 미완성
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }

        while(!tmp.isEmpty()) {
            if (check(tmp.peek())) {
                flag = false;
                break;
            } else {
                res += Long.parseLong(tmp.pop());
            }
        }

        if (flag && tmp.isEmpty()) System.out.println(res);
        else System.out.println(0);
    }
}
