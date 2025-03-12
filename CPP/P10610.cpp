//
//  10610 30.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/10.
//

/*
 배수 판정법
 https://ko.wikipedia.org/wiki/%EB%B0%B0%EC%88%98_%ED%8C%90%EC%A0%95%EB%B2%95
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string n;
bool flag = false;

int main() {
    cin >> n;
    int sum = 0;
    for(int i = 0; i < n.size(); i++) {
        sum += n[i] - '0';
        if(n[i] == '0') {
            flag = true;
        }
    }
    if(sum % 3 != 0 || !flag) {
        cout << -1;
        return 0;
    } else {
        sort(n.begin(), n.end());
        reverse(n.begin(), n.end());
    }
    cout << n;
}

