//
//  1000 A+B.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/08/25.
//

import Foundation

let input = readLine()

if let input = input {
    let array = input.components(separatedBy: " ")
    let sol = Int(array[0])! + Int(array[1])!
    print(sol)
}
