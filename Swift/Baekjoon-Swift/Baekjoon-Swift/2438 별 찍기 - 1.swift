//
//  2438 별 찍기 - 1.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/01.
//

import Foundation

let n = Int(readLine()!)

if let n = n {
    for i in 1 ... n {
        for j in 1 ... i {
            print("*", terminator: "")
        }
        print("")
    }
}
