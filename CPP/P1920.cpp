#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

vector<long long int> a;
int n, m;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		long long int num;
		cin >> num;
		a.push_back(num);
	}
	cin >> m;

	sort(a.begin(), a.end());
	for (int i = 0; i < m; i++)
	{
		long long int num;
		cin >> num;
		if (binary_search(a.begin(), a.end(), num))
		{
			cout << "1\n";
		}
		else
		{
			cout << "0\n";
		}
		
	}
}