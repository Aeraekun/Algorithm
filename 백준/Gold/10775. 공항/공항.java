import java.io.*;

public class Main {
	static int G, P, ans;
	static int[] gate, plane;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 0;
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		gate = new int[G + 1];
		plane = new int[P];
		for (int i = 0; i <= G; i++) {
			gate[i] = i;
		}
		for (int i = 0; i < P; i++) {
			plane[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < P; i++) {
			int temp = plane[i];
			boolean check = false;
			while (true) {
				if (gate[temp] == 0) {
					check = true;
					break;
				}
				if (gate[temp] == temp) {
					gate[plane[i]] = gate[temp] = temp - 1;
					ans++;
					break;
				}
				temp = gate[temp];
			}
			if (check)
				break;
		}
		System.out.println(ans);
	}
}
