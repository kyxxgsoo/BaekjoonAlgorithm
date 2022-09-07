//
//  10953 A+B - 6.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/07.
//

#include <iostream>
#include <string>

using namespace std;

int main() {
    int t;
    cin >> t;
    int A, B;
    char c;

    for(int i = 0; i < t; i++) {
        cin >> A >> c >> B;
        cout << A + B << "\n";
    }
}
