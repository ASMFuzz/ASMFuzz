@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -193,6 +193,13 @@ Java_sun_nio_ch_FileChannelImpl_transferTo0(JNIEnv *env, jobject this,
     return chunkSize;
 }
 
+JNIEXPORT jlong JNICALL
+Java_sun_nio_ch_FileChannelImpl_transferFrom0(JNIEnv *env, jobject this,
+                                              jobject srcFDO, jobject dstFDO,
+                                              jlong position, jlong count)
+{
+    return IOS_UNSUPPORTED;
+}
 
 JNIEXPORT jint JNICALL
 Java_sun_nio_ch_FileChannelImpl_maxDirectTransferSize0(JNIEnv* env, jobject this)