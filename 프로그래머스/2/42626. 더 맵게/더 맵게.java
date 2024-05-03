import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville)
            queue.add(i);
        while(true) {
            if(queue.size() == 1){
                if(queue.poll() < K)
                    ans =- 1;
                break;
            }
            int i = queue.poll();
            int j = queue.poll();
            if(i >= K) break;
            queue.add(i + 2 * j);
            ans++;
        }
        return ans;
    }
}