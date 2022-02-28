#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int dp[1001][3];
int rgb[1001][3];

int main()
{
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> rgb[i][0] >> rgb[i][1] >> rgb[i][2];
	}

	for (int i = 0; i < 3; i++)
	{
		dp[0][i] = rgb[0][i];
	}

	for (int i = 1; i < n; i++)
	{
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
	}

	cout << min(min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

}