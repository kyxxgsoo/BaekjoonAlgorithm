//
//  1316 그룹 단어 체커.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/06.
//

import Foundation

func isGroupWord(word: String) -> Bool {
    var checker: [Character:Int] = [:]
    var beforeChar = word[word.startIndex]
    checker[beforeChar] = 1
    for currentChar in word {
        if beforeChar != currentChar {
            if checker[currentChar] == nil {
                checker[currentChar] = 1
                beforeChar = currentChar
            } else {
                return false
            }
        }
    }
    return true
}

let N = Int(readLine()!)!
var result = 0

for _ in 0..<N {
    let word = readLine()!
    if isGroupWord(word: word) {
        result += 1
    }
}

print(result)
