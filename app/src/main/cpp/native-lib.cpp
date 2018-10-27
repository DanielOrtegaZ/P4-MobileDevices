#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_a3cv6_escom_ipn_mx_login_NativeStore_stringFromJNI(JNIEnv *env, jobject /* this */){

    std::string hello = "Nombre:";
    return env->NewStringUTF(hello.c_str());

}
