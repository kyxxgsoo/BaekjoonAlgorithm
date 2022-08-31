//
//  2739 구구단.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/01.
//
import Foundation

let n = Int(readLine()!)
if let n = n {
    for i in 1 ... 9 {
        print("\(n) * \(i) = \(n * i)")
    }
}
