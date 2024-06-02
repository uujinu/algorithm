package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_15721 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()), t = Integer.parseInt(br.readLine()), c = Integer.parseInt(br.readLine());
        int loc = -1, numA = 0, numB = 0, idx = 1;
        int num = 1;
        while(true) {
            for (int i = 0; i < 4; i++) { // 뻔 - 데기 - 뻔 - 데기
                ++loc; // 원탁에서 몇번째에 있는지
                if (loc == a) loc = 0; // 끝번호라면 0으로 초기화
                idx = idx == 1 ? 0 : 1; // 구호

                if (idx == 0) ++numA; // 뻔 숫자 증가
                else ++numB; // 데기 숫자 증가

                if (c == idx) { // 구하고자 하는 구호라면
                    // 구하고자 하는 번째라면
                    if (idx == 0 && numA == t || idx == 1 && numB == t) {
                        System.out.println(loc);
                        return;
                    }
                }
            }

            idx = 0; // 구호 뻔으로 고정
            for (int i = 0; i < num + 1; i++) { // 뻔 x (n+1)
                ++loc;
                if (loc == a) loc = 0;
                ++numA;

                if (c == idx) {
                    if (idx == 0 && numA == t || idx == 1 && numB == t) {
                        System.out.println(loc);
                        return;
                    }
                }
            }

            idx = 1; // 구호 데기로 고정
            for (int i = 0; i < num + 1; i++) { // 데기 x (n+1)
                ++loc;
                if (loc == a) loc = 0;
                ++numB;

                if (c == idx) {
                    if (idx == 0 && numA == t || idx == 1 && numB == t) {
                        System.out.println(loc);
                        return;
                    }
                }
            }
            ++num; // 회차
        }
    }
}
