//
//  10828 스택.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2023/04/06.
//

#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <stack>
#include <cmath>

using namespace std;

int n;
string cmd;
stack<int> s;

int main() {
    cin >> n;
    
    for(int i = 0; i < n; i++) {
        cin >> cmd;
        if(cmd == "push") {
            int num;
            cin >> num;
            s.push(num);
        } else if(cmd == "top") {
            if(s.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << s.top() << "\n";
        } else if(cmd == "size") {
            cout << s.size() << "\n";
        } else if(cmd == "empty") {
            cout << s.empty() << "\n";
        } else if(cmd == "pop") {
            if(s.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << s.top() << "\n";
            s.pop();
        }
    }
}
