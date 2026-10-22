class Solution {
    boolean solution(String s) {
        int now =0;
        for(char c:s.toCharArray()){
            if(c=='(') now++;
            else {
                if(now==0) return false;
                now--;
            }
        }
        return now==0;
    }
}