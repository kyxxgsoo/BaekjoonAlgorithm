//
//  2443 별 찍기 - 6.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/09.
//

#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < i; j++) {
            cout << " ";
        }
        for(int j = 0; j < 2 * (n - i) - 1; j++) {
            cout << "*";
        }
        cout << "\n";
    }
}
