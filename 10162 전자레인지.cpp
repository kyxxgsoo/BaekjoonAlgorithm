#include <iostream>

using namespace std;
	
#define A 300
#define B 60
#define C 10

int t;

int main()
{
	cin >> t;
	if (t % 10 != 0)
	{
		cout << -1;
		return 0;
	}

	cout << t / A << " ";
	t %= A;
	cout << t / B << " ";
	t %= B;
	cout << t / C << " ";
	
}