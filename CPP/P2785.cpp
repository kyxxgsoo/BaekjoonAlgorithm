//
//  2785 체인.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/20.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int ans = 0;
    int n;
    vector<int> v;

    cin >> n;
    
    int num;
    for(int i = 0; i < n; i++) {
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    
    int temp = v.size();
    for(int i = 0; i < v.size(); i++) {
        if(v[i] <= temp - 1) {
            temp -= (v[i] + 1);
            ans += v[i];
        } else {
            temp -= 1;
            ans += 1;
        }
        if(temp <= 1) {
            break;
        }
    }
    
    cout << ans;
}

/*
10
1 1 1 2 2 2 2 2 2 2
 */
