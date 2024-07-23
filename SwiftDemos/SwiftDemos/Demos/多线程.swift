//
//  多线程.swift
//  SwiftDemos
//
//  Created by luokan on 2024/7/20.
//

import Foundation


class MyOperation: Operation{
    override func main() {
        print("do work")
    }
}


class ThreadObject{
    
    
    var age: Int = 0
    /// thread
    func test1(){
        Thread.detachNewThreadSelector(#selector(threadAction), toTarget: self, with: nil)
    }
    
    // block operation
    func test2(){
        
        var op1 = BlockOperation { [weak self] in
            print("block op1")
            self?.age += 1
        }
        
        op1.completionBlock = {
            print("finish op1")
        }
        
        var op2 = BlockOperation{
            print("block op2")
        }
        
        op2.completionBlock = {
            print("finish op2")
        }
        
        var queue = OperationQueue()
        queue.addOperation(op1)
        queue.addOperation(op2)
    }
    
    func test3(){
        let myop = MyOperation()
        OperationQueue().addOperation(myop)
    }
    
    @objc func threadAction(){
        print("多线程创建方式二")
    }
}


func thead_1(){
    
    Thread.detachNewThread {
        print("多线程创建方式一")
    }
    
    var t2 = ThreadObject()
    t2.test1()
}


/**
 有三个网络请求，都完成后刷新UI
 */
func thread_2(){
    
    let group = dispatch_group_t()
    
    let job1 = DispatchWorkItem {
        print("job1")
    }
    
    
    
}

class MutltiReadAndSingleWrite{
    
    let queue = DispatchQueue(label: "work", qos: .default, attributes: .concurrent, autoreleaseFrequency: .inherit, target: nil)
    
    let queue2 = DispatchQueue.global()
     
    let queue3 = DispatchQueue.main
    
    var datas: [Int] = [Int](0...100)
    
    func getFirst() -> Int?{
        var value: Int? = nil
        queue.sync {
            value = datas.first
        }
        return value
    }
    
    
    func removeFirstIndex(){
        let workItem = DispatchWorkItem(flags: DispatchWorkItemFlags.barrier) {
            self.datas.removeFirst()
        }
        queue.sync(execute: workItem)
    }
    
}


func 延迟执行(){
    DispatchQueue.main.asyncAfter(deadline: .now() + 2.5, execute: {
        print("延迟2.5秒执行任务")
    })
}

func groupTest(){
    
    
}
