@@ -188,6 +188,13 @@ Java_sun_nio_ch_FileChannelImpl_transferTo0(JNIEnv *env, jobject this,
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