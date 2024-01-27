from collections import deque

n = int(input())
deque = deque([i for i in range(1, n+1)])

while (len(deque)>1):
    deque.popleft()
    num = deque.popleft()
    deque.append(num)
print(deque[0])