@@ -295,6 +295,7 @@ getAllConfigs (JNIEnv *env, int screen, AwtScreenDataPtr screenDataPtr) {
     // NB: should be invoked only while holding the AWT lock
     DASSERT(screen >= 0 && screen < awt_numScreens);
 
+    jboolean success = JNI_FALSE;
     int i;
     int n8p=0, n12p=0, n8s=0, n8gs=0, n8sg=0, n1sg=0, nTrue=0;
     int nConfig;
@@ -565,10 +566,14 @@ getAllConfigs (JNIEnv *env, int screen, AwtScreenDataPtr screenDataPtr) {
                 sizeof (XVisualInfo));
     }
 
+    success = JNI_TRUE;
     screenDataPtr->numConfigs = nConfig;
     screenDataPtr->configs = graphicsConfigs;
 
 cleanup:
+    if (success != JNI_TRUE) {
+        free(graphicsConfigs);
+    }
     if (n8p != 0)
        XFree (pVI8p);
     if (n12p != 0)