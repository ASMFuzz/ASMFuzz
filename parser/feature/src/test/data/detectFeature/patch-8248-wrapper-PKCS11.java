@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 
 /* Copyright  (c) 2002 Graz University of Technology. All rights reserved.
@@ -47,7 +47,6 @@
 
 package sun.security.pkcs11.wrapper;
 
-import java.lang.ref.Cleaner;
 import java.io.File;
 import java.io.IOException;
 import java.util.*;
@@ -57,6 +56,7 @@
 
 import sun.security.util.Debug;
 
+import sun.security.pkcs11.P11Util;
 import static sun.security.pkcs11.wrapper.PKCS11Constants.*;
 import static sun.security.pkcs11.wrapper.PKCS11Exception.RV.*;
 
@@ -112,6 +112,9 @@ public static void loadNative() {
      */
     private final String pkcs11ModulePath;
     private final CK_VERSION version;
+
+    // Note: Please don't update this field other than the constructor.
+    // Otherwise, the native data is not able to be collected.
     private long pNativeData;
 
     /**
@@ -164,7 +167,7 @@ public static void loadNative() {
         }
 
         // Calls disconnect() to cleanup the native part of the wrapper.
-        Cleaner.create().register(this, this::disconnect);
+        P11Util.cleaner.register(this, releaserFor(pNativeData));
     }
 
     public CK_VERSION getVersion() {
@@ -200,11 +203,19 @@ public static synchronized PKCS11 getInstance(String pkcs11ModulePath,
         return pkcs11;
     }
 
+    private static Runnable releaserFor(long pNativeData) {
+        return () -> {
+            if (pNativeData != 0) {
+                PKCS11.disconnect(pNativeData);
+            }
+        };
+    }
+
     /**
      * Connects this object to the specified PKCS#11 library. This method is for
      * internal use only.
      * Declared private, because incorrect handling may result in errors in the
-     * native part.
+     * native part.  Please don't use this method other than the constructor.
      *
      * @param pkcs11ModulePath The PKCS#11 library path.
      * @param functionList the method name for retrieving the PKCS#11
@@ -220,14 +231,16 @@ private native CK_VERSION connect(String pkcs11ModulePath,
      * Disconnects the PKCS#11 library from this object. After calling this
      * method, this object is no longer connected to a native PKCS#11 module
      * and any subsequent calls to C_ methods will fail. This method is for
-     * internal use only.
+     * internal use only.  Please don't use this method other than finalization
+     * as implemented in the releaserFor() method.
+     *
      * Declared private, because incorrect handling may result in errors in the
      * native part.
      *
      * @preconditions
      * @postconditions
      */
-    private native void disconnect();
+    private static native void disconnect(long pNativeData);
 
 
     // Implementation of PKCS11 methods delegated to native pkcs11wrapper library