import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length / 2;
        Set<Integer> set = new HashSet();
        for(int i : nums)
            set.add(i);
        return set.size() > N ? N : set.size();
    }
}