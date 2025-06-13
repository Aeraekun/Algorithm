class Solution {
    
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int len, int now) {
        if(len == numbers.length) {
            if(now == target) answer++;
            return;
        }
        dfs(numbers, target, len + 1, now + numbers[len]);
        dfs(numbers, target, len + 1, now - numbers[len]);
    }
}