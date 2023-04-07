//
//  2022 prob-W03_A.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2023/04/06.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

int t;
int n;
int d;
vector<int> v;
vector<int> period;
int cnt;

void clearVar() {
    n = 0;
    d = 0;
    cnt = 0;
    v.clear();
}

int main() {
    cin >> t;
    for(int i = 0; i < t; i++) {
        cin >> n >> d;
        int num;
        for(int j = 0; j < n; j++) {
            cin >> num;
            v.push_back(num);
        }
        for(int j = 0; j < n - d; j++) {
            int median = 0;
            vector<int> tempVector(d);
            copy(v.begin() + j, v.begin() + j + d, tempVector.begin());
            sort(tempVector.begin(), tempVector.end());
            if(d % 2 == 0) {
                median = (tempVector[(d-1)/2] + tempVector[(d-1)/2 + 1])/2;
            } else {
                median = tempVector[d/2];
            }
            if(v[j + d] >= 2 * median) {
                cnt++;
            }
        }
        cout << "result : " << cnt << "\n";
        clearVar();
    }
}
