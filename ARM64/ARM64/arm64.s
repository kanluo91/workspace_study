//
//  arm64.s
//  ARM64
//
//  Created by luokan on 2024/9/5.
//

.text           // 声明一个代码段
.global _test1, _add, _sub, _cmptest // 公开test1 函数

_test1:
mov x0, #0x1   // 立即数 0x1 赋值给寄存器 x0
mov x1, #0x2
add x2, x0, x1 // x2 = x0 + x1
sub x3, x2, x0 // x3 = x2 - x0
ret


_add:
add x0, x0, x1
ret

_sub:
sub x0, x0, x1
ret

_cmptest:
cmp x0, x1  // cspr = x0 - x1

mycode1:
ret

mycode2:
ret

ret

