//
//  1550 16진수.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/08.
//

#include <iostream>
#include <string>

using namespace std;

int main() {
    string input;
    long long result = 0;
    long long weightedValue = 1;
    
    cin >> input;
    for(int i = input.size() - 1; i >= 0; i--) {
        if('0' <= input[i] && input[i] <= '9') {
            result += (input[i] - '0') * weightedValue;
        } else {
            int temp = 0;
            switch (input[i]) {
                case 'A':
                    temp = 10;
                    break;
                case 'B':
                    temp = 11;
                    break;
                case 'C':
                    temp = 12;
                    break;
                case 'D':
                    temp = 13;
                    break;
                case 'E':
                    temp = 14;
                    break;
                case 'F':
                    temp = 15;
                    break;
            }
            result += temp * weightedValue;
        }
        weightedValue *= 16;
    }
    cout << result << "\n";
}
