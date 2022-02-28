#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int dp[5001] = { 9999, 9999, 9999, 1, 9999, 1 };

int main()
{
	int n;
	cin >> n;

	for (int i = 6; i <= n; i++)
	{
		dp[i] = min(dp[i - 3], dp[i - 5]) + 1;
	}

	if (dp[n] < 9999)
	{
		cout << dp[n];
	}
	else
	{
		cout << -1;
	}
}