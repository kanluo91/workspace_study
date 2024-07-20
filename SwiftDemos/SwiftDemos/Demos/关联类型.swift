//
//  关联类型.swift
//  SwiftDemos
//
//  Created by luokan on 2024/7/20.
//

import Foundation

/**
 关联类型 和 泛型  的区别
 1. 协议中不能写泛型，只可以写关联类型
 
 */

protocol ContainerProtocol{
    
    associatedtype ItemType
    
    mutating func append(item: ItemType)
    
    var count: Int {get}
    
    subscript(i: Int) -> ItemType {get}
    
}


struct InStack: ContainerProtocol{

    var datas: [Int] = []
    typealias ItemType = Int
    
    var count: Int {
        return datas.count
    }
    
    mutating func append(item: Int) {
        datas.append(item)
    }
    
    subscript(i: Int) -> Int {
        return datas[i]
    }
}
