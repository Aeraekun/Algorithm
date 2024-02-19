import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(br.readLine());
            map.put(i, temp);
            set.add(temp);
        }
        while (true) {
            HashSet<Integer> toRemoveFromSet = new HashSet<>();
            for (int temp : map.keySet()) {
                if (!set.contains(temp)) {
                    toRemoveFromSet.add(temp);
                }
            }
            if (toRemoveFromSet.isEmpty()) break;
            for (int i : toRemoveFromSet)
                map.remove(i);
            set = new HashSet<>(map.values());
        }
        System.out.println(set.size());
        TreeSet<Integer> tree = new TreeSet<>(set);
        for (int i : tree)
            System.out.println(i);
    }
}
