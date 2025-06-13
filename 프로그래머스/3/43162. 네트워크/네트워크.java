import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++) if(!visited[i]) {
            answer++;
            dfs(i, n, computers);
        }
        return answer;
    }
    
    private void dfs(int d, int n, int[][] computers) {
        visited[d]=true;
        for(int i=0;i<n;i++) if((computers[d][i]==1) && (!visited[i])) dfs(i, n, computers);
    }
}