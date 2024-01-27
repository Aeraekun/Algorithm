# 집의 수 N 입력 받기
N = int(input())

# 비용을 저장할 리스트 초기화
costs = []

# 각 집을 빨강, 초록, 파랑으로 칠하는 비용 입력 받기
for _ in range(N):
    costs.append(list(map(int, input().split())))

# 각 색으로 칠하는 비용의 최솟값을 저장할 DP 테이블 초기화
dp = [[0] * 3 for _ in range(N)]
dp[0] = costs[0]

# 두 번째 집부터 N번 집까지 최소 비용 계산
for i in range(1, N):
    # 이전 집을 다른 색으로 칠했을 때의 최소 비용을 더해줌
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]  # 빨강색으로 칠할 경우
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1]  # 초록색으로 칠할 경우
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2]  # 파랑색으로 칠할 경우

# 모든 집을 칠하는 비용의 최솟값 출력
print(min(dp[N-1]))