n,m=map(int,input().split())
true=list(map(int,input().split()))
if len(true)==1:
    true=[]
else: 
    del true[0]
true=set(true)
party=[]
temp=[]
for i in range(m):
    temp=list(map(int,input().split()))
    del temp[0]
    party.append(set(temp))
while True:
    count=0
    for i in party[:]:
        if len(i & true) != 0 :
            count+=1
            true=i|true
            party.remove(i)
    if count==0:
        break
print(len(party))