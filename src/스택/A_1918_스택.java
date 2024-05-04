package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class A_1918_스택 {

    // 연산자 판별
    private static boolean isOperator(String s) {
        return s.equals("*") || s.equals("-") || s.equals("+") || s.equals("/");
    }

    // 연산자 우선순위 판별
    private static int compareOperator(String o, String p) {
        if (o.equals("*") || o.equals("/")) {
            if (p.equals("*") || p.equals("/")) return 0;
            else return 1;
        } else {
            if (p.equals("*") || p.equals("/")) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split("");
        LinkedList<String> stack = new LinkedList<>();

        /**
         * 숫자는 순서대로 출력되므로 숫자가 나오면 바로 append한다.
         * stack에는 괄호 및 연산자만 push한다.
         */

        for (int i = 0; i < s.length; i++) {
            char c = s[i].charAt(0);
            if (c >= 65 && c <= 90) { // 숫자일 경우 바로 append
                sb.append(s[i]);
            } else if (s[i].equals("(")) { // 괄호 시작일 경우 stack에 push
                stack.push(s[i]);
            } else if (s[i].equals(")")) { // 괄호 끝일 경우
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(s[i])) { // 연산자인 경우
                // 스택의 제일 윗부분에 연산자가 있고, 그 연산자가 자신보다 중요도가 크거나 같을 경우 먼저 써준다.
                while (!stack.isEmpty() && isOperator(stack.peek()) && compareOperator(s[i], stack.peek()) <= 0) {
                    sb.append(stack.pop());
                }
                stack.push(s[i]); // 그리고 끝에 현재 연산자를 써준다.
            }
        }

        // 아직 스택에 남아있는 연산자가 있다면 나머지를 써준다.
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
