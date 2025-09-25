def solution(numbers, target):
    answer = 0
    def dfs(temp,index):
        if index==len(numbers):
            if temp==target:
                return 1
            else: return 0
        return dfs(temp+numbers[index], index+1)+dfs(temp-numbers[index], index+1)
    return dfs(0,0)