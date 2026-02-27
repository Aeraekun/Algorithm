import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sum += temp;
            if (i <= 1) {
                if (temp > 100) {
                    System.out.println("hacker");
                    return;
                }
            } else if (i <= 3) {
                if (temp > 200) {
                    System.out.println("hacker");
                    return;
                }
            } else if (i <= 5) {
                if (temp > 300) {
                    System.out.println("hacker");
                    return;
                }
            } else if (i <= 7) {
                if (temp > 400) {
                    System.out.println("hacker");
                    return;
                }
            } else {
                if (temp > 500) {
                    System.out.println("hacker");
                    return;
                }
            }
        }
        System.out.println(sum >= 100 ? "draw" : "none");
    }
}