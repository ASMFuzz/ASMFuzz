@@ -246,6 +246,7 @@ Java_sun_print_CUPSPrinter_getCupsDefaultPrinters(JNIEnv *env,
     for (i = 0; i < num_dests; i++) {
             utf_str = JNU_NewStringPlatform(env, dests[i].name);
             if (utf_str == NULL) {
+                (*env)->ExceptionClear(env);
                 for (j = i - 1; j >= 0; j--) {
                     utf_str = (*env)->GetObjectArrayElement(env, nameArray, j);
                     (*env)->SetObjectArrayElement(env, nameArray, j, NULL);
@@ -345,8 +346,9 @@ Java_sun_print_CUPSPrinter_getMedia(JNIEnv *env,
             unlink(filename);
             j2d_ppdClose(ppd);
             DPRINTF("CUPSfuncs::bad alloc new array\n", "")
-            (*env)->ExceptionClear(env);
-            JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+            if (!(*env)->ExceptionCheck(env)) {
+                JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+            }
             return NULL;
         }
 
@@ -357,7 +359,9 @@ Java_sun_print_CUPSPrinter_getMedia(JNIEnv *env,
                 unlink(filename);
                 j2d_ppdClose(ppd);
                 DPRINTF("CUPSfuncs::bad alloc new string ->text\n", "")
-                JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                if (!(*env)->ExceptionCheck(env)) {
+                    JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                }
                 return NULL;
             }
             (*env)->SetObjectArrayElement(env, nameArray, i*2, utf_str);
@@ -367,7 +371,9 @@ Java_sun_print_CUPSPrinter_getMedia(JNIEnv *env,
                 unlink(filename);
                 j2d_ppdClose(ppd);
                 DPRINTF("CUPSfuncs::bad alloc new string ->choice\n", "")
-                JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                if (!(*env)->ExceptionCheck(env)) {
+                    JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                }
                 return NULL;
             }
             (*env)->SetObjectArrayElement(env, nameArray, i*2+1, utf_str);
@@ -381,7 +387,9 @@ Java_sun_print_CUPSPrinter_getMedia(JNIEnv *env,
                 unlink(filename);
                 j2d_ppdClose(ppd);
                 DPRINTF("CUPSfuncs::bad alloc new string text\n", "")
-                JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                if (!(*env)->ExceptionCheck(env)) {
+                    JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                }
                 return NULL;
             }
             (*env)->SetObjectArrayElement(env, nameArray,
@@ -392,7 +400,9 @@ Java_sun_print_CUPSPrinter_getMedia(JNIEnv *env,
                 unlink(filename);
                 j2d_ppdClose(ppd);
                 DPRINTF("CUPSfuncs::bad alloc new string choice\n", "")
-                JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                if (!(*env)->ExceptionCheck(env)) {
+                    JNU_ThrowOutOfMemoryError(env, "OutOfMemoryError");
+                }
                 return NULL;
             }
             (*env)->SetObjectArrayElement(env, nameArray,