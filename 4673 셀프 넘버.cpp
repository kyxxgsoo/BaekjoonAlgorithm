#include <iostream>
#include <string>

using namespace std;

int a[10001];
bool check[10001];

void checkSelfNum(int n)
{
	for (int i = n; i <= 10000; i++)
	{
		int num = i;
		string str = to_string(num);
		for (int j = 0; j < str.size(); j++)
		{
			num += str[j] - '0';
		}
		check[num] = true;
	}
}

int main()
{
	checkSelfNum(1);

	for (int i = 1; i <= 10000; i++)
	{
		if (!check[i])
		{
			cout << i << "\n";
		}
	}
}