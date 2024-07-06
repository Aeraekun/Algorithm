import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long ans;
    static int[] A, B, C, D;
    static int[] arrA, arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ans = 0;
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];
        arrA = new int[n * n];
        arrB = new int[n * n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrA[a] = A[i] + B[j];
                arrB[a++] = C[i] + D[j];
            }
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int left = 0, right = n * n - 1;
        while (left < n * n && right >= 0) {
            if (arrA[left] + arrB[right] < 0)
                left++;
            else if (arrA[left] + arrB[right] > 0)
                right--;
            else {
                long lc = 1, rc = 1;
                while (left + 1 < n * n && arrA[left] == arrA[left + 1]) {
                    lc++;
                    left++;
                }
                while (right > 0 && arrB[right] == arrB[right - 1]) {
                    rc++;
                    right--;
                }
                ans += lc * rc;
                left++;
            }
        }
        System.out.println(ans);
    }
}