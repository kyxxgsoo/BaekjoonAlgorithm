#include <iostream>
#include <cmath>

using namespace std;

int a[501][501];
int dp[501][501];
int n;

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			cin >> a[i][j];
		}
	}

	dp[0][0] = a[0][0];

	for (int i = 1; i < n; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + a[i][j];
		}
	}

	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		if (ans < dp[n - 1][i])
		{
			ans = dp[n - 1][i];
		}
	}
	cout << ans;
}