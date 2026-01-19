import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans; // N: 단어 갯수, K: 가르칠 글자 수
    static String[] str = new String[50]; // 문장
    static boolean[] spell = new boolean[26];
    static boolean[][] alphabet = new boolean[50][26];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }

        for (int n = 0; n < N; n++) {
            str[n] = br.readLine();
        }

        spell['a' - 'a'] = true;
        spell['n' - 'a'] = true;
        spell['t' - 'a'] = true;
        spell['i' - 'a'] = true;
        spell['c' - 'a'] = true;

        for (int n = 0; n < N; n++) {
            alphabet[n]['a' - 'a'] = true;
            alphabet[n]['n' - 'a'] = true;
            alphabet[n]['t' - 'a'] = true;
            alphabet[n]['i' - 'a'] = true;
            alphabet[n]['c' - 'a'] = true;
            for (int i = 4; i < str[n].length() - 4; i++) {
                char now = str[n].charAt(i);
                if (!alphabet[n][now - 'a']) {
                    alphabet[n][now - 'a'] = true;
                }
            }
        }

        setSpell(1, 5);

        System.out.println(ans);
    }

    private static void setSpell(int idx, int k) {
        if (k == K) {
            cal();
        }
        for (int i = idx; i < 26; i++) {
            if (!spell[i]) {
                spell[i] = true;
                setSpell(i + 1, k + 1);
                spell[i] = false;
            }
        }
    }

    private static void cal() {
        int temp = 0;
        for (int n = 0; n < N; n++) {
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (alphabet[n][i] && !spell[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) temp++;
        }
        ans = Math.max(ans, temp);
    }
}