//
//  LKEncryptionTools.h
//  EncryptionDemo
//
//  Created by luokan on 2024/9/12.
//  加解密工具

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface LKEncryptionTools : NSObject

+(NSString *) base64Encode:(NSString *)plainText;

+(NSString *) base64Decode:(NSString *)base64Str;


@end

NS_ASSUME_NONNULL_END
