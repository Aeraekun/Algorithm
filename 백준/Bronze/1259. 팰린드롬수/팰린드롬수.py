while True:
    temp=True
    a=input()
    if a=='0': break
    for i in range(len(a)//2):
        if a[i]!=a[-i-1]:
            print("no")
            temp=False
            break
    if temp==True: print("yes")
