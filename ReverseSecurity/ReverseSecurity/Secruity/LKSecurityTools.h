//
//  LKSecurityTools.h
//  ReverseSecurity
//
//  Created by luokan on 2024/7/20.
//  加密工具

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface LKSecurityTools : NSObject

+(NSString *) md5With:(NSString *)inputStr;

@end

NS_ASSUME_NONNULL_END
