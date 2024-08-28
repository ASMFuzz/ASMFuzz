@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -36,20 +36,16 @@
 #include <Mswsock.h>
 #pragma comment(lib, "Mswsock.lib")
 
-static jfieldID chan_fd; /* id for jobject 'fd' in java.io.FileChannel */
-
 /**************************************************************
- * static method to store field ID's in initializers
- * and retrieve the allocation granularity
+ * static method to retrieve the allocation granularity
  */
 JNIEXPORT jlong JNICALL
-Java_sun_nio_ch_FileChannelImpl_initIDs(JNIEnv *env, jclass clazz)
+Java_sun_nio_ch_FileChannelImpl_allocationGranularity0(JNIEnv *env, jclass clazz)
 {
     SYSTEM_INFO si;
     jint align;
     GetSystemInfo(&si);
     align = si.dwAllocationGranularity;
-    chan_fd = (*env)->GetFieldID(env, clazz, "fd", "Ljava/io/FileDescriptor;");
     return align;
 }
 
@@ -59,7 +55,7 @@ Java_sun_nio_ch_FileChannelImpl_initIDs(JNIEnv *env, jclass clazz)
  */
 
 JNIEXPORT jlong JNICALL
-Java_sun_nio_ch_FileChannelImpl_map0(JNIEnv *env, jobject this,
+Java_sun_nio_ch_FileChannelImpl_map0(JNIEnv *env, jobject this, jobject fdo,
                                      jint prot, jlong off, jlong len, jboolean map_sync)
 {
     void *mapAddress = 0;
@@ -68,7 +64,6 @@ Java_sun_nio_ch_FileChannelImpl_map0(JNIEnv *env, jobject this,
     jlong maxSize = off + len;
     jint lowLen = (jint)(maxSize);
     jint highLen = (jint)(maxSize >> 32);
-    jobject fdo = (*env)->GetObjectField(env, this, chan_fd);
     HANDLE fileHandle = (HANDLE)(handleval(env, fdo));
     HANDLE mapping;
     DWORD mapAccess = FILE_MAP_READ;