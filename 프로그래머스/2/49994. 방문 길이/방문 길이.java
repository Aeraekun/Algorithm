import java.io.*;
import java.util.*;

class Solution {
    static HashSet<Road> set = new HashSet<>();

    public int solution(String dirs) {
        int answer = 0;
        int nx=0, ny=0;

        for(int d=0; d<dirs.length(); d++){
            if(dirs.charAt(d)=='U'){
                if(ny<5){
                    Road r = new Road(nx, ny, nx, ny+1);
                    set.add(r);
                    ny++;
                }
            } else if(dirs.charAt(d)=='D'){
                if(ny>-5){
                    Road r = new Road(nx, ny, nx, ny-1);
                    set.add(r);
                    ny--;
                }
            } else if(dirs.charAt(d)=='R'){
                if(nx<5){
                    Road r = new Road(nx, ny, nx+1, ny);
                    set.add(r);
                    nx++;
                }
            } else {
                if(nx>-5){
                    Road r = new Road(nx, ny, nx-1, ny);
                    set.add(r);
                    nx--;
                }
            }
        }
        return set.size();
    }

    class Road {
        int sx, sy, ex, ey;

        Road(int sx, int sy, int ex, int ey) {
            if (sx > ex || (sx == ex && sy > ey)) {
                this.sx = ex;
                this.sy = ey;
                this.ex = sx;
                this.ey = sy;
            } else {
                this.sx = sx;
                this.sy = sy;
                this.ex = ex;
                this.ey = ey;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(sx, sy, ex, ey);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Road road = (Road) obj;
            return sx == road.sx && sy == road.sy && ex == road.ex && ey == road.ey;
        }
    }
}