//
//  1459 걷기.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/13.
//

#include <iostream>

using namespace std;

int main() {
    long long int x, y;
    long long int w, s;   // w : 직선, s : 대각선
    cin >> x >> y >> w >> s;
    
    long long int case1 = (x + y) * w;
    long long int case2 = min(x, y) * s;
    case2 += min(abs(x - y) * w, abs(x - y) % 2 == 0 ? abs(x - y) * s : (abs(x - y) - 1) * s + w);
    
    cout << min(case1, case2) << "\n";
    return 0;
}
