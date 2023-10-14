//
//  8958 OX퀴즈.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/06.
//

import Foundation

let t = Int(readLine()!)!

for _ in 0..<t {
    let input = readLine()!
    var result = 0
    var count = 0
    for quiz in input {
        if quiz == "O" {
            count += 1
            result += count
        } else {
            count = 0
        }
    }
    print(result)
}
