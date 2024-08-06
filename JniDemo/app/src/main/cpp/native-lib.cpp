#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jnidemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_jnidemo_MainActivity_jniadd(JNIEnv *env,jobject,jint a,jint b){
    return a + b;
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_jnidemo_MainActivity_checkUserNameAndPwd(JNIEnv *env, jobject thiz,
                                                          jstring username, jstring pwd) {
    if(username == nullptr || pwd == nullptr){
        return JNI_FALSE;
    }

    jsize username_lengthsize = env->GetStringLength(username);
    jsize pwd_lengthsize = env->GetStringLength(pwd);

    if(username_lengthsize <= 0 || pwd_lengthsize <= 0){
        return JNI_FALSE;
    }

    return JNI_TRUE;
}

extern "C"
JNIEXPORT jboolean JNICALL Java_com_example_jnidemo_MainActivity_compareStrings(JNIEnv *env, jobject obj, jstring jstr1, jstring jstr2) {
    const char *cstr1 = NULL;
    const char *cstr2 = NULL;
    jboolean retVal = JNI_FALSE; // JNI_FALSE 相当于 C 中的 false

    // 确保字符串不为空
    if (jstr1 != NULL && jstr2 != NULL) {
        cstr1 = env->GetStringUTFChars(jstr1, JNI_FALSE);
        cstr2 = env->GetStringUTFChars(jstr2, JNI_FALSE);

        // 比较C字符串
        if (cstr1 != NULL && cstr2 != NULL && strcmp(cstr1, cstr2) == 0) {
            retVal = JNI_TRUE; // JNI_TRUE 相当于 C 中的 true
        }

        // 释放字符串
        env->ReleaseStringUTFChars(jstr1, cstr1);
        env->ReleaseStringUTFChars(jstr2, cstr2);
    }

    return retVal;
}