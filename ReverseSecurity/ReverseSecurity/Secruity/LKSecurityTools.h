//
//  LKSecurityTools.h
//  ReverseSecurity
//
//  Created by luokan on 2024/7/20.
//  加密工具

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface LKSecurityTools : NSObject

+(NSString *) md5:(NSString *)input;

+(NSString *) base64:(NSString *)input;

@end

NS_ASSUME_NONNULL_END
