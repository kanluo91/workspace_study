//
//  集合类型.swift
//  SwiftDemos
//
//  Created by luokan on 2024/8/12.
//

import UIKit

class 集合类型: UIViewController{
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .white
        self.title = "集合案例"
        
//        array_demo()
//        sets_demo()
        dictionary_demo(age: 12,22);
    }
        
    func array_demo() -> Void{
        
        var array1 = [Int]()
        var array2:[Int] = [Int]();
        let array3:[Int] = []
        let array4:[Int] = Array(repeating: 1, count: 10)
        
        
        array1.append(1)
        array1.append(2)
        
        array2.append(1)
        array2.append(2)

        var array5 = array1 + array2 + array3 + array4 + array4
        
        // Swift/ContiguousArrayBuffer.swift:600: Fatal error: Index out of range  (角标越界)
        var value1 = array5[0]
        var value2 = array5[3...9]
        var value3 = array5[array5.startIndex...array5.endIndex-2]
        
        let isEmptyStr = array3.isEmpty ? "array3空数组":"array3非空数组"
        print(isEmptyStr)
        print(array5)
        print(value1)
        print(value2)
        print(value3)
        
        for item in array5{
            print(item)
        }
        
        for (index,item) in array5.enumerated(){
            print("array[\(index)] = \(item)")
        }
        
        for index in array5.indices{
            print("角标 = \(index)")
        }
        
        
        // 看array 是值类型 还是引用类型   结果: 值类型
        var array7:[String]?
        var array8:[String] = ["hello" , "world"]
        array7 = array8
        array7?[0] = "你好"
        
        print(array7) // ["你好", "world"]
        print(array8) // ["hello", "world"]
        
    }
    
    func sets_demo(){
        
        var set1 = Set<Int>()
        var set2:Set<String> = ["hello","world"]
        var set3 = Set<Double>()
        var set4 = Set<Character>()
        
        set2.insert("!")
        set2.insert("?")
        var isempty = set2.isEmpty
        let cnt = set2.count
        
        set2.remove("?")
        if let index = set2.firstIndex(of: "!"){
            var popvalue = set2.remove(at: index)
            print("pop \(popvalue)")
        }

        print(set2)
        
        
        /**
         使用“是否相等”运算符（==）来判断两个集合包含的值是否全部相同。
         使用 isSubset(of:) 方法来判断一个集合中的所有值是否也被包含在另外一个集合中。
         使用 isSuperset(of:) 方法来判断一个集合是否包含另一个集合中所有的值。
         使用 isStrictSubset(of:) 或者 isStrictSuperset(of:) 方法来判断一个集合是否是另外一个集合的子集合或者父集合并且两个集合并不相等。
         使用 isDisjoint(with:) 方法来判断两个集合是否不含有相同的值（是否没有交集）。
         */
        let houseAnimals: Set = ["🐶", "🐱"]
        let farmAnimals: Set = ["🐮", "🐔", "🐑", "🐶", "🐱"]
        let cityAnimals: Set = ["🐦", "🐭"]

        houseAnimals.isSubset(of: farmAnimals)
        // true
        farmAnimals.isSuperset(of: houseAnimals)
        // true
        farmAnimals.isDisjoint(with: cityAnimals)
        // true
        
    }
    
    func dictionary_demo(at name:String = "kk", age:Int...){
        
        // 一个字典的 Key 类型必须遵循 Hashable 协议，就像 Set 的值类型。
        let dict1 = [Int:String]()
        var dict2:[String:Any] = [:]
        print(dict2.isEmpty ? "dict2空":"dict2非空")
        
        dict2["name"] = name
        dict2["age"] = age[1]
        dict2.updateValue("fuck", forKey: "nickname")
        print(dict2)
        
        for key in dict2.keys{
            print("keys = \(key)")
        }
        
        for value in dict2.values{
            print("values = \(value)")
        }
        
        for (key,value) in dict2{
            print("dict[\(key)] = \(value)")
        }
        
        for (index,item) in dict2.enumerated(){
            print("index = \(index) item = \(item)")
        }
        
        for (index,(key,value)) in dict2.enumerated(){
            print("index = \(index) item[\(key)] = \(value)")
        }
    }
    
}
