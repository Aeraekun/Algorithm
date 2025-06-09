def solution(lines):
    count = [0] * 201
    for s, e in lines:
        for i in range(s, e):
            count[i + 100] += 1
    return sum(1 for c in count if c >= 2)