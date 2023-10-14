//
//  2675 문자열 반복.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/04.
//

import Foundation

let T = Int(readLine()!)!
for _ in 0..<T {
    let input = readLine()!.split(separator: " ")
    let R = Int(input[0])!
    let S = input[1]
    for s in S {
        for _ in 0..<R {
            print(s, terminator: "")
        }
    }
    print("")
}
