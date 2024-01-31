import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 1;
		int room = 1;
		int plus = 6;
		while (room < n) {
			room += plus;
			plus += 6;
			ans++;
		}
		System.out.println(ans);
	}
}