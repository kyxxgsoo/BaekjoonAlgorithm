#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int arr[301];
int dp[301];
int n;

int main()
{
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i];
	}

	dp[1] = arr[1];
	dp[2] = dp[1] + arr[2];
	dp[3] = max(dp[1] + arr[3], arr[2] + arr[3]);

	for (int i = 4; i <= n; i++)
	{
		dp[i] = max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
	}

	cout << dp[n];
}