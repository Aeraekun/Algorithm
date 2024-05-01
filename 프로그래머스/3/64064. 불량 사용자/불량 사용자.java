import java.io.*;
import java.util.*;

public class Solution {
	static int ans;
	static List<String>[] list;
	static Map<String, Boolean> map;
	static Set<String> set;
	static boolean[] check;

	public int solution(String[] user_id, String[] banned_id) {
		ans = 0;
		list = new ArrayList[banned_id.length];
		map = new HashMap<>();
		set = new HashSet<>();
		for (int i = 0; i < banned_id.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < user_id.length; i++) {
			map.put(user_id[i], false);
		}
		for (int i = 0; i < banned_id.length; i++) {
			for (int j = 0; j < user_id.length; j++) {
				if (banned_id[i].length() != user_id[j].length())
					continue;
				boolean check = true;
				for (int k = 0; k < banned_id[i].length(); k++) {
					if (banned_id[i].charAt(k) == '*')
						continue;
					if (banned_id[i].charAt(k) != user_id[j].charAt(k)) {
						check = false;
						break;
					}
				}
				if (check)
					list[i].add(user_id[j]);
			}
		}
		dfs(0, user_id, banned_id);
		return ans;
	}

	private static void dfs(int ban, String[] user_id, String[] banned_id) {
		if (ban == banned_id.length) {
			if (!set.contains(map.toString())) {
				set.add(map.toString());
				ans++;
			}
			return;
		}
		for (int j = 0; j < list[ban].size(); j++) {
			if (!map.get(list[ban].get(j))) {
				map.put(list[ban].get(j), true);
				dfs(ban + 1, user_id, banned_id);
				map.put(list[ban].get(j), false);
			}
		}
	}
}
