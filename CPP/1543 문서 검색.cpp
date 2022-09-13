//
//  1543 문서 검색.cpp
//  Cpp
//
//  Created by Kyungsoo Lee on 2022/09/14.
//

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    string text;
    string word;
    int count = 0;
    getline(cin, text);
    getline(cin, word);
    
    for(int i = 0; i < text.size(); i++) {
        for(int j = 0; j < word.size(); j++) {
            if(text[i + j] == word[j]) {
                if(j == word.size() - 1) {
                    count++;
                    i += j;
                }
                continue;
            } else {
                break;
            }
        }
    }
    cout << count << "\n";
}
