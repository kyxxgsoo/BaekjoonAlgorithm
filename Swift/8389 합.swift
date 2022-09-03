//
//  8389 합.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/03.
//

import Foundation

let n = Int(readLine()!)!
var sum: Int = 0

for i in 1 ... n {
    sum += Int(String(i))!
}
print(sum)
