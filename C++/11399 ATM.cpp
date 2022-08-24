#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int n;
int arr[1001];

int main() {
	vector<int> v;
	int ans = 0;
	cin >> n;
	for(int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	arr[0] = v[0];
	ans = v[0];
	for (int i = 1; i < n; i++) {
		ans += v[i] + arr[i - 1];
		arr[i] += v[i] + arr[i - 1];
	}
	cout << ans;
}
