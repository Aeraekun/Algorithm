import java.io.*;
import java.util.*;

public class Main {
    static int T, l1, l2;
    static long ans;
    static Map<Integer, Integer> map1, map2;
    static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = 0;
        T = Integer.parseInt(br.readLine());
        l1 = Integer.parseInt(br.readLine());
        map1 = new HashMap<>();
        arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        l2 = Integer.parseInt(br.readLine());
        map2 = new HashMap<>();
        arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        calc(map1, arr1);
        calc(map2, arr2);

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key1 = entry.getKey();
            int count1 = entry.getValue();
            int key2 = T - key1;

            if (map2.containsKey(key2)) {
                ans += (long) count1 * map2.get(key2);
            }
        }

        System.out.println(ans);
    }

    private static void calc(Map<Integer, Integer> map, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }
}