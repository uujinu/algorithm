package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A_19583 {

    /**
     * 개강총회 시작 전
     * - 시작 시간 이전 ~ 시작 시간까지 채팅 기록 남긴 사람
     *
     * 개강총회 끝난 후 ~ 스트리밍 끝낼 때까지
     * - 끝나고 스트리밍 끝날 때까지 채팅 기록 남긴 사람
     * - 스트리밍 끝난 시간 이후 남겨진 채팅은 제외
     * -------------------------------------------------
     * 입장, 퇴장 모두 확인된 회원 수를 구하기.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] a = new String[3];
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            a[i] = st.nextToken().replace(":", "");
        }

        // 시작시간, 끝낸 시간, 스트리밍 끝낸 시간
        int res = 0;
        String s;
        while((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            String time = st.nextToken().replace(":", "");
            String name = st.nextToken();

            // 출석 체크 동안만 다룸
            if (a[0].compareTo(time) >= 0) { // 입장
                map.put(name, "");
            } else if (a[1].compareTo(time) <= 0 && a[2].compareTo(time) >= 0) { // 퇴장
                if (map.containsKey(name)) {
                    res++;
                    map.remove(name);
                }
            }
        }
        System.out.println(res);
    }
}
