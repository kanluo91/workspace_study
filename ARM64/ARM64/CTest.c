//
//  CTest.c
//  ARM64
//
//  Created by luokan on 2024/9/6.
//

#include "CTest.h"


// 叶子函数
void haha(void){
    int a = 2;
    int b = 3;
}


// 非叶子函数
void hehe(void){
    int a = 4;
    int b = 5;
    haha();
}
