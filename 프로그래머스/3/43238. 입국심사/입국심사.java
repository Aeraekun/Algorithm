import java.io.*;
import java.util.*;

class Solution {

    public long solution(int n, int[] times) {
        int max =0;
        for(int i:times){
            max = Math.max(max,i);
        }
        long left = 0;
        long right = (long) max * n;
        long ans = right;
        while(left<=right) {
            long mid = (left + right) / 2;
            long temp = 0;
            for(int i:times){
                temp+=(mid/i);
            }
            if(temp<n){
                left=mid+1;
            }else{
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }

}