//
//  ViewController.m
//  TestSign
//
//  Created by luokan on 2024/9/10.
//

#import "ViewController.h"

int num = 10;

@interface ViewController ()

@property (nonatomic,strong) UILabel *showLbl;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.view.backgroundColor = UIColor.whiteColor;
    self.showLbl = [UILabel new];
    self.showLbl.textColor = UIColor.redColor;
    self.showLbl.frame = CGRectMake(100, 100, 200, 100);
    self.showLbl.text = [NSString stringWithFormat:@"测试重签名 : %d",num];
    [self.view addSubview:self.showLbl];
}


@end
