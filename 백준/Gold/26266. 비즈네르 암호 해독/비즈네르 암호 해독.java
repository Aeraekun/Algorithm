import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String a = br.readLine();
        String b = br.readLine();
        int[] arrA = new int[a.length()];
        int[] arrB = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            arrA[i] = a.charAt(i) - 'A' + 1;
            arrB[i] = b.charAt(i) - 'A' + 1;
        }

        for (int i = 1; i <= a.length(); i++) {
            if (a.length() % i != 0) continue;
            int[] key = new int[i];
            boolean ans = true;
            for (int j = 0; j < i; j++) {
                key[j] = (a.charAt(j) < b.charAt(j)) ? b.charAt(j) - a.charAt(j) : b.charAt(j) - a.charAt(j) + 26;
            }
            for (int j = i; j < a.length(); j++) {
                int temp = (a.charAt(j) < b.charAt(j)) ? b.charAt(j) - a.charAt(j) : b.charAt(j) - a.charAt(j) + 26;
                if (key[j % i] != temp) {
                    ans = false;
                    break;
                }
            }
            if (ans) {
                for (int k : key) {
                    char temp = (char) (k - 1 + 'A');
                    sb.append(temp);
                }
                break;
            }
        }

        System.out.println(sb);
    }
}