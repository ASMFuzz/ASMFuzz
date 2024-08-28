@@ -1425,10 +1425,10 @@ Java_sun_awt_X11GraphicsDevice_getDoubleBufferVisuals(JNIEnv *env,
     AWT_FLUSH_UNLOCK();
     for (i = 0; i < visScreenInfo->count; i++) {
         XdbeVisualInfo* visInfo = visScreenInfo->visinfo;
-        (*env)->CallVoidMethod(env, this, midAddVisual, (visInfo[i]).visual);
         if ((*env)->ExceptionCheck(env)) {
             break;
         }
+        (*env)->CallVoidMethod(env, this, midAddVisual, (visInfo[i]).visual);
     }
     AWT_LOCK();
     XdbeFreeVisualInfo(visScreenInfo);