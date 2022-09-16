//
//  20044 Project Teams.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/16.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    vector<int> v;
    vector<int> ans;
    cin >> n;
    
    int w;
    for(int i = 0; i < 2 * n; i++) {
        cin >> w;
        v.push_back(w);
    }
    sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++) {
        ans.push_back(v[i] + v[v.size() - i - 1]);
    }
    
    cout << *min_element(ans.begin(), ans.end());
}
