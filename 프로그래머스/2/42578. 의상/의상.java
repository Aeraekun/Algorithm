import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        for(String[] c  : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        for(int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}