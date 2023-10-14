//
//  11720 숫자의 합.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/01.
//

import Foundation

let n = Int(readLine()!)!
let m = readLine()!
var sum: Int = 0

for i in m {
    sum += Int(String(i))!
}
print(sum)
