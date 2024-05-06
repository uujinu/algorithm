package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A_10773 {

    /**
     * K개의 정수가 입력된다. 이때 0이 입력되면 가장 최근에 입력된 수를 지운다.
     * 남은 숫자들을 모두 더한 값을 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(); // 입력받은 수 저장할 리스트
        long res = 0; // 숫자들 더한 값

        while (n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) { // 0일 경우 가장 최근 리스트에 저장한 수를 지운다.
                int tmp = list.get(list.size() - 1);
                res -= tmp; // 합에서 지우는 숫자를 빼준다.
                list.remove(list.size() - 1); // 삭제
            } else {
                res += k; // 입력된 숫자를 합한다.
                list.add(k);
            }
        }
        System.out.println(res);
    }
}