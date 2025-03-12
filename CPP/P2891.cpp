//
//  2891 카약과 강풍.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/15.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>

using namespace std;

int n, s, r;
bool kayak[12];
bool rest[12];
int ans;

void setVariable() {
    memset(kayak, true, sizeof(kayak));
    memset(rest, false, sizeof(rest));
    ans = 0;
}

int main() {
    setVariable();
    cin >> n >> s >> r;
    int aTeamWithoutKayak;
    for(int i = 0; i < s; i++) {
        cin >> aTeamWithoutKayak;
        kayak[aTeamWithoutKayak] = false;
    }
    int aTeamWithRestKayak;
    for(int i = 0; i < r; i++) {
        cin >>aTeamWithRestKayak;
        rest[aTeamWithRestKayak] = true;
    }
    for(int i = 1; i <= n; i++) {
        if(!kayak[i] && rest[i]) {
            kayak[i] = true;
            rest[i] = false;
        }
    }
    
    for(int i = 1; i <= n; i++) {
        if(rest[i]) {
            if(!kayak[i - 1]) {
                kayak[i - 1] = true;
                rest[i] = false;
            } else if(!kayak[i + 1]) {
                kayak[i + 1] = true;
                rest[i] = false;
            }
        }
    }
    
    for(int i = 1; i <= n; i++) {
        if(!kayak[i]) {
            ans++;
        }
    }
    
    cout << ans << "\n";
}

/*
9 5 2
1 3 7 8 9
5 9

5 3 3
2 3 4
1 2 3
 */
