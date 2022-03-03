#include <iostream>
#include <vector>

using namespace std;

int n, m;
vector<int> v;

void backtracking(int cnt, int num)
{
	if (cnt == m)
	{
		for (int i = 0; i < v.size(); i++)
		{
			cout << v[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = num; i <= n; i++)
	{
		v.push_back(i);
		backtracking(cnt + 1, i);
		v.pop_back();
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 1; i <= n; i++)
	{
		v.push_back(i);
		backtracking(1, i);
		v.pop_back();
	}
}