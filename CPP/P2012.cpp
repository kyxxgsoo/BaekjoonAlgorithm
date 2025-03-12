//
//  2012 등수 매기기.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/17.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


vector<int> v;

int main() {
    int n;
    long long ans = 0;
    cin >> n;
    
    int rank;
    for(int i = 0; i < n; i++) {
        cin >> rank;
        v.push_back(rank);
    }
    sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++) {
        ans += abs(v[i] - (i + 1));
    }
    
    cout << ans;
}
