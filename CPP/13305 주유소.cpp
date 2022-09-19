//
//  13305 주유소.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/19.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef pair<int, unsigned long long> iull;

int n;
unsigned long long dist[100001], pricePerLiter[100001];
vector<iull> v;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i < n - 1; i++) {
        cin >> dist[i];
    }
    
    for(int i = 0; i < n; i++) {
        cin >> pricePerLiter[i];
    }
    
    unsigned long long min = pricePerLiter[0];
    unsigned long long currentTotalDist = dist[0];
    
    
    for(int i = 1; i < n; i++) {
        if(min >= pricePerLiter[i] || i == n -1 ) {
//            cout << "min : " << min << "\ncurrentTotalDist : " << currentTotalDist << "\n";
            v.push_back({min, currentTotalDist});
            min = pricePerLiter[i];
            currentTotalDist = dist[i];
            continue;
        }
        currentTotalDist += dist[i];
    }
    
    unsigned long long sum = 0;
    for(int i = 0; i < v.size(); i++) {
        sum += v[i].first * v[i].second;
    }
    
    cout << sum;
    
}

/*
4
2 3 1
5 2 4 1
 */
