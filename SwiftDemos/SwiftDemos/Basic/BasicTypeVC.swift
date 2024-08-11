//
//  BasicTypeVC.swift
//  SwiftDemos
//
//  Created by luokan on 2024/8/11.
//

import UIKit
import Foundation

class BasicTypeVC : UIViewController{
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .white;
        self.title = "基础数据类型"
        
    // 1. 变量
        var a:Int = 100
        a = 200
        
    //2. 常量
        let a1: Float = 100.0
//        b = 101  常量初始化后不能修改
        NSLog("变量 \(a) 常量\(a1)",a,a1)
        
        
    //3. 数据类型 和 字节数
        let b0 = 123
        let b1:Int = 112321
        let b2:Int8 = 127
        let b3:Int16 = 1
        let b4:Int32 = 1
        let b5:Int64 = 1
        let b6:Int = 1
        let b7:Float = 1.0
        let b8:Double = 1.1
        let b9:String = "hello"
        let b10:Bool = true
        let b11:(Int,String) = (1,"hello")
        _ = type(of: b0)
        
        NSLog("[b0] = %d", MemoryLayout.size(ofValue: b0))
        NSLog("[b1] = %d", MemoryLayout.size(ofValue: b1))
        NSLog("[b2] = %d", MemoryLayout.size(ofValue: b2))
        NSLog("[b3] = %d", MemoryLayout.size(ofValue: b3))
        NSLog("[b4] = %d", MemoryLayout.size(ofValue: b4))
        NSLog("[b5] = %d", MemoryLayout.size(ofValue: b5))
        NSLog("[b6] = %d", MemoryLayout.size(ofValue: b6))
        NSLog("[b7] = %d", MemoryLayout.size(ofValue: b7))
        NSLog("[b8] = %d", MemoryLayout.size(ofValue: b8))
        NSLog("[b9] = %d", MemoryLayout.size(ofValue: b9))
        NSLog("[b10] = %d", MemoryLayout.size(ofValue:b10))
        NSLog("[b11] = %d", MemoryLayout.size(ofValue:b11))
        
        /** 字节数
         [b0] = 8
         [b1] = 8
         [b2] = 1
         [b3] = 2
         [b4] = 4
         [b5] = 8
         [b6] = 8
         [b7] = 4
         [b8] = 8
         [b9] = 16
         [b10] = 1
         [b11] = 24
         */

    }
}
