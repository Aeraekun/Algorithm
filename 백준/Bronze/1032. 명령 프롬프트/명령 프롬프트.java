import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String arr[] = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();
        if (N == 1) System.out.println(arr[0]);
        for (int i = 0; i < arr[0].length(); i++) {
            for (int j = 1; j < N; j++) {
                if (arr[0].charAt(i) != arr[j].charAt(i)) {
                    System.out.print('?');
                    break;
                }
                if (j == N - 1) System.out.print(arr[0].charAt(i));
            }
        }
    }
}
