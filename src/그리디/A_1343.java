package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_1343 {

    static void sol(StringBuilder sb, int num) {
        int aNum = num / 4;
        int bNum;
        if (aNum == 0) {
            bNum = num / 2;
        } else {
            bNum = (num % 4) / 2;
            while(aNum-- > 0) sb.append("AAAA");
        }
        while(bNum-- > 0) sb.append("BB");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] c = br.readLine().toCharArray();
        boolean flag = true;
        // 사전순으로 가장 앞서는 답
        int num = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'X') {
                num++;
            } else { // .인 경우
                if (num != 0) { // 문자열 붙이기
                    if (num % 2 == 0) {
                        sol(sb, num);
                        sb.append('.');
                    } else {
                        flag = false;
                        break;
                    }
                    num = 0;
                } else sb.append('.');
            }
        }
        if (flag && num != 0) {
            if (num % 2 == 0) {
                sol(sb, num);
            } else flag = false;
        }

        /*for (int i = 0; i < c.length; i++) {
            if (c[i] == 'X') {
                int idx = 0;
                while(idx < c.length && c[idx] == 'X') {
                    idx++;
                }
                int len = idx;
                System.out.println("len: " + len);
                if (len % 2 != 0) { // -1
                    flag = false;
                    break;
                }
                int aNum = len / 4;
                if (aNum == 0) { // BB로만 채움
                    int bNum = len / 2;
                    while(bNum-- > 0) sb.append("BB");
                } else { // AAAA 먼저 채우고 그 다움 BB
                    int bNum = (len % 4) / 2;
                    while(aNum-- > 0) sb.append("AAAA");
                    while(bNum-- > 0) sb.append("BB");
                }
                i += len - 1;
            } else sb.append('.');
        }*/
        System.out.println(flag ? sb.toString() : -1);
    }
}
