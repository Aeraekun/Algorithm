import java.io.*;
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] exRocks = new int[rocks.length + 2];
        for(int i=0;i<rocks.length;i++){
            exRocks[i+1] = rocks[i];
        }
        exRocks[0]=0;
        exRocks[exRocks.length-1]=distance;
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left<=right){
            int mid = (left+right)/2;
            int removedRock = 0;
            int lastPosition = 0;
            for(int i=1;i<exRocks.length;i++){
                if(exRocks[i]-lastPosition < mid) removedRock++;
                else lastPosition = exRocks[i];
            }
            if(removedRock>n){
                right = mid-1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}