#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

struct Node {
	int x;
	int cnt;
};

int n, k;
bool visit[100001];
int arr[100001] = { 99999 };

void bfs() {
	queue<Node> q;
	q.push({ n, 0 });
	visit[n] = true;
	arr[n] = 0;

	while (!q.empty()) {
		int curX = q.front().x;
		int curCnt = q.front().cnt;
		q.pop();

		for (int i = 0; i < 3; i++) {
			int nextX = curX;
			int nextCnt = curCnt;;
			if (i == 0) {
				nextX--;
				nextCnt++;
			} else if (i == 1) {
				nextX++;
				nextCnt++;
			} else if (i == 2) {
				nextX *= 2;
			}
			if (0 <= nextX && nextX <= 100000) {
				if (!visit[nextX] || nextCnt < arr[nextX]) {
					q.push({ nextX, nextCnt });
					visit[nextX] = true;
					arr[nextX] = nextCnt;
				}
			}
		}
	}
}

int main() {
	cin >> n >> k;
	bfs();
	cout << arr[k];
}
