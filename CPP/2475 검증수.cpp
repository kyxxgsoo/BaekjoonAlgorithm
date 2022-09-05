#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int arr[5];

int main()
{
	int sum = 0;
	for (int i = 0; i < 5; i++)
	{
		cin >> arr[i];
		sum += pow(arr[i], 2);
	}

	cout << sum % 10;
}