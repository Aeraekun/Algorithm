import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        boolean stat = false;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '<') {
                stat = true;
            } else if (st.charAt(i) == '>') {
                sb.append(st.charAt(i));
                stat = false;
                temp = i + 1;
                continue;
            } else if (st.charAt(i) == ' ') {
                sb.append(st.charAt(i));
                temp = i + 1;
                continue;
            }
            if (stat) sb.append(st.charAt(i));
            else sb.insert(temp, st.charAt(i));
        }
        System.out.println(sb);
    }
}
