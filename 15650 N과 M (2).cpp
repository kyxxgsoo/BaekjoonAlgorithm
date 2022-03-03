#include <iostream>
#include <vector>

using namespace std;

vector<int> v;
int n, m;
bool visit[9];

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
		if(!visit[i])
		{
			v.push_back(i);
			visit[i] = true;
			backtracking(cnt + 1, i);
			v.pop_back();
			visit[i] = false;
		}
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 1; i <= n; i++)
	{
		v.push_back(i);
		visit[i] = true;
		backtracking(1, i);
		v.pop_back();
		visit[i] = false;
	}
}