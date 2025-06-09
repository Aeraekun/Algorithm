def solution(arr, query):
    start = 0
    end = len(arr) - 1
    for i, a in enumerate(query):
        if i % 2 == 0:
            end = start + a
        else:
            start += a
    return arr[start:end+1]