import java.io.*;
import java.util.*;

public class Main {
    static int T, l1, l2;
    static long ans;
    static Map<Integer, Integer> map1, map2;
    static int[] arr1, arr2, temp1, temp2;
    static Integer[] set1, set2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = 0;
        T = Integer.parseInt(br.readLine());
        l1 = Integer.parseInt(br.readLine());
        map1 = new HashMap<>();
        arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        temp1 = new int[arr1.length];
        l2 = Integer.parseInt(br.readLine());
        map2 = new HashMap<>();
        arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        temp2 = new int[arr2.length];
        calc(map1, arr1, temp1);
        calc(map2, arr2, temp2);
        set1 = map1.keySet().toArray(new Integer[0]);
        set2 = map2.keySet().toArray(new Integer[0]);
        Arrays.sort(set1);
        Arrays.sort(set2, Collections.reverseOrder());
        check();
        System.out.println(ans);
    }

    private static void calc(Map<Integer, Integer> map, int[] arr, int[] temp) {
        for (int s = 0; s < arr.length; s++) {
            for (int i = 0; i < arr.length - s; i++) {
                temp[i] += arr[i + s];
                map.put(temp[i], map.getOrDefault(temp[i], 0) + 1);
            }
        }
    }

    private static void check() {
        int i = 0, j = 0;
        while (i < set1.length && j < set2.length) {
            if (set1[i] + set2[j] == T) {
                ans += (long) map1.get(set1[i]) * map2.get(set2[j]);
                i++;
                j++;
            } else if (set1[i] + set2[j] < T) i++;
            else j++;
        }
    }
}