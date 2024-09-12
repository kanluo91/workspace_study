//
//  ViewController.m
//  ARM64
//
//  Created by luokan on 2024/9/5.
//  汇编指令学习

#import "ViewController.h"
#import "arm64.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.view.backgroundColor = UIColor.whiteColor;
    NSLog(@"-----------执行代码了-----------");
    test1();
    int value1 = add(2, 4);
    int value2 = sub(3, 1);
    cmptest(3, 2);
    NSLog(@"add(2,4) = %d\nsub(3,1) = %d\n",value1,value2);
}

@end
