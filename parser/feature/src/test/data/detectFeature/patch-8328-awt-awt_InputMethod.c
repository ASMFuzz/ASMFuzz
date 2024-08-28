@@ -992,7 +992,7 @@ createXIC(JNIEnv * env, X11InputMethodData *pX11IMData, Window w)
         pX11IMData->ic_passive = pX11IMData->ic_active;
     }
 
-    // The code set the IC mode that the preedit state is not initialied
+    // The code set the IC mode that the preedit state is not initialized
     // at XmbResetIC.  This attribute can be set at XCreateIC.  I separately
     // set the attribute to avoid the failure of XCreateIC at some platform
     // which does not support the attribute.