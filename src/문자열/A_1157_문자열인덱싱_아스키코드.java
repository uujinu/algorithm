package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제설명 : 문자열 내에서 빈도수 높은 문자 출력
 * 핵심개념 : 문자열 인덱싱
 */

public class A_1157_문자열인덱싱_아스키코드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        int[] arr = new int[26]; // 알파벳 등장한 빈도수 기록
        int maxNum = -1; int maxIdx = -1;
        boolean flag = false;

        for (int num : a) {
            int idx = num >= 97 ? num - 97 : num - 65; // 대소문자 구분 없이 빈도수 기록
            arr[idx]++;
            if (arr[idx] > maxNum) { // 최대값과 비교
                flag = false;
                maxNum = arr[idx];
                maxIdx = idx + 65;
            } else if (maxNum == arr[idx]) {
                flag = true;
            }
        }
        System.out.println(flag ? "?" : (char) maxIdx);
    }
}