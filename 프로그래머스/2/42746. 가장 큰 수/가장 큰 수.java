import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++)
            arr[i]=numbers[i]+"";
        Arrays.sort(arr, (x,y)->(y+x).compareTo(x+y));
        if(arr[0].equals("0")) return "0";
        for(String s:arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}