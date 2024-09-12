//
//  ViewController.m
//  EncryptionDemo
//
//  Created by luokan on 2024/9/12.
//

#import "ViewController.h"
#import "LKEncryptionTools.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.view.backgroundColor = [UIColor whiteColor];
    
    NSString *base64Str =  [LKEncryptionTools base64Encode:@"he"];
    NSString *plainText = [LKEncryptionTools base64Decode:base64Str];
    
    NSLog(@"[原文] = %@\n[Base64] = %@",plainText,base64Str);
    
}


@end
