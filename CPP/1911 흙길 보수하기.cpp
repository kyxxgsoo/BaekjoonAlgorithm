//
//  1911 흙길 보수하기.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/22.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

typedef pair<int, int> pii;

int n;
int ans;
int l;
vector<pii> water;

int main() {
    cin >> n >> l;
    
    int start, end;
    for(int i = 0; i < n; i++) {
        cin >> start >> end;
        water.push_back({start, end});
    }
    
    sort(water.begin(), water.end());
    
    int tempIndex = 0;
    
    for(int i = 0; i < water.size(); i++) {
        if(water[i].second <= tempIndex) {
            continue;
        }
        
        tempIndex = max(tempIndex, water[i].first);
        int cnt = (water[i].second - (tempIndex + 1)) / l + 1;
        ans += cnt;
        tempIndex += l * cnt;
    }
    
    cout << ans;
}
