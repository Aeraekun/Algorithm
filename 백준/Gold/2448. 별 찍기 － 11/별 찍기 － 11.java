import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++)
            Arrays.fill(map[i], ' ');
        draw(0, N - 1, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                bw.write(map[i][j]);
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }

    private static void draw(int y, int x, int n) {
        if (n == 3) {
            map[y][x] = map[y + 1][x - 1] = map[y + 1][x + 1] = map[y + 2][x - 2] = map[y + 2][x - 1] = map[y + 2][x] = map[y + 2][x + 1] = map[y + 2][x + 2] = '*';
            return;
        }
        draw(y, x, n / 2);
        draw(y + n / 2, x + n / 2, n / 2);
        draw(y + n / 2, x - n / 2, n / 2);
    }
}