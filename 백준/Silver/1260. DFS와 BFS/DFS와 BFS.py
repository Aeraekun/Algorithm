from collections import deque
import sys

def dfs(vertex, n, v, visited):
    if v in visited: return
    if v not in visited:
        visited.append(v)
    for i in vertex:
        if v==i[0] and i[1] not in visited:
            dfs(vertex, n, i[1], visited)
        if v==i[1] and i[0] not in visited:
            dfs(vertex, n, i[0], visited)
    return visited

def bfs(vertex, n, v):
    visited=[]
    queue=deque([v])

    while queue and len(visited)!=n:
        node = queue.popleft()
        if node not in visited:
            visited.append(node)
            for i in vertex:
                if node==i[0] and i[1] not in visited:
                    queue.append(i[1])
                if node==i[1] and i[0] not in visited:
                    queue.append(i[0])
    return visited

n,m,v=map(int,sys.stdin.readline().split())
vertex=[]
for _ in range(m):
    a,b=map(int,sys.stdin.readline().split())
    vertex.append([min(a,b),max(a,b)])
vertex.sort(key=lambda x:(x[1],x[0]))
print(*dfs(vertex, n, v, []))
print(*bfs(vertex, n, v))