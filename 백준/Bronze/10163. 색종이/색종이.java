import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[1001][1001];
        int x = 0, y = 0, a = 0, b = 0;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + a; j++) {
                for (int k = y; k < y + b; k++) {
                    arr[j][k] = i + 1;
                }
            }
        }
        for (int i = 0; i < t; i++) {
            int ans = 0;
            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if (arr[j][k] == i + 1) ans++;
                }
            }
            System.out.println(ans);
        }
    }
}