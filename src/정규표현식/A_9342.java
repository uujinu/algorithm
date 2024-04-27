package 정규표현식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_9342 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            if (s.matches("^[A-F]?A+F+C+[A-F]?$")) {
                sb.append("Infected!\n");
            } else sb.append("Good\n");
        }
        System.out.println(sb.toString());
    }
}
