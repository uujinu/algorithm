package 링크드리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class A_5397_링크드리스트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            LinkedList<Character> list = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            char[] s = br.readLine().toCharArray();
            ListIterator<Character> it = list.listIterator();

            for (char c : s) {
                if (c == '<') {
                     if (it.hasPrevious()) it.previous();
                } else if (c == '>') {
                    if (it.hasNext()) it.next();
                } else if (c == '-') {
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                } else it.add(c);
            }
            for (char c : list) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}