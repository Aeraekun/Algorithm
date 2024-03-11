import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int now, ans;
        now = ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                if (str.charAt(i + 1) == '(') {
                    now++;
                } else {
                    ans += now;
                    i++;
                }
            } else {
                if (now != 0) {
                    ans++;
                    now--;
                }
            }
        }
        System.out.println(ans);
    }
}