//
//  11501 주식.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/21.
//

#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

int t;
int n;
int cnt;
long long ans;
long long total;
vector<int> v;
stack<int> s;

void clearVariable() {
    n = 0;
    cnt = 0;
    ans = 0;
    total = 0;
    v.clear();
    while(!s.empty()) {
        s.pop();
    }
}

int main() {
    cin >> t;
    for(int i = 0; i < t; i++) {
        clearVariable();
        cin >> n;
        int num;
        for(int j = 0; j < n; j++) {
            cin >> num;
            v.push_back(num);
        }
        
        reverse(v.begin(), v.end());
        
        int max = v[0];
        int maxIndex = v.size() - 1;
        
        for(int j = 0; j < v.size(); j++) {
            if(max <= v[j]) {
                max = v[j];
                s.push(v.size() - j - 1);
            }
        }
        
        reverse(v.begin(), v.end());
        
        for(int j = 0; j < v.size(); j++) {
            if(s.empty()) {
                break;
            }
            if(j < s.top()) {
                cnt++;
                total -= v[j];
            } else if (j == s.top()) {
                total += v[j] * cnt;
                cnt = 0;
                s.pop();
            }
        }
        
        cout << total << "\n";
    }
}

/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
 */
