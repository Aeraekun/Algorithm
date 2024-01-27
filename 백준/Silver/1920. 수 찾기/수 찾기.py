n=int(input())
nx=set(map(int,input().split()))
m=int(input())
mx=list(map(int,input().split()))
for i in mx:
    if i in nx: print(1)
    else: print(0)