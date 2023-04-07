//
//  2022 prob-W02_A.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2023/04/06.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int t;
int n, m;
vector<string> alphabet;
vector<string> file;

void clearVar() {
    n = 0;
    m = 0;
    alphabet.clear();
    file.clear();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    for(int i = 0; i < t; i++) {
        cin >> n >> m;
        string bit;
        for(int j = 0; j < n; j++) {
            cin >> bit;
            alphabet.push_back(bit);
        }
        int l;
        string f;
        cin >> l >> f;
        for(int j = 0; j < l/m; j++) {
            file.push_back(f.substr(j*m, m));
        }
        
        for(int j = 0; j < file.size(); j++) {
            char result = 'A';
            int max = 0;
            for(int k = 0; k < alphabet.size(); k++) {
                int same = 0;
                for(int l = 0; l < alphabet[k].size(); l++) {
                    if(file[j][l] == alphabet[k][l]) {
                        same++;
                        if(same > max) {
                            max = same;
                            result = 'A' + k;
                        }
                    }
                }
            }
            cout << result;
        }
        cout << "\n";
        clearVar();
    }
}
