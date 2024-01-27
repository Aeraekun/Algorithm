import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;
        int[] arr = new int[1000];
        for (int i = 123; i <= 987; i++) {
            String temp = Integer.toString(i);
            if (temp.charAt(0) == temp.charAt(1) || temp.charAt(0) == temp.charAt(2) || temp.charAt(1) == temp.charAt(2) ||
                    temp.charAt(0) == '0' || temp.charAt(1) == '0' || temp.charAt(2) == '0') arr[i] = -1;
        }
        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            String count = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (s == 3) {
                ans = 1;
                break;
            }
            for (int i = 123; i <= 987; i++) {
                if (arr[i] == -1) continue;
                String temp = Integer.toString(i);
                int str = 0;
                int ball = 0;
                for (int j = 0; j < 3; j++) {
                    int idx = count.indexOf(temp.charAt(j));
                    if (idx != -1) {
                        if (idx == j) str++;
                        else ball++;
                    }
                }
                if (s != str || b != ball) arr[i] = -1;
            }
        }
        for (int i = 123; i <= 987; i++) {
            if (arr[i] == 0) ans++;
        }
        System.out.println(ans);
    }
}
