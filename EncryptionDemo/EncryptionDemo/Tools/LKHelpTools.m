//
//  LKHelpTools.m
//  EncryptionDemo
//
//  Created by luokan on 2024/9/12.
//

#import "LKHelpTools.h"

@implementation LKHelpTools

+(BOOL) isStrEmpty:(NSString *)string{
    if ([string isEqual:@"NULL"] || [string isKindOfClass:[NSNull class]] || [string isEqual:[NSNull null]] || [string isEqual:NULL] || [[string class] isSubclassOfClass:[NSNull class]] || string == nil || string == NULL || [string isKindOfClass:[NSNull class]] || [[string stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceAndNewlineCharacterSet]] length]==0 || [string isEqualToString:@"<null>"] || [string isEqualToString:@"(null)"]) {
        return YES;
    } else {
        return NO;
    }
}

@end
