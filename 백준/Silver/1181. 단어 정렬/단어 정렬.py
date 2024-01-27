arr=set()
for i in range(int(input())):
    arr.add(input())
l=list(arr)
l.sort()
l.sort(key=len)
for i in l:
    print(i)