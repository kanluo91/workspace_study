LOCAL_PATH := $(call my-dir) # 获取jni文件路径
include $(CLEAR_VARS) # 清理以LOCAL开头的一些配置
LOCAL_ARM_MODE := arm # 编译后的指令集
LOCAL_MODULE := jingjiaodawang #  定义模块的名称
LOCAL_SRC_FILES := jingjiaodawang.c #  源文件



include $(BUILD_EXECUTABLE) # 构建成可执行程序 （so = shared library）(静态链接库和 static library) 
