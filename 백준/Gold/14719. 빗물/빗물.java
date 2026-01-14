import java.io.*;
import java.util.*;

public class Main {
    static int H, W, maxH, maxW, ans;
    static int leftMax, rightMax;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > maxH) {
                maxH = arr[i];
                maxW = i;
            }
        }
        for (int i = 0; i < maxW; i++) {
            if (arr[i] > leftMax) {
                leftMax = arr[i];
            } else {
                ans += (leftMax - arr[i]);
            }
        }
        for (int i = W - 1; i > maxW; i--) {
            if (arr[i] > rightMax) {
                rightMax = arr[i];
            } else {
                ans += (rightMax - arr[i]);
            }
        }
        System.out.println(ans);
    }
}