n,m=map(int,input().split())
answer=[]
ans=0
a = set([input().strip() for _ in range(n)])
for i in [input().strip() for _ in range(m)]:
    if i in a:
        ans+=1
        a.remove(i)
        answer.append(i)
        if ans==n:break
answer.sort()
print(ans)
for i in range(ans):
    print(answer[i])