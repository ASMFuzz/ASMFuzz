@@ -222,7 +222,7 @@ Java_sun_nio_ch_Net_listen(JNIEnv *env, jclass cl, jobject fdo, jint backlog)
 
 JNIEXPORT jint JNICALL
 Java_sun_nio_ch_Net_connect0(JNIEnv *env, jclass clazz, jboolean preferIPv6, jobject fdo,
-                             jobject iao, jint port)
+                             jobject iao, jint port, jboolean isBound)
 {
     SOCKETADDRESS sa;
     int rv;
@@ -250,6 +250,11 @@ Java_sun_nio_ch_Net_connect0(JNIEnv *env, jclass clazz, jboolean preferIPv6, job
         int err = WSAGetLastError();
         if (err == WSAEINPROGRESS || err == WSAEWOULDBLOCK) {
             return IOS_UNAVAILABLE;
+        } else if (isBound == JNI_TRUE && err == WSAEADDRINUSE) {
+            if (!(*env)->ExceptionOccurred(env)) {
+                JNU_ThrowByName(env, JNU_JAVANETPKG "ConnectException", "Address already in use: connect");
+            }
+            return IOS_THROWN;
         }
         NET_ThrowNew(env, err, "connect");
         return IOS_THROWN;