class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int index, int now) {
        if(index == numbers.length) {
            if(now == target) answer++;
            return;
        }
        dfs(numbers, target, index + 1, now + numbers[index]);
        dfs(numbers, target, index + 1, now - numbers[index]);
    }
}