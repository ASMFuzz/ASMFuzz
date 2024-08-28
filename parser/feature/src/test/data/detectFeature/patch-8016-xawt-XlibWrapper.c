@@ -2184,11 +2184,6 @@ Java_sun_awt_X11_XlibWrapper_copyLongArray(JNIEnv *env,
     }
 }
 
-JNIEXPORT jint JNICALL
-Java_sun_awt_X11_XlibWrapper_XSynchronize(JNIEnv *env, jclass clazz, jlong display, jboolean onoff)
-{
-    return (jint) XSynchronize((Display*)jlong_to_ptr(display), (onoff == JNI_TRUE ? True : False));
-}
 
 JNIEXPORT jboolean JNICALL
 Java_sun_awt_X11_XlibWrapper_XShapeQueryExtension