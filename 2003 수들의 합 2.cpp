#include <iostream>
#include <vector>

using namespace std;

int n, m;
int a[10001];

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    int sum = 0;
    int start = 0;
    int end = 0;
    int cnt = 0;

    while (end <= n)
    {
        if (sum < m)
        {
            sum += a[end];
            end++;
        }
        else if (sum >= m)
        {
            sum -= a[start];
            start++;
        }

        if (sum == m)
        {
            cnt++;
        }
    }

    cout << cnt;
}