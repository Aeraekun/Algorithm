def check(num, broken):
    for n in str(num):
        if n in broken:
            return False
    return True

N = int(input())
M = int(input())
broken = set(input().split()) if M else set()

min_clicks = abs(N - 100)

for i in range(1000000):
    if check(i, broken):
        clicks = len(str(i)) + abs(i - N)
        min_clicks = min(min_clicks, clicks)
        
print(min_clicks)