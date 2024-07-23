//
//  ViewController.swift
//  SwiftDemos
//
//  Created by luokan on 2024/7/20.
//

import UIKit

class ViewController: UIViewController {
    
    var datas: [String] {
        return ["泛型","多线程"]
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .white
        self.title = "swift 学习"
        
        let tableV = UITableView(frame: self.view.frame)
//        tableV.backgroundColor = .green
        tableV.delegate = self
        tableV.dataSource = self
        self.view.addSubview(tableV)
    }

}

extension ViewController : UITableViewDataSource, UITableViewDelegate{
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.datas.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        var cell = UITableViewCell(style: .default, reuseIdentifier: "12313")
        cell.textLabel?.text = self.datas[indexPath.row]
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        泛型_test1()
        
        
    }
    
}
