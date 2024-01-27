def solution(n,m):
    ans=[1] * (m-n+1)
    for k in range(2,int(m**0.5)+1):
        s=k*k
        i = 0 if n%s==0 else s-(n%s)
        for j in range(i,len(ans),s):
            ans[j]=0
    return sum(ans)

n,m=map(int,input().split())
print(solution(n,m))