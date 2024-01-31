n=int(input())
nx=set(map(int,input().split()))
ans=0
for i in nx:
    if i==1: continue
    for j in range(2,i//2+1):
        if(i%j==0):
            break
    else: ans+=1
print(ans)