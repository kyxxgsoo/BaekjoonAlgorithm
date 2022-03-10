#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct schedule
{
	int start;
	int end;
};

bool cmp(schedule a, schedule b)
{
	if (a.end == b.end)
	{
		return a.start < b.start;
	}
	return a.end < b.end;
}

int n;
vector<schedule> v;
int cnt = 1;

int main()
{
	cin >> n;

	int start, end;
	
	for (int i = 0; i < n; i++)
	{
		cin >> start >> end;
		v.push_back({ start, end });
	}
	sort(v.begin(), v.end(), cmp);

	int curEnd = v[0].end;
	for (int i = 1; i < n; i++)
	{
		if (curEnd <= v[i].start && curEnd <= v[i].end)
		{
			cnt++;
			curEnd = v[i].end;
		}
	}

	cout << cnt;
}