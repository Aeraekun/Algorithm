import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tMax, tMin, dMax, dMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tMax = new int[3];
        tMin = new int[3];
        dMax = new int[3];
        dMin = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                tMax[j] = tMin[j] = Integer.parseInt(st.nextToken());
            }
            tMax[0] += Math.max(dMax[0], dMax[1]);
            tMax[1] += Math.max(Math.max(dMax[0], dMax[1]), dMax[2]);
            tMax[2] += Math.max(dMax[1], dMax[2]);
            tMin[0] += Math.min(dMin[0], dMin[1]);
            tMin[1] += Math.min(Math.min(dMin[0], dMin[1]), dMin[2]);
            tMin[2] += Math.min(dMin[1], dMin[2]);
            for (int j = 0; j < 3; j++) {
                dMax[j] = tMax[j];
                dMin[j] = tMin[j];
            }
        }
        int ans1, ans2;
        ans1 = Math.max(Math.max(dMax[0], dMax[1]), dMax[2]);
        ans2 = Math.min(Math.min(dMin[0], dMin[1]), dMin[2]);
        System.out.println(ans1 + " " + ans2);
    }
}