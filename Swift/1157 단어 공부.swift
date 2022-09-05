//
//  1157 단어 공부.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/06.
//

import Foundation

let input = readLine()!.uppercased()
var dictonary: [Character:Int] = [:]
var result: [Character] = []

for i in input {
    if dictonary[i] == nil {
        dictonary[i] = 1
    } else {
        dictonary[i]! += 1
    }
}

for key in dictonary.keys {
    if dictonary[key] == dictonary.values.max() {
        result.append(key)
    }
}

result.count == 1 ? print(result[result.startIndex]) : print("?")
