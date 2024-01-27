s=list(input())
c=[0]*26
for a in s:
    i=ord(a)
    if 65<=i and 90>=i:
        c[i-65]+=1
    else: c[i-97]+=1
if c.count(max(c))!=1:
    print('?')
else: print(chr(65+c.index(max(c))))