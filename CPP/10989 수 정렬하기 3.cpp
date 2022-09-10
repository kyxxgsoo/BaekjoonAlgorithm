//
//  10989 수 정렬하기 3.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/11.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int arr[10001] = { 0 };

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    

    int n;
    cin >> n;
    
    int temp;
    for(int i = 0; i < n; i++) {
        cin >> temp;
        arr[temp]++;
    }
    for(int i = 0; i < 10001; i++) {
        for(int j = 0; j < arr[i]; j++) {
            cout << i << "\n";
        }
    }
}
