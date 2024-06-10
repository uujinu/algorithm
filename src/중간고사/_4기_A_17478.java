package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4기_A_17478 {

    static StringBuilder sb;
    static String[] s;
    static int n;

    static void sol(int depth) {
        if (depth == n) {
            for (int i = 4; i <= 6; i++) {
                for (int j = 0; j < depth; j++) {
                    sb.append("____");
                }
                sb.append(s[i]);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < depth; j++) {
                sb.append("____");
            }
            sb.append(s[i]);
        }
        sol(depth + 1);
        for (int j = 0; j < depth; j++) {
            sb.append("____");
        }
        sb.append(s[6]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        s = new String[7];
        n = Integer.parseInt(br.readLine()); // 출력원하는 재귀 횟수

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        s[0] = "\"재귀함수가 뭔가요?\"\n";
        s[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        s[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        s[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        // 마지막
        s[4] = "\"재귀함수가 뭔가요?\"\n";
        s[5] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
        s[6] = "라고 답변하였지.\n";

        sol(0);
        System.out.println(sb.toString());
    }
}
