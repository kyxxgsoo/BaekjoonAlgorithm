//
//  9498 시험 성적.swift
//  Swift
//
//  Created by Kyungsoo Lee on 2022/09/06.
//

import Foundation

let grade = Int(readLine()!)!

if grade >= 90 {
    print("A")
} else if grade >= 80 {
    print("B")
} else if grade >= 70 {
    print("C")
} else if grade >= 60 {
    print("D")
} else {
    print("F")
}
