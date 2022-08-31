//
//  2753 윤년.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/01.
//

import Foundation

let input = Int(readLine()!)

if let input = input {
    if input % 4 == 0 && (input % 100 != 0 || input % 400 == 0) {
        print("1")
    } else {
        print("0")
    }
}
