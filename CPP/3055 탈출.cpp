#include <iostream>
#include <queue>
#include <vector>
#include <cmath>
#include <algorithm>
#include <string>

using namespace std;

struct Node
{
	int y;
	int x;
	char matter;
	int cnt;
};

int r, c;
char forest[51][51];
bool visit[51][51];

vector<Node> water;
Node d;
Node s;

int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };


void bfs()
{
	queue<Node> q;

	for (int i = 0; i < water.size(); i++)
	{
		q.push(water[i]);
		visit[water[i].y][water[i].x] = true;
	}
	q.push(s);
	visit[s.y][s.x] = true;

	while (!q.empty())
	{
		int curY = q.front().y;
		int curX = q.front().x;
		int curCnt = q.front().cnt;
		char curMatter = q.front().matter;
		q.pop();



		for (int i = 0; i < 4; i++)
		{
			int nextY = curY + dy[i];
			int nextX = curX + dx[i];

			if (nextY == d.y && nextX == d.x && curMatter == 'S')
			{
				cout << curCnt + 1;
				return;
			}
			if (0 <= nextY && nextY < r && 0 <= nextX && nextX < c)
			{
				if (!visit[nextY][nextX] && forest[nextY][nextX] == '.')
				{
					q.push({ nextY, nextX, curMatter, curCnt + 1 });
					visit[nextY][nextX] = true;
					forest[nextY][nextX] = curMatter;
				}
			}
		}
	}
	cout << "KAKTUS";
	return;


}

int main()
{
	cin >> r >> c;

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			cin >> forest[i][j];
		}
	}

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			if (forest[i][j] == '*')
			{
				water.push_back({ i, j, '*' });
			}
			
			if (forest[i][j] == 'S')
			{
				s.y = i;
				s.x = j;
				s.matter = 'S';
			}

			if (forest[i][j] == 'D')
			{
				d.y = i;
				d.x = j;
				d.matter = 'D';
			}
		}
	}
	bfs();
}