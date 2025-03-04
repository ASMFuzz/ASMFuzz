@@ -50,20 +50,28 @@ Java_sun_nio_ch_DatagramChannelImpl_disconnect0(JNIEnv *env, jclass clazz,
     jint fd = fdval(env, fdo);
     int rv;
 
+#if defined(__APPLE__)
+    // On macOS systems we use disconnectx
+    rv = disconnectx(fd, SAE_ASSOCID_ANY, SAE_CONNID_ANY);
+#else
     SOCKETADDRESS sa;
+    memset(&sa, 0, sizeof(sa));
+    #if defined(_ALLBSD_SOURCE)
+        sa.sa.sa_family = isIPv6 ? AF_INET6 : AF_INET;
+    #else
+        sa.sa.sa_family = AF_UNSPEC;
+    #endif
     socklen_t len = isIPv6 ? sizeof(struct sockaddr_in6) :
                              sizeof(struct sockaddr_in);
-
-    memset(&sa, 0, sizeof(sa));
-#if defined(_ALLBSD_SOURCE)
-    sa.sa.sa_family = isIPv6 ? AF_INET6 : AF_INET;
-#else
-    sa.sa.sa_family = AF_UNSPEC;
-#endif
-
     rv = connect(fd, &sa.sa, len);
+#endif
 
-#if defined(_ALLBSD_SOURCE)
+#if defined(_ALLBSD_SOURCE) && !defined(__APPLE__)
+    // On _ALLBSD_SOURCE except __APPLE__ we consider EADDRNOTAVAIL
+    // error to be OK and ignore it. __APPLE__ systems are excluded
+    // in this check since for __APPLE__ systems, unlike other BSD systems,
+    // we issue a "disconnectx" call (a few lines above),
+    // which isn't expected to return this error code.
     if (rv < 0 && errno == EADDRNOTAVAIL)
         rv = errno = 0;
 #elif defined(_AIX)