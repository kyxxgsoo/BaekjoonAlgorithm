//
//  2022 prob-W01_A.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2023/04/06.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

int t;
int n, m;
vector<int> inha;
vector<int> biryong;

void clearVar() {
    n = 0;
    m = 0;
    inha.clear();
    biryong.clear();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    for(int i = 0; i < t; i++) {
        cin >> n >> m;
        for(int j = 0; j < n; j++) {
            int num;
            cin >> num;
            inha.push_back(num);
        }
        for(int j = 0; j < m; j++) {
            int num;
            cin >> num;
            biryong.push_back(num);
        }
        
        int inha_gcd = inha[0];
        for(int j = 0; j < inha.size(); j++) {
            inha_gcd = gcd(inha_gcd, inha[j]);
        }
        int biryong_gcd = biryong[0];
        for(int j = 0; j < biryong.size(); j++) {
            biryong_gcd = gcd(biryong_gcd, biryong[j]);
        }
        
        for(int j = 0; j < inha.size(); j++) {
            if(inha[j] % biryong_gcd == 0) {
                biryong_gcd = -1;
                break;
            }
        }
        for(int j = 0; j < biryong.size(); j++) {
            if(biryong[j] % inha_gcd == 0) {
                inha_gcd = -1;
                break;
            }
        }
        cout << biryong_gcd << " " << inha_gcd << "\n";
        clearVar();
    }
    
}
