import java.io.*;
import java.util.*;

public class Main {
    static String S, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();
        System.out.println(KMP() ? 1 : 0);
    }

    private static boolean KMP() {
        int[] pi = getPi();
        int j = 0;

        for (int i = 0; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (S.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) return true;
                else j++;
            }
        }
        return false;
    }

    private static int[] getPi() {
        int[] pi = new int[P.length()];
        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}