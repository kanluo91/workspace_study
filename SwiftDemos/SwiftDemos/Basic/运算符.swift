//
//  运算符.swift
//  SwiftDemos
//
//  Created by luokan on 2024/8/12.
//

import UIKit


class 运算符:UIViewController{
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .white
        self.title = "运算符案例"
        
        
        /** 1. 3元运算符 ？
         
         它的形式是 问题 ? 答案 1 : 答案 2。它简洁地表达根据 问题成立与否作出二选一的操作。如果 问题 成立，返回 答案 1 的结果；反之返回 答案 2 的结果。
         */
        
        let isfirst = false
        let welcome = isfirst ?  "欢迎第一次进入" : "欢迎光临"
        print(welcome)
        
        /** 2. Swift 中的??运算符, 官方称之为Nil Coalescing Operator, 中文常被译作空合运算符.
         在表达式 a ?? b 中, 将对可选类型 a 进行空判断，如果 a 包含一个值就进行解包，否则就返回一个默认值 b。表达式 a 必须是 Optional 类型。默认值 b 的类型必须要和 a 存储值的类型保持一致。
         
         等价值于
         // 无疑空合运算符（??）提供了一种更为优雅的方式去封装条件判断和解包两种行为，显得简洁以及更具可读性。
         a != nil ? a! : b

         */
        
        var a:String? = nil
        var b = a ?? "world"
        
        print(a) // nil
        print(b) // world
        
        
        /** 3. guard  条件不为真，则执行else 里面的
         
         */
        
        let username: String? =  "jin jiao"
        
        guard let value = username else{
            print("guard 判定登录失败  执行了else")
            return;
        }
        
        print("guard 判定登录成功  跳过了else \(value)")
    }
}
