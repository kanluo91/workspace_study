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


/**
 定义一个泛型的栈
 */

struct Stack<T>{
    var datas: [T] = []
    
    var count: Int{
        datas.count
    }
    
    var isEmpty: Bool{
        datas.isEmpty
    }
    
    mutating func push(item: T){
        datas.append(item)
    }
    
    mutating func pop() -> T{
        return datas.removeLast()
    }
}


extension Stack{
    var topItem: T?{
        if self.isEmpty {
            return nil
        }else{
            return datas.last
        }
    }
}


/** 找到第一个出现的目标数据
    因为判断相等  value == targetValue   所以泛型要遵从Equatable 协议
 */
func findFirstAppear<T: Equatable>(targetValue: T, from datas: [T]) -> Int?{
    for (index,value) in datas.enumerated(){
        if value == targetValue{
            return index
        }
    }
    return nil
}

protocol XieYi{
    associatedtype ItemType
    var name: ItemType{get}
}


/// 给泛型定义要求  where
/// - Parameters:
///   - params1: 泛型T1 参数1
///   - params2: 泛型T2 参数2
/// - Returns: true / false
/// 泛型要求： T1.ItemType = T2.ItemType  T1.ItemType 遵守 Equatable 协议
func generLimited<T1: XieYi, T2: XieYi>(params1: T1, params2: T2) -> Bool where T1.ItemType == T2.ItemType , T1.ItemType: Equatable{
    
    return true
}
