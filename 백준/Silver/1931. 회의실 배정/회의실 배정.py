import sys
count=0
end=0
meeting=[]
for i in range(int(sys.stdin.readline())):
    meeting.append(list(map(int,sys.stdin.readline().split())))
meeting.sort(key=lambda x:(x[1],x[0]))
for i in meeting:
    if i[0]>=end:
        count+=1
        end=i[1]
print(count)