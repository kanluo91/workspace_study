//
//  泛型.swift
//  SwiftDemos
//
//  Created by luokan on 2024/7/20.
//

import Foundation

/** 为什么需要泛型，看下面2个函数
    如果没有泛型，每一种数据类型都需要定义一个函数
 */

func swapTwoString(a: inout String, b: inout String){
    let tmp = a
    a = b
    b = tmp
}

func swapTwoInt(a: inout Int, b: inout Int){
    let tmp = a
    a = b
    b = tmp
}

/**
  如果有泛型的话，间下面
 */

func swapTwoValues<T>(a: inout T, b: inout T){
    let tmp = a
    a = b
    b = tmp
}


func 泛型_test1(){
    var a = 10 , b = 20
    swapTwoValues(a: &a, b: &b)
    print("a = \(a) b = \(b)")
}
