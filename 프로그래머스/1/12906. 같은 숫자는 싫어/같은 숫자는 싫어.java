import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i:arr){
            if(deque.isEmpty() || deque.peekLast()!=i)deque.addLast(i);
        }
        return deque.stream().mapToInt(i -> i).toArray();
    }
}