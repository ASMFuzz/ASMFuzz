@@ -243,3 +243,65 @@ JNIEXPORT jint JNICALL Java_jdk_net_LinuxSocketOptions_getIncomingNapiId0
     handleError(env, rv, "get option SO_INCOMING_NAPI_ID failed");
     return optval;
 }
+
+static int socketFamily(jint fd) {
+    struct sockaddr_storage st;
+    struct sockaddr *sa = (struct sockaddr *)&st;
+    socklen_t sa_len = sizeof(st);
+
+    if (getsockname(fd, sa, &sa_len) == 0) {
+        return sa->sa_family;
+    }
+    return -1;
+}
+
+/*
+ * Class:     jdk_net_LinuxSocketOptions
+ * Method:    setIpDontFragment0
+ * Signature: (IZ)V
+ */
+JNIEXPORT void JNICALL Java_jdk_net_LinuxSocketOptions_setIpDontFragment0
+(JNIEnv *env, jobject unused, jint fd, jboolean optval) {
+    jint rv, optsetting;
+    jint family = socketFamily(fd);
+    if (family == -1) {
+        handleError(env, family, "get socket family failed");
+        return;
+    }
+
+    optsetting = optval ? IP_PMTUDISC_DO : IP_PMTUDISC_DONT;
+
+    if (family == AF_INET) {
+        rv = setsockopt(fd, IPPROTO_IP, IP_MTU_DISCOVER, &optsetting, sizeof (optsetting));
+    } else {
+        rv = setsockopt(fd, IPPROTO_IPV6, IPV6_MTU_DISCOVER, &optsetting, sizeof (optsetting));
+    }
+    handleError(env, rv, "set option IP_DONTFRAGMENT failed");
+}
+
+/*
+ * Class:     jdk_net_LinuxSocketOptions
+ * Method:    getIpDontFragment0
+ * Signature: (I)Z;
+ */
+JNIEXPORT jboolean JNICALL Java_jdk_net_LinuxSocketOptions_getIpDontFragment0
+(JNIEnv *env, jobject unused, jint fd) {
+    jint optlevel, optname, optval, rv;
+    jint family = socketFamily(fd);
+    if (family == -1) {
+        handleError(env, family, "get socket family failed");
+        return JNI_FALSE;
+    }
+
+    if (family == AF_INET) {
+        optlevel = IPPROTO_IP;
+        optname = IP_MTU_DISCOVER;
+    } else {
+        optlevel = IPPROTO_IPV6;
+        optname = IPV6_MTU_DISCOVER;
+    }
+    socklen_t sz = sizeof(optval);
+    rv = getsockopt(fd, optlevel, optname, &optval, &sz);
+    handleError(env, rv, "get option IP_DONTFRAGMENT failed");
+    return optval == IP_PMTUDISC_DO ? JNI_TRUE : JNI_FALSE;
+}