package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A_9012_스택 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] c = br.readLine().toCharArray();
            if (c[0] == ')' || c[c.length - 1] == '(') { // 처음과 끝이 괄호쌍을 이루지 못할 경우 배제
                sb.append("NO\n");
            } else {
                // 한쪽 끝에서만 데이터를 입력, 삭제할 것이므로 ArrayList 사용
                List<Character> s = new ArrayList<>();
                boolean flag = true;
                for (int i = 0; i < c.length; i++) {
                    if (c[i] == ')') {
                        if (s.isEmpty()) { // 괄호 완성이 안 될 경우 실패
                            flag = false;
                            break;
                        } else if (s.get(s.size() - 1) == '(') { // 괄호 완성인 경우 괄호 제거
                            s.remove(s.size() - 1);
                        }
                    } else s.add(c[i]); // 괄호 시작일 경우 add
                }
                if (s.isEmpty() && flag) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
