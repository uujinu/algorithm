package 링크드리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class A_1406_링크드리스트 {

    /**
     * L, D, B, P $ 명령이 주어질 때
     * 모든 명령어를 수행하고 난 후 변경된 문자열을 출력한다.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();

        // 중간에 문자를 추가하고 삭제하는 연산이 있으므로 LinkedList 사용
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s) {
            list.add(c);
        }

        // 커서를 앞,뒤로 움직일 수 있는 listIterator 사용
        ListIterator<Character> it = list.listIterator();

        // 커서를 문장의 맨 뒤로 이동
        while (it.hasNext()) {
            it.next();
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 명령어 입력
            char c = st.nextToken().charAt(0);

            if (c == 'L' && it.hasPrevious()) { // 왼쪽으로 한 칸 옮김(커서가 문장 맨 앞이면 무시)
                it.previous();
            } else if (c == 'D' && it.hasNext()) { // 오른쪽으로 한 칸 옮김(커서가 문장 맨 뒤면 무시)
                it.next();
            } else if (c == 'B' && it.hasPrevious()) { // 커서 왼쪽 문자 삭제(커서가 문장 맨 앞이면 무시)

                // listIterator는 커서가 지나온 요소를 반환한다.
                // 커서의 왼쪽 요소를 삭제하기 위해 previos()로 왼쪽 요소를 지나간다.
                it.previous();

                it.remove(); // 왼쪽 요소 삭제
            } else if (c == 'P') { // 커서 왼쪽에 문자 추가
                char t = st.nextToken().charAt(0);
                it.add(t);
            }
        }
        for (char t : list) {
            sb.append(t);
        }
        System.out.println(sb.toString());
    }
}
