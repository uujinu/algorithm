package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class A_2870 {

    /**
     * 입력받은 문자에서 숫자만 찾아 오름차순으로 출력하기
     * 숫자의 앞에 0이 있는 경우 생략 가능
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<BigInteger> res = new ArrayList<>();

        while (n-- > 0) {
            char[] c = br.readLine().toCharArray();

            int start = 0;
            if (c.length > 0 && c[0] == '0') start = 1;

            for (int i = start; i < c.length; i++) {
                if (c[i] >= '0' && c[i] <= '9') { // 숫자인 경우
                    tmp.append(c[i]);
                } else {
                    if (tmp.length() > 0) {
                        res.add(new BigInteger(tmp.toString()));
                        tmp.setLength(0);
                    }
                }
            }
            if (tmp.length() > 0) {
                res.add(new BigInteger(tmp.toString()));
                tmp.setLength(0);
            }
        }

        res.sort((a1, a2) -> a1.compareTo(a2)); // 오름차순으로 정렬

        for (BigInteger a : res) {
            sb.append(a).append('\n');
        }

        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
