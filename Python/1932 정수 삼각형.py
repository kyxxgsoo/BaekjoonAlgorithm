import sys

# main
a = [[0] * 501 for _ in range(501)]
dp = [[0] * 501 for _ in range(501)]
n = int(sys.stdin.readline())

for i in range(n):
    a[i] = list(map(int, sys.stdin.readline().split()))

dp[0][0] = a[0][0]

for i in range(n):
    for j in range(i + 1):
        # # j가 0인 경우 j-1은 -1을 접근하게 되기 때문에 에러가 안나는데... 나중에 문제가 발생할 여지가 있음.
        # if j == 0:
        #     dp[i][j] = dp[i - 1][0] + a[i][j]
        # else:
        #     dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + a[i][j]
        dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + a[i][j]

ans = 0
for i in range(n):
    ans = max(ans, dp[n - 1][i])

print(ans)