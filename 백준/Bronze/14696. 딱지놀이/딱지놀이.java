import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int t = 0; t < n; t++) {
            int[] a = new int[4];
            int[] b = new int[4];
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                int temp = Integer.parseInt(st.nextToken());
                a[temp - 1]++;
            }
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                int temp = Integer.parseInt(st.nextToken());
                b[temp - 1]++;
            }
            for (int i = 3; i >= 0; i--) {
                if (a[i] > b[i]) {
                    System.out.println('A');
                    break;
                } else if (a[i] < b[i]) {
                    System.out.println('B');
                    break;
                }
                if (i == 0) {
                    System.out.println('D');
                }
            }
        }
    }
}