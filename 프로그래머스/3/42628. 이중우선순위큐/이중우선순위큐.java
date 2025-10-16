import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        for(String o: operations){
            StringTokenizer st = new StringTokenizer(o);
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(operation.equals("I")){
                minQueue.offer(num);
                maxQueue.offer(num);
            } else{
                if(!minQueue.isEmpty()){
                    ArrayDeque<Integer> deque = new ArrayDeque<>();
                    if(num == 1){
                        maxQueue.poll();
                        while(!maxQueue.isEmpty()){
                            deque.offer(maxQueue.poll());
                        }  
                    }else{
                        minQueue.poll();
                        while(!minQueue.isEmpty()){
                            deque.offer(minQueue.poll());
                        }
                    }
                    minQueue.clear();
                    maxQueue.clear();
                    while(!deque.isEmpty()){
                        minQueue.offer(deque.peek());
                        maxQueue.offer(deque.peek());
                        deque.poll();
                    }
                }
            }
        }
        if(!minQueue.isEmpty()){
            answer[0]=maxQueue.poll();
            answer[1]=minQueue.poll();
        }
        return answer;
    }
}