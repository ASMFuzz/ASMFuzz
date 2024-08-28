@@ -30,7 +30,14 @@
 
 #include <jni.h>
 #include <netinet/tcp.h>
+
+#define __APPLE_USE_RFC_3542
 #include <netinet/in.h>
+
+#ifndef IP_DONTFRAG
+#define IP_DONTFRAG             28
+#endif
+
 #include "jni_util.h"
 
 /*
@@ -170,3 +177,60 @@ JNIEXPORT jint JNICALL Java_jdk_net_MacOSXSocketOptions_getTcpKeepAliveIntvl0
     handleError(env, rv, "get option TCP_KEEPINTVL failed");
     return optval;
 }
+
+static int socketFamily(jint fd) {
+    struct sockaddr_storage st;
+    struct sockaddr* sa = (struct sockaddr *)&st;
+    socklen_t sa_len = sizeof(st);
+
+    if (getsockname(fd, sa, &sa_len) == 0) {
+        return sa->sa_family;
+    }
+    return -1;
+}
+
+/*
+ * Class:     jdk_net_MacOSXSocketOptions
+ * Method:    setIpDontFragment0
+ * Signature: (IZ)V
+ */
+JNIEXPORT void JNICALL Java_jdk_net_MacOSXSocketOptions_setIpDontFragment0
+(JNIEnv *env, jobject unused, jint fd, jboolean optval) {
+    jint rv;
+    jint family = socketFamily(fd);
+    jint value = optval ? 1 : 0;
+
+    if (family == -1) {
+        handleError(env, family, "get socket family failed");
+        return;
+    }
+    if (family == AF_INET) {
+        rv = setsockopt(fd, IPPROTO_IP, IP_DONTFRAG, &value, sizeof(value));
+    } else {
+        rv = setsockopt(fd, IPPROTO_IPV6, IPV6_DONTFRAG, &value, sizeof(value));
+    }
+    handleError(env, rv, "set option IP_DONTFRAGMENT failed");
+}
+
+/*
+ * Class:     jdk_net_MacOSXSocketOptions
+ * Method:    getIpDontFragment0
+ * Signature: (I)Z;
+ */
+JNIEXPORT jboolean JNICALL Java_jdk_net_MacOSXSocketOptions_getIpDontFragment0
+(JNIEnv *env, jobject unused, jint fd) {
+    jint optval, rv;
+    socklen_t sz = sizeof (optval);
+    jint family = socketFamily(fd);
+    if (family == -1) {
+        handleError(env, family, "get socket family failed");
+        return 0;
+    }
+    if (family == AF_INET) {
+        rv = getsockopt(fd, IPPROTO_IP, IP_DONTFRAG, &optval, &sz);
+    } else {
+        rv = getsockopt(fd, IPPROTO_IPV6, IPV6_DONTFRAG, &optval, &sz);
+    }
+    handleError(env, rv, "get option IP_DONTFRAGMENT failed");
+    return optval;
+}