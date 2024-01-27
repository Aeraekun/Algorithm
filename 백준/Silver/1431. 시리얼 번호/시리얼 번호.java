import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> guitar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            guitar.add(br.readLine());
        }
        guitar.sort((o1, o2) -> {
            int temp = Integer.compare(o1.length(), o2.length());
            if (temp != 0) {
                return temp;
            } else {
                int n1 = 0;
                int n2 = 0;
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                        n1 += o1.charAt(i) - '0';
                    }
                    if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                        n2 += o2.charAt(i) - '0';
                    }
                }
                if (n1 != n2) return Integer.compare(n1, n2);
                else return o1.compareTo(o2);
            }
        });
        for (String s : guitar) {
            System.out.println(s);
        }
    }
}