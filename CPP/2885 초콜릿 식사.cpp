//
//  2885 초콜릿 식사.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/18.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

int powerOfTwo[21];

void setVariable() {
    powerOfTwo[0] = 1;
    for(int i = 1; i < 21; i++) {
        powerOfTwo[i] = powerOfTwo[i - 1] * 2;
    }
}

int main() {
    setVariable();
    int k;
    cin >> k;
    
    int index = 0;
    for(int i = 0; i < 21; i++) {
        if(k <= powerOfTwo[i]) {
            index = i;
            break;
        }
    }
    int n = 0;
    for(int i = index; i >= 0; i--) {
        if(k - powerOfTwo[i] == 0) {
            k -= powerOfTwo[i];
            n = i;
            break;
        } else if(k - powerOfTwo[i] < 0) {
            continue;
        } else if(k - powerOfTwo[i] > 0) {
            k -= powerOfTwo[i];
        }
    }
    cout << powerOfTwo[index] <<" " << index - n << "\n";
}
