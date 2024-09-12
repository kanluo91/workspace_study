//
//  LKEncryptionTools.m
//  EncryptionDemo
//
//  Created by luokan on 2024/9/12.
//

#import "LKEncryptionTools.h"
#import "LKHelpTools.h"

@implementation LKEncryptionTools

+(NSString *) base64Encode:(NSString *)plainText{
    
    if(![LKHelpTools isStrEmpty:plainText]){
        NSData *data = [plainText dataUsingEncoding:NSUTF8StringEncoding];
        return [data base64EncodedStringWithOptions:0];
    }
    
    return nil;
}

+(NSString *) base64Decode:(NSString *)base64Str{
    
    if(![LKHelpTools isStrEmpty:base64Str]){
    
        NSData *data = [[NSData alloc] initWithBase64EncodedString:base64Str options:0];
        NSString *plainText = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
        return plainText;
    }
    
    return nil;
}

@end
