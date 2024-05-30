import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long value = Long.MAX_VALUE;
        long[] ans = new long[3];
        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        for (int i = 0; i < N - 2; i++) {
            int start = i + 1;
            int end = N - 1;
            while (end > start) {
                long now = arr[start] + arr[end] + arr[i];
                if (Math.abs(now) < value) {
                    value = Math.abs(now);
                    ans[0] = arr[i];
                    ans[1] = arr[start];
                    ans[2] = arr[end];
                    if (now == 0)
                        break;
                }
                if (now > 0)
                    end--;
                else
                    start++;
            }
            if (value == 0)
                break;
        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}