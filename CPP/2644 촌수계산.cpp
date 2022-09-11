//
//  2644 촌수계산.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/12.
//

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool visited[101] = {false};
int relationship[101] = {0};
vector<vector<int>> v;
int n, m;
int a, b;


void bfs() {
    queue<int> q;
    q.push(a);
    visited[a] = true;
    
    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        if(cur == b) {
            cout << relationship[cur] << "\n";
            return;
        }
        for(int i = 0; i < v[cur].size(); i++) {
            if(!visited[v[cur][i]]) {
                q.push(v[cur][i]);
                visited[v[cur][i]] = true;
                relationship[v[cur][i]] = relationship[cur] + 1;
            }
        }
    }
    cout << -1 << "\n";
    return;
}

int main() {
    cin >> n;
    cin >> a >> b;
    cin >> m;
    
    v.resize(n + 1);
    
    int x, y;
    for(int i = 0; i < m; i++) {
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }
    bfs();
}
