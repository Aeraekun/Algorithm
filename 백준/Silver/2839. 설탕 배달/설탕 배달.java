import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = n / 5; i >= 0; i--) {
			if ((n - i * 5) % 3 == 0) {
				System.out.println((n - i * 5) / 3 + i);
				return;
			}
		}
		System.out.println(-1);
	}
}
