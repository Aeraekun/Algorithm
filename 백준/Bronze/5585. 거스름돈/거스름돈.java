import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((1000 - n) / 500 + (1000 - n) % 500 / 100 + (1000 - n) % 100 / 50 + (1000 - n) % 50 / 10
				+ (1000 - n) % 10 / 5 + (1000 - n) % 5);
	}
}
