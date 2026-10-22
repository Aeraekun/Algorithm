import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] dist;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    
    public int solution(int[][] maps) {
        int x = maps.length;
        int y = maps[0].length;
        dist = new int[x][y];
        bfs(0,0,maps);
        return dist[x-1][y-1]!=0?dist[x-1][y-1]:-1;
    }
    
    private void bfs(int x, int y, int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        dist[0][0]=1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            
            if(nx==maps.length-1&&ny==maps[0].length-1) return;
            for(int d=0;d<4;d++){
                if(nx+dx[d]<0||nx+dx[d]>=maps.length||ny+dy[d]<0||ny+dy[d]>=maps[0].length) continue;
                if(maps[nx+dx[d]][ny+dy[d]]==0||dist[nx+dx[d]][ny+dy[d]]!=0) continue;
                dist[nx+dx[d]][ny+dy[d]]=dist[nx][ny]+1;
                q.offer(new int[]{nx+dx[d],ny+dy[d]});
            }
        }
        return;
    }
}