package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class A_1935_스택_후위표기식 {

    // 연산자 여부 판별
    private static boolean isOperator(String s) {
        return s.equals("*") || s.equals("-") || s.equals("+") || s.equals("/");
    }

    // 두 수와 연산자를 입력받아 계산한 값 반환
    private static double operation(double a, double b, String oper) {
        if (oper.equals("+")) {
            return a + b;
        } else if (oper.equals("-")) {
            return a - b;
        } else if (oper.equals("/")) {
            return a / b;
        } else {
            return a * b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(""); // 후위식 입력
        int[] val = new int[n]; // 피연산자에 대응하는 값 저장할 배열

        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }

        // 후위식에서 피연산자를 입력받은 숫자로 변환
        for (int i = 0; i < arr.length; i++) {
            if (!isOperator(arr[i]))
                arr[i] = String.valueOf(val[arr[i].charAt(0) - 65]);
        }

        // LinkedList로 스택 사용
        // 스택에는 피연산자(숫자)만을 저장한다.
        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!isOperator(arr[i])) { // 숫자일 경우
                stack.push(arr[i]);
            } else { // 문자일 경우
                double b = Double.parseDouble(stack.pop());
                double a = Double.parseDouble(stack.pop());
                double result = operation(a, b, arr[i]);
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(String.format("%.2f", Double.parseDouble(stack.pop())));
    }
}
