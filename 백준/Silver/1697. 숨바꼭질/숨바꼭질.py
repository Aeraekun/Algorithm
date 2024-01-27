import sys
from collections import deque

def bfs(n,k):
    visited = [-1]*100001
    visited[n]=0
    queue = deque([n])
    
    while queue:
        x=queue.popleft()
        if x==k:
            return visited[x]
        for nx in (x-1,x+1,x*2):
            if 0<=nx<=100000 and visited[nx]==-1:
                visited[nx]=visited[x]+1
                queue.append(nx)

n,k=map(int,sys.stdin.readline().split())
print(bfs(n,k))